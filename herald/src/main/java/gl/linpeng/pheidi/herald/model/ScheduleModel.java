package gl.linpeng.pheidi.herald.model;

import javax.persistence.Table;
import java.util.Date;

/**
 * Schedule model
 *
 * @author lin.peng
 * @since 0.0.1
 */
@Table(name = "PHEIDI_SCHEDULE")
public class ScheduleModel extends BaseModel {

    /**
     * 标题
     */
    private String title;
    /**
     * 说明
     */
    private String description;
    /**
     * 日程开始时间
     */
    private Date startDateTime;
    /**
     * 日程结束时间
     */
    private Date endDateTime;
    /**
     * 日程目标
     */
    private String target;
    /**
     * 执行人名称
     */
    private String executorName;
    /**
     * 执行人联系方式
     */
    private String executorTel;
    /**
     * 日程分类类型: 约会、出差、会议、纪念日、休息日、休假、节日、其他
     */
    private String categoriesType;
    /**
     * 日程分类
     */
    private String categories;
    /**
     * 日程地理位置
     */
    private String addressGeo;
    /**
     * 日程位置
     */
    private String address;
    /**
     * 日程重复规则排除日期
     */
    private String ruleExcludeDate;
    /**
     * 日程重复规则
     */
    private String rule;
    /**
     * 日程状态 0制定中 1待执行 2 执行中 3完成 4暂停 5取消 6过期
     */
    private Integer status;
    /**
     * 日程提醒方式: AALARM音频 MALARM邮件 PALARM程序 TELARM短信
     */
    private String alarmType;
    /**
     * 日程提醒次数
     */
    private Integer alarmTimes;
    /**
     * 日程提醒时间
     */
    private Date alarmDate;
    /**
     * 日程重要程度： 0不重要 1一般 2重要 3最重要
     */
    private Integer essential;
    /**
     * 日程密级： 0私人 1公开 2私密
     */
    private Integer intensive;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Date startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Date getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(Date endDateTime) {
        this.endDateTime = endDateTime;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getExecutorName() {
        return executorName;
    }

    public void setExecutorName(String executorName) {
        this.executorName = executorName;
    }

    public String getExecutorTel() {
        return executorTel;
    }

    public void setExecutorTel(String executorTel) {
        this.executorTel = executorTel;
    }

    public String getCategoriesType() {
        return categoriesType;
    }

    public void setCategoriesType(String categoriesType) {
        this.categoriesType = categoriesType;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getAddressGeo() {
        return addressGeo;
    }

    public void setAddressGeo(String addressGeo) {
        this.addressGeo = addressGeo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRuleExcludeDate() {
        return ruleExcludeDate;
    }

    public void setRuleExcludeDate(String ruleExcludeDate) {
        this.ruleExcludeDate = ruleExcludeDate;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(String alarmType) {
        this.alarmType = alarmType;
    }

    public Integer getAlarmTimes() {
        return alarmTimes;
    }

    public void setAlarmTimes(Integer alarmTimes) {
        this.alarmTimes = alarmTimes;
    }

    public Date getAlarmDate() {
        return alarmDate;
    }

    public void setAlarmDate(Date alarmDate) {
        this.alarmDate = alarmDate;
    }

    public Integer getEssential() {
        return essential;
    }

    public void setEssential(Integer essential) {
        this.essential = essential;
    }

    public Integer getIntensive() {
        return intensive;
    }

    public void setIntensive(Integer intensive) {
        this.intensive = intensive;
    }
}
