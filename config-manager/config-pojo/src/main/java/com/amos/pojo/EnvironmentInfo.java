package com.amos.pojo;

import java.util.Date;

public class EnvironmentInfo {
    /**
     * 
     * 表字段 : environment_info.id
     */
    private Integer id;

    /**
     * 
     * 表字段 : environment_info.config_id
     */
    private Integer configId;

    /**
     * 
     * 表字段 : environment_info.need_server
     */
    private Boolean needServer;

    /**
     * 
     * 表字段 : environment_info.need_gsm_modem
     */
    private Boolean needGsmModem;

    /**
     * 
     * 表字段 : environment_info.need_backup
     */
    private Boolean needBackup;

    /**
     * 
     * 表字段 : environment_info.battery_room_number
     */
    private Integer batteryRoomNumber;

    /**
     * 
     * 表字段 : environment_info.create_time
     */
    private Date createTime;

    /**
     * 
     * 表字段 : environment_info.update_time
     */
    private Date updateTime;

    /**
     *  构造查询条件,environment_info
     */
    public EnvironmentInfo(Integer id, Integer configId, Boolean needServer, Boolean needGsmModem, Boolean needBackup, Integer batteryRoomNumber, Date createTime, Date updateTime) {
        this.id = id;
        this.configId = configId;
        this.needServer = needServer;
        this.needGsmModem = needGsmModem;
        this.needBackup = needBackup;
        this.batteryRoomNumber = batteryRoomNumber;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    /**
     *  构造查询条件,environment_info
     */
    public EnvironmentInfo() {
        super();
    }

    /**
     * 获取  字段:environment_info.id
     *
     * @return environment_info.id, 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置  字段:environment_info.id
     *
     * @param id the value for environment_info.id, 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取  字段:environment_info.config_id
     *
     * @return environment_info.config_id, 
     */
    public Integer getConfigId() {
        return configId;
    }

    /**
     * 设置  字段:environment_info.config_id
     *
     * @param configId the value for environment_info.config_id, 
     */
    public void setConfigId(Integer configId) {
        this.configId = configId;
    }

    /**
     * 获取  字段:environment_info.need_server
     *
     * @return environment_info.need_server, 
     */
    public Boolean getNeedServer() {
        return needServer;
    }

    /**
     * 设置  字段:environment_info.need_server
     *
     * @param needServer the value for environment_info.need_server, 
     */
    public void setNeedServer(Boolean needServer) {
        this.needServer = needServer;
    }

    /**
     * 获取  字段:environment_info.need_gsm_modem
     *
     * @return environment_info.need_gsm_modem, 
     */
    public Boolean getNeedGsmModem() {
        return needGsmModem;
    }

    /**
     * 设置  字段:environment_info.need_gsm_modem
     *
     * @param needGsmModem the value for environment_info.need_gsm_modem, 
     */
    public void setNeedGsmModem(Boolean needGsmModem) {
        this.needGsmModem = needGsmModem;
    }

    /**
     * 获取  字段:environment_info.need_backup
     *
     * @return environment_info.need_backup, 
     */
    public Boolean getNeedBackup() {
        return needBackup;
    }

    /**
     * 设置  字段:environment_info.need_backup
     *
     * @param needBackup the value for environment_info.need_backup, 
     */
    public void setNeedBackup(Boolean needBackup) {
        this.needBackup = needBackup;
    }

    /**
     * 获取  字段:environment_info.battery_room_number
     *
     * @return environment_info.battery_room_number, 
     */
    public Integer getBatteryRoomNumber() {
        return batteryRoomNumber;
    }

    /**
     * 设置  字段:environment_info.battery_room_number
     *
     * @param batteryRoomNumber the value for environment_info.battery_room_number, 
     */
    public void setBatteryRoomNumber(Integer batteryRoomNumber) {
        this.batteryRoomNumber = batteryRoomNumber;
    }

    /**
     * 获取  字段:environment_info.create_time
     *
     * @return environment_info.create_time, 
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置  字段:environment_info.create_time
     *
     * @param createTime the value for environment_info.create_time, 
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取  字段:environment_info.update_time
     *
     * @return environment_info.update_time, 
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置  字段:environment_info.update_time
     *
     * @param updateTime the value for environment_info.update_time, 
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "EnvironmentInfo{" +
                "id=" + id +
                ", configId=" + configId +
                ", needServer=" + needServer +
                ", needGsmModem=" + needGsmModem +
                ", needBackup=" + needBackup +
                ", batteryRoomNumber=" + batteryRoomNumber +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}