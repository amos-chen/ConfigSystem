package com.amos.pojo;

import java.util.Date;

public class ApplicationInfo {
    /**
     * 
     * 表字段 : application_info.id
     */
    private Integer id;

    /**
     * 
     * 表字段 : application_info.config_id
     */
    private Integer configId;

    /**
     * 
     * 表字段 : application_info.project_title
     */
    private String projectTitle;

    /**
     * 
     * 表字段 : application_info.application
     */
    private Integer application;

    /**
     * 
     * 表字段 : application_info.management_function
     */
    private Boolean managementFunction;

    /**
     * 
     * 表字段 : application_info.language
     */
    private String language;

    /**
     * 
     * 表字段 : application_info.create_time
     */
    private Date createTime;

    /**
     * 
     * 表字段 : application_info.update_time
     */
    private Date updateTime;

    /**
     *  构造查询条件,application_info
     */
    public ApplicationInfo(Integer id, Integer configId, String projectTitle, Integer application, Boolean managementFunction, String language, Date createTime, Date updateTime) {
        this.id = id;
        this.configId = configId;
        this.projectTitle = projectTitle;
        this.application = application;
        this.managementFunction = managementFunction;
        this.language = language;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    /**
     *  构造查询条件,application_info
     */
    public ApplicationInfo() {
        super();
    }

    /**
     * 获取  字段:application_info.id
     *
     * @return application_info.id, 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置  字段:application_info.id
     *
     * @param id the value for application_info.id, 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取  字段:application_info.config_id
     *
     * @return application_info.config_id, 
     */
    public Integer getConfigId() {
        return configId;
    }

    /**
     * 设置  字段:application_info.config_id
     *
     * @param configId the value for application_info.config_id, 
     */
    public void setConfigId(Integer configId) {
        this.configId = configId;
    }

    /**
     * 获取  字段:application_info.project_title
     *
     * @return application_info.project_title, 
     */
    public String getProjectTitle() {
        return projectTitle;
    }

    /**
     * 设置  字段:application_info.project_title
     *
     * @param projectTitle the value for application_info.project_title, 
     */
    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle == null ? null : projectTitle.trim();
    }

    /**
     * 获取  字段:application_info.application
     *
     * @return application_info.application, 
     */
    public Integer getApplication() {
        return application;
    }

    /**
     * 设置  字段:application_info.application
     *
     * @param application the value for application_info.application, 
     */
    public void setApplication(Integer application) {
        this.application = application;
    }

    /**
     * 获取  字段:application_info.management_function
     *
     * @return application_info.management_function, 
     */
    public Boolean getManagementFunction() {
        return managementFunction;
    }

    /**
     * 设置  字段:application_info.management_function
     *
     * @param managementFunction the value for application_info.management_function, 
     */
    public void setManagementFunction(Boolean managementFunction) {
        this.managementFunction = managementFunction;
    }

    /**
     * 获取  字段:application_info.language
     *
     * @return application_info.language, 
     */
    public String getLanguage() {
        return language;
    }

    /**
     * 设置  字段:application_info.language
     *
     * @param language the value for application_info.language, 
     */
    public void setLanguage(String language) {
        this.language = language == null ? null : language.trim();
    }

    /**
     * 获取  字段:application_info.create_time
     *
     * @return application_info.create_time, 
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置  字段:application_info.create_time
     *
     * @param createTime the value for application_info.create_time, 
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取  字段:application_info.update_time
     *
     * @return application_info.update_time, 
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置  字段:application_info.update_time
     *
     * @param updateTime the value for application_info.update_time, 
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "ApplicationInfo{" +
                "id=" + id +
                ", configId=" + configId +
                ", projectTitle='" + projectTitle + '\'' +
                ", application=" + application +
                ", managementFunction=" + managementFunction +
                ", language='" + language + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}