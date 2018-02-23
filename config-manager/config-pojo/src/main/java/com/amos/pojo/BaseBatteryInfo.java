package com.amos.pojo;

import java.util.Date;

public class BaseBatteryInfo {
    private Integer id;

    private Integer powerId;

    private Integer batteryVoltage;

    private Integer batteryCapacity;

    private Integer banks;

    private Integer eachBankNumber;

    private Integer busDiameter;

    private Double width;

    private Date createTime;

    private Date updateTime;

    public BaseBatteryInfo(Integer id, Integer powerId, Integer batteryVoltage, Integer batteryCapacity, Integer banks, Integer eachBankNumber, Integer busDiameter, Double width, Date createTime, Date updateTime) {
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

    public BaseBatteryInfo() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPowerId() {
        return powerId;
    }

    public void setPowerId(Integer powerId) {
        this.powerId = powerId;
    }

    public Integer getBatteryVoltage() {
        return batteryVoltage;
    }

    public void setBatteryVoltage(Integer batteryVoltage) {
        this.batteryVoltage = batteryVoltage;
    }

    public Integer getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(Integer batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public Integer getBanks() {
        return banks;
    }

    public void setBanks(Integer banks) {
        this.banks = banks;
    }

    public Integer getEachBankNumber() {
        return eachBankNumber;
    }

    public void setEachBankNumber(Integer eachBankNumber) {
        this.eachBankNumber = eachBankNumber;
    }

    public Integer getBusDiameter() {
        return busDiameter;
    }

    public void setBusDiameter(Integer busDiameter) {
        this.busDiameter = busDiameter;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "BaseBatteryInfo{" +
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