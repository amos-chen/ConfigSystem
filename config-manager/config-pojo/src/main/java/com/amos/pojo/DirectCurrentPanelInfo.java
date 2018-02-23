package com.amos.pojo;

import java.util.Date;

public class DirectCurrentPanelInfo {
    /**
     * 
     * 表字段 : direct_current_panel_info.id
     */
    private Integer id;

    /**
     * 
     * 表字段 : direct_current_panel_info.config_id
     */
    private Integer configId;

    /**
     * 
     * 表字段 : direct_current_panel_info.brand
     */
    private String brand;

    /**
     * 
     * 表字段 : direct_current_panel_info.model
     */
    private String model;

    /**
     * 
     * 表字段 : direct_current_panel_info.number
     */
    private Integer number;

    /**
     * 
     * 表字段 : direct_current_panel_info.max_charge_current
     */
    private Double maxChargeCurrent;

    /**
     * 
     * 表字段 : direct_current_panel_info.max_discharge_current
     */
    private Double maxDischargeCurrent;

    /**
     * 
     * 表字段 : direct_current_panel_info.need_leakage_sensor
     */
    private Boolean needLeakageSensor;

    /**
     * 
     * 表字段 : direct_current_panel_info.create_time
     */
    private Date createTime;

    /**
     * 
     * 表字段 : direct_current_panel_info.update_time
     */
    private Date updateTime;

    private PowBatteryInfo powBatteryInfo;

    /**
     *  构造查询条件,direct_current_panel_info
     */
    public DirectCurrentPanelInfo(Integer id, Integer configId, String brand, String model, Integer number, Double maxChargeCurrent, Double maxDischargeCurrent, Boolean needLeakageSensor, Date createTime, Date updateTime) {
        this.id = id;
        this.configId = configId;
        this.brand = brand;
        this.model = model;
        this.number = number;
        this.maxChargeCurrent = maxChargeCurrent;
        this.maxDischargeCurrent = maxDischargeCurrent;
        this.needLeakageSensor = needLeakageSensor;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    /**
     *  构造查询条件,direct_current_panel_info
     */
    public DirectCurrentPanelInfo() {
        super();
    }

    /**
     * 获取  字段:direct_current_panel_info.id
     *
     * @return direct_current_panel_info.id, 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置  字段:direct_current_panel_info.id
     *
     * @param id the value for direct_current_panel_info.id, 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取  字段:direct_current_panel_info.config_id
     *
     * @return direct_current_panel_info.config_id, 
     */
    public Integer getConfigId() {
        return configId;
    }

    /**
     * 设置  字段:direct_current_panel_info.config_id
     *
     * @param configId the value for direct_current_panel_info.config_id, 
     */
    public void setConfigId(Integer configId) {
        this.configId = configId;
    }

    /**
     * 获取  字段:direct_current_panel_info.brand
     *
     * @return direct_current_panel_info.brand, 
     */
    public String getBrand() {
        return brand;
    }

    /**
     * 设置  字段:direct_current_panel_info.brand
     *
     * @param brand the value for direct_current_panel_info.brand, 
     */
    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    /**
     * 获取  字段:direct_current_panel_info.model
     *
     * @return direct_current_panel_info.model, 
     */
    public String getModel() {
        return model;
    }

    /**
     * 设置  字段:direct_current_panel_info.model
     *
     * @param model the value for direct_current_panel_info.model, 
     */
    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    /**
     * 获取  字段:direct_current_panel_info.number
     *
     * @return direct_current_panel_info.number, 
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * 设置  字段:direct_current_panel_info.number
     *
     * @param number the value for direct_current_panel_info.number, 
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * 获取  字段:direct_current_panel_info.max_charge_current
     *
     * @return direct_current_panel_info.max_charge_current, 
     */
    public Double getMaxChargeCurrent() {
        return maxChargeCurrent;
    }

    /**
     * 设置  字段:direct_current_panel_info.max_charge_current
     *
     * @param maxChargeCurrent the value for direct_current_panel_info.max_charge_current, 
     */
    public void setMaxChargeCurrent(Double maxChargeCurrent) {
        this.maxChargeCurrent = maxChargeCurrent;
    }

    /**
     * 获取  字段:direct_current_panel_info.max_discharge_current
     *
     * @return direct_current_panel_info.max_discharge_current, 
     */
    public Double getMaxDischargeCurrent() {
        return maxDischargeCurrent;
    }

    /**
     * 设置  字段:direct_current_panel_info.max_discharge_current
     *
     * @param maxDischargeCurrent the value for direct_current_panel_info.max_discharge_current, 
     */
    public void setMaxDischargeCurrent(Double maxDischargeCurrent) {
        this.maxDischargeCurrent = maxDischargeCurrent;
    }

    /**
     * 获取  字段:direct_current_panel_info.need_leakage_sensor
     *
     * @return direct_current_panel_info.need_leakage_sensor, 
     */
    public Boolean getNeedLeakageSensor() {
        return needLeakageSensor;
    }

    /**
     * 设置  字段:direct_current_panel_info.need_leakage_sensor
     *
     * @param needLeakageSensor the value for direct_current_panel_info.need_leakage_sensor, 
     */
    public void setNeedLeakageSensor(Boolean needLeakageSensor) {
        this.needLeakageSensor = needLeakageSensor;
    }

    /**
     * 获取  字段:direct_current_panel_info.create_time
     *
     * @return direct_current_panel_info.create_time, 
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置  字段:direct_current_panel_info.create_time
     *
     * @param createTime the value for direct_current_panel_info.create_time, 
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取  字段:direct_current_panel_info.update_time
     *
     * @return direct_current_panel_info.update_time, 
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置  字段:direct_current_panel_info.update_time
     *
     * @param updateTime the value for direct_current_panel_info.update_time, 
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public PowBatteryInfo getPowBatteryInfo() {
        return powBatteryInfo;
    }

    public void setPowBatteryInfo(PowBatteryInfo powBatteryInfo) {
        this.powBatteryInfo=powBatteryInfo;
    }

    @Override
    public String toString() {
        return "DirectCurrentPanelInfo{" +
                "id=" + id +
                ", configId=" + configId +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", number=" + number +
                ", maxChargeCurrent=" + maxChargeCurrent +
                ", maxDischargeCurrent=" + maxDischargeCurrent +
                ", needLeakageSensor=" + needLeakageSensor +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", powBatteryInfo=" + powBatteryInfo +
                '}';
    }
}