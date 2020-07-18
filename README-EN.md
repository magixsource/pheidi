# Background

In daily working hours, people have to use the schedule management software. For example, I use Ali's nails in the project. I have a lot of meetings and work arrangements. The schedule is clear and convenient. But my work is not my whole life. In my life, I use Huawei mobile phone and I am satisfied with the calendar application on my mobile phone, so I use it frequently. Invisibly, this has caused a problem. When I look at the schedule on my mobile phone, there is no work plan on the nail. Just when I need to check the work schedule, I have to open the nailing application to view it. If the frequency of checking the schedule is not high in your life, the impact is not great, but I personally encounter this scene is still relatively Yes, I have to go back and forth every time to check whether there is a time conflict. As time goes by, more time is wasted. This makes me very unhappy. I decided to change this situation.



# Business model



I briefly analyzed the business model of the next schedule management. At present, there are many schedule management applications on each operating system, such as Google Calendar, millet calendar, Microsoft calendar, etc. these applications are in the branch business environment. Applications developed by manufacturers currently believe that users' calendar data should be their assets and will not be easily opened to the public. Therefore, the possibility of manufacturers actively pushing data out is close to zero.

Therefore, the method of pulling is adopted here. The collector collector pulls the schedule data of software program, and then sends the data to the schedule synchronization gateway. The gateway will inform the schedule conversion service to convert the data of each manufacturer into a unified data format, and then store the data in a time series database. Finally, the timing information on the collector is set Be sure to pull the latest schedule information from the server in real time. When there is a new message, it is written to the corresponding software application data, so that the application program can be displayed to the end user.



# Technical design

The schedule synchronization service Pheidippides is called pheidi for short. Herald will be responsible for the integration of data and translation. Redis and influxdb are used in the storage layer. Redis is mainly used as a lightweight message middleware, while influxdb is responsible for storing the schedule information by time.

## Module design

### Collector

1. Get the application schedule data and transfer it to the schedule synchronization gateway

2. Be responsible for fetching schedule information from broadcast service in quasi real time and writing it to the corresponding application program

3. The collector is related to the application and the application runtime environment. It can be divided into cloud collection and local collection according to whether it needs to be installed in the running environment; it can be divided into win, MAC, Android and IOS according to the application running environment;

### Schedule synchronization gateway:

1. Responsible for receiving schedule synchronization requests from tens of millions of collectors around the world, writing them to message middleware and responding to requests quickly

2. High throughput, high performance, high availability and easy expansion are required

### Schedule conversion service:

The message format is converted from the message to the schedule

2. After completing the data conversion, store the converted data into the memory database

### Schedule broadcast service:

1. Receive the schedule synchronization request from the collector, and return all the schedule synchronization information of the user according to the timestamp in the request parameter



## MVP

I think my own requirement is the most direct product MVP. By synchronizing the data between pinning and Huawei's schedule, the feasibility of the program can be verified. So here I only need to develop the nailed schedule collector and Huawei schedule collector, and implement the schedule synchronization gateway, schedule conversion service and schedule broadcast service.