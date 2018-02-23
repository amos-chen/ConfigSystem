package com.amos.pojo;

import java.util.Date;

public class CabinetDevice {
    /**
     * 
     * 表字段 : cabinet_device.id
     */
    private Integer id;

    /**
     * 
     * 表字段 : cabinet_device.cabinet_type
     */
    private Integer cabinetType;

    /**
     * 
     * 表字段 : cabinet_device.model
     */
    private String model;

    /**
     * 
     * 表字段 : cabinet_device.support_banks
     */
    private Integer supportBanks;

    /**
     * 
     * 表字段 : cabinet_device.voltage
     */
    private Integer voltage;

    /**
     * 
     * 表字段 : cabinet_device.each_bank_current
     */
    private Integer eachBankCurrent;

    /**
     * 
     * 表字段 : cabinet_device.create_time
     */
    private Date createTime;

    /**
     * 
     * 表字段 : cabinet_device.update_time
     */
    private Date updateTime;

    /**
     *  构造查询条件,cabinet_device
     */
    public CabinetDevice(Integer id, Integer cabinetType, String model, Integer supportBanks, Integer voltage, Integer eachBankCurrent, Date createTime, Date updateTime) {
        this.id = id;
        this.cabinetType = cabinetType;
        this.model = model;
        this.supportBanks = supportBanks;
        this.voltage = voltage;
        this.eachBankCurrent = eachBankCurrent;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    /**
     *  构造查询条件,cabinet_device
     */
    public CabinetDevice() {
        super();
    }

    /**
     * 获取  字段:cabinet_device.id
     *
     * @return cabinet_device.id, 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置  字段:cabinet_device.id
     *
     * @param id the value for cabinet_device.id, 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取  字段:cabinet_device.cabinet_type
     *
     * @return cabinet_device.cabinet_type, 
     */
    public Integer getCabinetType() {
        return cabinetType;
    }

    /**
     * 设置  字段:cabinet_device.cabinet_type
     *
     * @param cabinetType the value for cabinet_device.cabinet_type, 
     */
    public void setCabinetType(Integer cabinetType) {
        this.cabinetType = cabinetType;
    }

    /**
     * 获取  字段:cabinet_device.model
     *
     * @return cabinet_device.model, 
     */
    public String getModel() {
        return model;
    }

    /**
     * 设置  字段:cabinet_device.model
     *
     * @param model the value for cabinet_device.model, 
     */
    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    /**
     * 获取  字段:cabinet_device.support_banks
     *
     * @return cabinet_device.support_banks, 
     */
    public Integer getSupportBanks() {
        return supportBanks;
    }

    /**
     * 设置  字段:cabinet_device.support_banks
     *
     * @param supportBanks the value for cabinet_device.support_banks, 
     */
    public void setSupportBanks(Integer supportBanks) {
        this.supportBanks = supportBanks;
    }

    /**
     * 获取  字段:cabinet_device.voltage
     *
     * @return cabinet_device.voltage, 
     */
    public Integer getVoltage() {
        return voltage;
    }

    /**
     * 设置  字段:cabinet_device.voltage
     *
     * @param voltage the value for cabinet_device.voltage, 
     */
    public void setVoltage(Integer voltage) {
        this.voltage = voltage;
    }

    /**
     * 获取  字段:cabinet_device.each_bank_current
     *
     * @return cabinet_device.each_bank_current, 
     */
    public Integer getEachBankCurrent() {
        return eachBankCurrent;
    }

    /**
     * 设置  字段:cabinet_device.each_bank_current
     *
     * @param eachBankCurrent the value for cabinet_device.each_bank_current, 
     */
    public void setEachBankCurrent(Integer eachBankCurrent) {
        this.eachBankCurrent = eachBankCurrent;
    }

    /**
     * 获取  字段:cabinet_device.create_time
     *
     * @return cabinet_device.create_time, 
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置  字段:cabinet_device.create_time
     *
     * @param createTime the value for cabinet_device.create_time, 
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取  字段:cabinet_device.update_time
     *
     * @return cabinet_device.update_time, 
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置  字段:cabinet_device.update_time
     *
     * @param updateTime the value for cabinet_device.update_time, 
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "CabinetDevice{" +
                "id=" + id +
                ", cabinetType=" + cabinetType +
                ", model='" + model + '\'' +
                ", supportBanks=" + supportBanks +
                ", voltage=" + voltage +
                ", eachBankCurrent=" + eachBankCurrent +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}