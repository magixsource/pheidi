# 背景
在日常工时中，人们少不了使用日程管理软件。比如我自己，在工程中使用的是阿里的钉钉，很多的会议和工作安排，日程上面一目了然，非常方便。但是工作不是我的全部，生活中，因为我使用的是Huawei手机，对手机上自带的日程应用也比较满意，所以使用的频率还是比较高的。无形中，这就造成了一个问题，我翻看手机上的日程安排时，是没有钉钉上面的工作计划的，恰好这时我需要查看工作安排时，我就不得不打开钉钉应用查看，如果查看日程这个场景在你的生活中的频率不高的话，那影响就不大，可是我个人碰到这个场景还是比较多的，每次都来回翻看日程，对照是不是有时间冲突，久而久之浪费的时候就比较多了，这令我非常不愉快，我决定改变这一状况。

# 业务模式

我简单分析了下日程管理的业务模式，目前每个操作系统上都有很多的日程管理应用，比如Google calendar，小米日历，微软的Calendar等，这些应用是分厂商分环境的。厂商开发出来的应用目前认为用户的日历数据应该是他们的资产，是不会轻易对外开放的。所以想要厂商主动将数据推送出来的可能性接近为零。
所以这里采用的是拉取的方式，由Collector采集器拉取软件程序的日程数据，再将数据发送到日程同步网关，网关接收到数据，会通知日程转换服务来将各厂商形式各一的数据转换为统一的数据格式，而后将数据存储在一个时间序列数据库中，最后采集器上的定时任务准实时的去服务器上拉取最新的日程信息，当有新消息时，写到对应的软件应用数据中，便于应用程序展示到最终用户。

# 技术设计
日程同步服务Pheidippides，简称Pheidi。核心由Herald和Translation组成，Herald负责数据的接收与广播；Translation负责将数据转换为统一标准。存储层面使用到Redis和InfluxDB，其中Redis主要作为轻量级消息中间件，而InfluxDB将负责将日程信息按时间存储起来。
## 模块设计
### 采集器
1. 负责获取应用程序日程数据并传输到日程同步网关
2. 负责准实时从广播服务拉取日程信息并写到对应的应用程序
3. 采集器与应用程序以及应用程序运时环境相关,按是否需要安装到运行环境分为云端采集与本地采集;按应用程序运行环境分为win、mac、android与ios;
### 日程同步网关：
1. 负责接收来自全球上千万的采集器的日程同步请求，写到消息中间件中，快速响应请求
2. 要求高吞吐、高性能、高可用并且易扩展
### 日程转换服务：
1. 从消息中间件中获取日程同步信息，并将日程信息按日程数据规范转换格式
2. 完成数据转换后，将转换后的数据存储到内存数据库
### 日程广播服务：
1. 接收来自采集器的日程同步请求，按请求参数中的时间戳返回该用户下所有的日程同步信息

## MVP
我认为我自己的需求就是一个最直接的产品MVP，实现钉钉与华为日程的数据同步，就可以验证程序的可行性了。所以这里我只需要开发钉钉日程的采集器和华为日程的采集器，并且实现日程同步网关、日程转换服务和日程广播服务就可以了。