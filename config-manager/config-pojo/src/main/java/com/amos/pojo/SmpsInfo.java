package com.amos.pojo;

import java.util.Date;

public class SmpsInfo {
    /**
     * 
     * 表字段 : smps_info.id
     */
    private Integer id;

    /**
     * 
     * 表字段 : smps_info.config_id
     */
    private Integer configId;

    /**
     * 
     * 表字段 : smps_info.brand
     */
    private String brand;

    /**
     * 
     * 表字段 : smps_info.power
     */
    private Double power;

    /**
     * 
     * 表字段 : smps_info.number
     */
    private Integer number;

    /**
     * 
     * 表字段 : smps_info.need_single_monitor
     */
    private Boolean needSingleMonitor;

    /**
     * 
     * 表字段 : smps_info.need_energy_saving
     */
    private Boolean needEnergySaving;

    /**
     * 
     * 表字段 : smps_info.need_smart_meter
     */
    private Boolean needSmartMeter;

    /**
     * 
     * 表字段 : smps_info.need_leakage_sensor
     */
    private Boolean needLeakageSensor;

    /**
     * 
     * 表字段 : smps_info.create_time
     */
    private Date createTime;

    /**
     * 
     * 表字段 : smps_info.update_time
     */
    private Date updateTime;

    private TelBatteryInfo telBatteryInfo;

    /**
     *  构造查询条件,smps_info
     */
    public SmpsInfo(Integer id, Integer configId, String brand, Double power, Integer number, Boolean needSingleMonitor, Boolean needEnergySaving, Boolean needSmartMeter, Boolean needLeakageSensor, Date createTime, Date updateTime) {
        this.id = id;
        this.configId = configId;
        this.brand = brand;
        this.power = power;
        this.number = number;
        this.needSingleMonitor = needSingleMonitor;
        this.needEnergySaving = needEnergySaving;
        this.needSmartMeter = needSmartMeter;
        this.needLeakageSensor = needLeakageSensor;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    /**
     *  构造查询条件,smps_info
     */
    public SmpsInfo() {
        super();
    }

    /**
     * 获取  字段:smps_info.id
     *
     * @return smps_info.id, 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置  字段:smps_info.id
     *
     * @param id the value for smps_info.id, 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取  字段:smps_info.config_id
     *
     * @return smps_info.config_id, 
     */
    public Integer getConfigId() {
        return configId;
    }

    /**
     * 设置  字段:smps_info.config_id
     *
     * @param configId the value for smps_info.config_id, 
     */
    public void setConfigId(Integer configId) {
        this.configId = configId;
    }

    /**
     * 获取  字段:smps_info.brand
     *
     * @return smps_info.brand, 
     */
    public String getBrand() {
        return brand;
    }

    /**
     * 设置  字段:smps_info.brand
     *
     * @param brand the value for smps_info.brand, 
     */
    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    /**
     * 获取  字段:smps_info.power
     *
     * @return smps_info.power, 
     */
    public Double getPower() {
        return power;
    }

    /**
     * 设置  字段:smps_info.power
     *
     * @param power the value for smps_info.power, 
     */
    public void setPower(Double power) {
        this.power = power;
    }

    /**
     * 获取  字段:smps_info.number
     *
     * @return smps_info.number, 
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * 设置  字段:smps_info.number
     *
     * @param number the value for smps_info.number, 
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * 获取  字段:smps_info.need_single_monitor
     *
     * @return smps_info.need_single_monitor, 
     */
    public Boolean getNeedSingleMonitor() {
        return needSingleMonitor;
    }

    /**
     * 设置  字段:smps_info.need_single_monitor
     *
     * @param needSingleMonitor the value for smps_info.need_single_monitor, 
     */
    public void setNeedSingleMonitor(Boolean needSingleMonitor) {
        this.needSingleMonitor = needSingleMonitor;
    }

    /**
     * 获取  字段:smps_info.need_energy_saving
     *
     * @return smps_info.need_energy_saving, 
     */
    public Boolean getNeedEnergySaving() {
        return needEnergySaving;
    }

    /**
     * 设置  字段:smps_info.need_energy_saving
     *
     * @param needEnergySaving the value for smps_info.need_energy_saving, 
     */
    public void setNeedEnergySaving(Boolean needEnergySaving) {
        this.needEnergySaving = needEnergySaving;
    }

    /**
     * 获取  字段:smps_info.need_smart_meter
     *
     * @return smps_info.need_smart_meter, 
     */
    public Boolean getNeedSmartMeter() {
        return needSmartMeter;
    }

    /**
     * 设置  字段:smps_info.need_smart_meter
     *
     * @param needSmartMeter the value for smps_info.need_smart_meter, 
     */
    public void setNeedSmartMeter(Boolean needSmartMeter) {
        this.needSmartMeter = needSmartMeter;
    }

    /**
     * 获取  字段:smps_info.need_leakage_sensor
     *
     * @return smps_info.need_leakage_sensor, 
     */
    public Boolean getNeedLeakageSensor() {
        return needLeakageSensor;
    }

    /**
     * 设置  字段:smps_info.need_leakage_sensor
     *
     * @param needLeakageSensor the value for smps_info.need_leakage_sensor, 
     */
    public void setNeedLeakageSensor(Boolean needLeakageSensor) {
        this.needLeakageSensor = needLeakageSensor;
    }

    /**
     * 获取  字段:smps_info.create_time
     *
     * @return smps_info.create_time, 
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置  字段:smps_info.create_time
     *
     * @param createTime the value for smps_info.create_time, 
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取  字段:smps_info.update_time
     *
     * @return smps_info.update_time, 
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置  字段:smps_info.update_time
     *
     * @param updateTime the value for smps_info.update_time, 
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public TelBatteryInfo getTelBatteryInfo() {
        return telBatteryInfo;
    }

    public void setTelBatteryInfo(TelBatteryInfo telBatteryInfo) {
        this.telBatteryInfo=telBatteryInfo;
    }

    @Override
    public String toString() {
        return "SmpsInfo{" +
                "id=" + id +
                ", configId=" + configId +
                ", brand='" + brand + '\'' +
                ", power=" + power +
                ", number=" + number +
                ", needSingleMonitor=" + needSingleMonitor +
                ", needEnergySaving=" + needEnergySaving +
                ", needSmartMeter=" + needSmartMeter +
                ", needLeakageSensor=" + needLeakageSensor +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", telBatteryInfo=" + telBatteryInfo +
                '}';
    }
}