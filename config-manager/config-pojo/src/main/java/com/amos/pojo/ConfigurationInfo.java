package com.amos.pojo;

import java.util.Date;
import java.util.List;

public class ConfigurationInfo {
    /**
     * 
     * 表字段 : configuration_info.id
     */
    private Integer id;

    /**
     * 
     * 表字段 : configuration_info.config_result_id
     */
    private Integer configResultId;

    /**
     * 
     * 表字段 : configuration_info.create_time
     */
    private Date createTime;

    /**
     * 
     * 表字段 : configuration_info.update_time
     */
    private Date updateTime;

    private ApplicationInfo applicationInfo;

    private EnvironmentInfo environmentInfo;

    private List<UpsInfo> upsInfos;

    private List<SmpsInfo> smpsInfos;

    private List<DirectCurrentPanelInfo> directCurrentPanelInfos;

    /**
     *  构造查询条件,configuration_info
     */
    public ConfigurationInfo(Integer id, Integer configResultId, Date createTime, Date updateTime) {
        this.id = id;
        this.configResultId = configResultId;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    /**
     *  构造查询条件,configuration_info
     */
    public ConfigurationInfo() {
        super();
    }

    /**
     * 获取  字段:configuration_info.id
     *
     * @return configuration_info.id, 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置  字段:configuration_info.id
     *
     * @param id the value for configuration_info.id, 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取  字段:configuration_info.config_result_id
     *
     * @return configuration_info.config_result_id, 
     */
    public Integer getConfigResultId() {
        return configResultId;
    }

    /**
     * 设置  字段:configuration_info.config_result_id
     *
     * @param configResultId the value for configuration_info.config_result_id, 
     */
    public void setConfigResultId(Integer configResultId) {
        this.configResultId = configResultId;
    }

    /**
     * 获取  字段:configuration_info.create_time
     *
     * @return configuration_info.create_time, 
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置  字段:configuration_info.create_time
     *
     * @param createTime the value for configuration_info.create_time, 
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取  字段:configuration_info.update_time
     *
     * @return configuration_info.update_time, 
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置  字段:configuration_info.update_time
     *
     * @param updateTime the value for configuration_info.update_time, 
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public ApplicationInfo getApplicationInfo() {
        return applicationInfo;
    }

    public void setApplicationInfo(ApplicationInfo applicationInfo) {
        this.applicationInfo=applicationInfo;
    }

    public EnvironmentInfo getEnvironmentInfo() {
        return environmentInfo;
    }

    public void setEnvironmentInfo(EnvironmentInfo environmentInfo) {
        this.environmentInfo=environmentInfo;
    }

    public List<UpsInfo> getUpsInfos() {
        return upsInfos;
    }

    public void setUpsInfos(List<UpsInfo> upsInfos) {
        this.upsInfos=upsInfos;
    }

    public List<SmpsInfo> getSmpsInfos() {
        return smpsInfos;
    }

    public void setSmpsInfos(List<SmpsInfo> smpsInfos) {
        this.smpsInfos=smpsInfos;
    }

    public List<DirectCurrentPanelInfo> getDirectCurrentPanelInfos() {
        return directCurrentPanelInfos;
    }

    public void setDirectCurrentPanelInfos(List<DirectCurrentPanelInfo> directCurrentPanelInfos) {
        this.directCurrentPanelInfos=directCurrentPanelInfos;
    }

    @Override
    public String toString() {
        return "ConfigurationInfo{" +
                "id=" + id +
                ", configResultId=" + configResultId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", applicationInfo=" + applicationInfo +
                ", environmentInfo=" + environmentInfo +
                ", upsInfos=" + upsInfos +
                ", smpsInfos=" + smpsInfos +
                ", directCurrentPanelInfos=" + directCurrentPanelInfos +
                '}';
    }
}