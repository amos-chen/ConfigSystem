package com.amos.pojo;

import java.util.Date;

public class ConfigResult {
    /**
     * 
     * 表字段 : config_result.id
     */
    private Integer id;

    /**
     * 
     * 表字段 : config_result.title
     */
    private String title;

    /**
     * 
     * 表字段 : config_result.create_time
     */
    private Date createTime;

    /**
     * 
     * 表字段 : config_result.update_time
     */
    private Date updateTime;

    /**
     * 
     * 表字段 : config_result.config_data
     */
    private String configData;

    private ConfigurationInfo configurationInfo;

    /**
     *  构造查询条件,config_result
     */
    public ConfigResult(Integer id, String title, Date createTime, Date updateTime) {
        this.id = id;
        this.title = title;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    /**
     *  构造查询条件,config_result
     */
    public ConfigResult(Integer id, String title, Date createTime, Date updateTime, String configData) {
        this.id = id;
        this.title = title;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.configData = configData;
    }

    /**
     *  构造查询条件,config_result
     */
    public ConfigResult() {
        super();
    }

    /**
     * 获取  字段:config_result.id
     *
     * @return config_result.id, 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置  字段:config_result.id
     *
     * @param id the value for config_result.id, 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取  字段:config_result.title
     *
     * @return config_result.title, 
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置  字段:config_result.title
     *
     * @param title the value for config_result.title, 
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 获取  字段:config_result.create_time
     *
     * @return config_result.create_time, 
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置  字段:config_result.create_time
     *
     * @param createTime the value for config_result.create_time, 
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取  字段:config_result.update_time
     *
     * @return config_result.update_time, 
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置  字段:config_result.update_time
     *
     * @param updateTime the value for config_result.update_time, 
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取  字段:config_result.config_data
     *
     * @return config_result.config_data, 
     */
    public String getConfigData() {
        return configData;
    }

    /**
     * 设置  字段:config_result.config_data
     *
     * @param configData the value for config_result.config_data, 
     */
    public void setConfigData(String configData) {
        this.configData = configData == null ? null : configData.trim();
    }

    public ConfigurationInfo getConfigurationInfo() {
        return configurationInfo;
    }

    public void setConfigurationInfo(ConfigurationInfo configurationInfo) {
        this.configurationInfo=configurationInfo;
    }

    @Override
    public String toString() {
        return "ConfigResult{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", configData='" + configData + '\'' +
                ", configurationInfo=" + configurationInfo +
                '}';
    }
}