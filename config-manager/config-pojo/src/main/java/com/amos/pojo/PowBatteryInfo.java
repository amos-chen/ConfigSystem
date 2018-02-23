package com.amos.pojo;

import java.util.Date;

public class PowBatteryInfo extends BaseBatteryInfo{
    /**
     * 
     * 表字段 : pow_battery_info.id
     */
    private Integer id;

    /**
     * 
     * 表字段 : pow_battery_info.power_id
     */
    private Integer powerId;

    /**
     * 
     * 表字段 : pow_battery_info.battery_voltage
     */
    private Integer batteryVoltage;

    /**
     * 
     * 表字段 : pow_battery_info.battery_capacity
     */
    private Integer batteryCapacity;

    /**
     * 
     * 表字段 : pow_battery_info.banks
     */
    private Integer banks;

    /**
     * 
     * 表字段 : pow_battery_info.each_bank_number
     */
    private Integer eachBankNumber;

    /**
     * 
     * 表字段 : pow_battery_info.bus_diameter
     */
    private Integer busDiameter;

    /**
     * 
     * 表字段 : pow_battery_info.width
     */
    private Double width;

    /**
     * 
     * 表字段 : pow_battery_info.create_time
     */
    private Date createTime;

    /**
     * 
     * 表字段 : pow_battery_info.update_time
     */
    private Date updateTime;

    /**
     *  构造查询条件,pow_battery_info
     */
    public PowBatteryInfo(Integer id, Integer powerId, Integer batteryVoltage, Integer batteryCapacity, Integer banks, Integer eachBankNumber, Integer busDiameter, Double width, Date createTime, Date updateTime) {
        this.id = id;
        this.powerId = powerId;
        this.batteryVoltage = batteryVoltage;
        this.batteryCapacity = batteryCapacity;
        this.banks = banks;
        this.eachBankNumber = eachBankNumber;
        this.busDiameter = busDiameter;
        this.width = width;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    /**
     *  构造查询条件,pow_battery_info
     */
    public PowBatteryInfo() {
        super();
    }

    /**
     * 获取  字段:pow_battery_info.id
     *
     * @return pow_battery_info.id, 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置  字段:pow_battery_info.id
     *
     * @param id the value for pow_battery_info.id, 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取  字段:pow_battery_info.power_id
     *
     * @return pow_battery_info.power_id, 
     */
    public Integer getPowerId() {
        return powerId;
    }

    /**
     * 设置  字段:pow_battery_info.power_id
     *
     * @param powerId the value for pow_battery_info.power_id, 
     */
    public void setPowerId(Integer powerId) {
        this.powerId = powerId;
    }

    /**
     * 获取  字段:pow_battery_info.battery_voltage
     *
     * @return pow_battery_info.battery_voltage, 
     */
    public Integer getBatteryVoltage() {
        return batteryVoltage;
    }

    /**
     * 设置  字段:pow_battery_info.battery_voltage
     *
     * @param batteryVoltage the value for pow_battery_info.battery_voltage, 
     */
    public void setBatteryVoltage(Integer batteryVoltage) {
        this.batteryVoltage = batteryVoltage;
    }

    /**
     * 获取  字段:pow_battery_info.battery_capacity
     *
     * @return pow_battery_info.battery_capacity, 
     */
    public Integer getBatteryCapacity() {
        return batteryCapacity;
    }

    /**
     * 设置  字段:pow_battery_info.battery_capacity
     *
     * @param batteryCapacity the value for pow_battery_info.battery_capacity, 
     */
    public void setBatteryCapacity(Integer batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    /**
     * 获取  字段:pow_battery_info.banks
     *
     * @return pow_battery_info.banks, 
     */
    public Integer getBanks() {
        return banks;
    }

    /**
     * 设置  字段:pow_battery_info.banks
     *
     * @param banks the value for pow_battery_info.banks, 
     */
    public void setBanks(Integer banks) {
        this.banks = banks;
    }

    /**
     * 获取  字段:pow_battery_info.each_bank_number
     *
     * @return pow_battery_info.each_bank_number, 
     */
    public Integer getEachBankNumber() {
        return eachBankNumber;
    }

    /**
     * 设置  字段:pow_battery_info.each_bank_number
     *
     * @param eachBankNumber the value for pow_battery_info.each_bank_number, 
     */
    public void setEachBankNumber(Integer eachBankNumber) {
        this.eachBankNumber = eachBankNumber;
    }

    /**
     * 获取  字段:pow_battery_info.bus_diameter
     *
     * @return pow_battery_info.bus_diameter, 
     */
    public Integer getBusDiameter() {
        return busDiameter;
    }

    /**
     * 设置  字段:pow_battery_info.bus_diameter
     *
     * @param busDiameter the value for pow_battery_info.bus_diameter, 
     */
    public void setBusDiameter(Integer busDiameter) {
        this.busDiameter = busDiameter;
    }

    /**
     * 获取  字段:pow_battery_info.width
     *
     * @return pow_battery_info.width, 
     */
    public Double getWidth() {
        return width;
    }

    /**
     * 设置  字段:pow_battery_info.width
     *
     * @param width the value for pow_battery_info.width, 
     */
    public void setWidth(Double width) {
        this.width = width;
    }

    /**
     * 获取  字段:pow_battery_info.create_time
     *
     * @return pow_battery_info.create_time, 
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置  字段:pow_battery_info.create_time
     *
     * @param createTime the value for pow_battery_info.create_time, 
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取  字段:pow_battery_info.update_time
     *
     * @return pow_battery_info.update_time, 
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置  字段:pow_battery_info.update_time
     *
     * @param updateTime the value for pow_battery_info.update_time, 
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "PowBatteryInfo{" +
                "id=" + id +
                ", powerId=" + powerId +
                ", batteryVoltage=" + batteryVoltage +
                ", batteryCapacity=" + batteryCapacity +
                ", banks=" + banks +
                ", eachBankNumber=" + eachBankNumber +
                ", busDiameter=" + busDiameter +
                ", width=" + width +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}