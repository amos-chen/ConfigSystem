package com.amos.pojo;

import java.util.Date;

public class UpsInfo {
    /**
     * 
     * 表字段 : ups_info.id
     */
    private Integer id;

    /**
     * 
     * 表字段 : ups_info.config_id
     */
    private Integer configId;

    /**
     * 
     * 表字段 : ups_info.brand
     */
    private String brand;

    /**
     * 
     * 表字段 : ups_info.model
     */
    private String model;

    /**
     * 
     * 表字段 : ups_info.power
     */
    private Integer power;

    /**
     * 
     * 表字段 : ups_info.number
     */
    private Integer number;

    /**
     * 
     * 表字段 : ups_info.is_three_wire
     */
    private Boolean isThreeWire;

    /**
     * 
     * 表字段 : ups_info.need_convergence
     */
    private Boolean needConvergence;

    /**
     * 
     * 表字段 : ups_info.support_dry_node
     */
    private Boolean supportDryNode;

    /**
     * 
     * 表字段 : ups_info.create_time
     */
    private Date createTime;

    /**
     * 
     * 表字段 : ups_info.update_time
     */
    private Date updateTime;

    private BatteryInfo batteryInfo;

    /**
     *  构造查询条件,ups_info
     */
    public UpsInfo(Integer id, Integer configId, String brand, String model, Integer power, Integer number, Boolean isThreeWire, Boolean needConvergence, Boolean supportDryNode, Date createTime, Date updateTime) {
        this.id = id;
        this.configId = configId;
        this.brand = brand;
        this.model = model;
        this.power = power;
        this.number = number;
        this.isThreeWire = isThreeWire;
        this.needConvergence = needConvergence;
        this.supportDryNode = supportDryNode;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    /**
     *  构造查询条件,ups_info
     */
    public UpsInfo() {
        super();
    }

    /**
     * 获取  字段:ups_info.id
     *
     * @return ups_info.id, 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置  字段:ups_info.id
     *
     * @param id the value for ups_info.id, 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取  字段:ups_info.config_id
     *
     * @return ups_info.config_id, 
     */
    public Integer getConfigId() {
        return configId;
    }

    /**
     * 设置  字段:ups_info.config_id
     *
     * @param configId the value for ups_info.config_id, 
     */
    public void setConfigId(Integer configId) {
        this.configId = configId;
    }

    /**
     * 获取  字段:ups_info.brand
     *
     * @return ups_info.brand, 
     */
    public String getBrand() {
        return brand;
    }

    /**
     * 设置  字段:ups_info.brand
     *
     * @param brand the value for ups_info.brand, 
     */
    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    /**
     * 获取  字段:ups_info.model
     *
     * @return ups_info.model, 
     */
    public String getModel() {
        return model;
    }

    /**
     * 设置  字段:ups_info.model
     *
     * @param model the value for ups_info.model, 
     */
    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    /**
     * 获取  字段:ups_info.power
     *
     * @return ups_info.power, 
     */
    public Integer getPower() {
        return power;
    }

    /**
     * 设置  字段:ups_info.power
     *
     * @param power the value for ups_info.power, 
     */
    public void setPower(Integer power) {
        this.power = power;
    }

    /**
     * 获取  字段:ups_info.number
     *
     * @return ups_info.number, 
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * 设置  字段:ups_info.number
     *
     * @param number the value for ups_info.number, 
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * 获取  字段:ups_info.is_three_wire
     *
     * @return ups_info.is_three_wire, 
     */
    public Boolean getIsThreeWire() {
        return isThreeWire;
    }

    /**
     * 设置  字段:ups_info.is_three_wire
     *
     * @param isThreeWire the value for ups_info.is_three_wire, 
     */
    public void setIsThreeWire(Boolean isThreeWire) {
        this.isThreeWire = isThreeWire;
    }

    /**
     * 获取  字段:ups_info.need_convergence
     *
     * @return ups_info.need_convergence, 
     */
    public Boolean getNeedConvergence() {
        return needConvergence;
    }

    /**
     * 设置  字段:ups_info.need_convergence
     *
     * @param needConvergence the value for ups_info.need_convergence, 
     */
    public void setNeedConvergence(Boolean needConvergence) {
        this.needConvergence = needConvergence;
    }

    /**
     * 获取  字段:ups_info.support_dry_node
     *
     * @return ups_info.support_dry_node, 
     */
    public Boolean getSupportDryNode() {
        return supportDryNode;
    }

    /**
     * 设置  字段:ups_info.support_dry_node
     *
     * @param supportDryNode the value for ups_info.support_dry_node, 
     */
    public void setSupportDryNode(Boolean supportDryNode) {
        this.supportDryNode = supportDryNode;
    }

    /**
     * 获取  字段:ups_info.create_time
     *
     * @return ups_info.create_time, 
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置  字段:ups_info.create_time
     *
     * @param createTime the value for ups_info.create_time, 
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取  字段:ups_info.update_time
     *
     * @return ups_info.update_time, 
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置  字段:ups_info.update_time
     *
     * @param updateTime the value for ups_info.update_time, 
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public BatteryInfo getBatteryInfo() {
        return batteryInfo;
    }

    public void setBatteryInfo(BatteryInfo batteryInfo) {
        this.batteryInfo=batteryInfo;
    }

    @Override
    public String toString() {
        return "UpsInfo{" +
                "id=" + id +
                ", configId=" + configId +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", power=" + power +
                ", number=" + number +
                ", isThreeWire=" + isThreeWire +
                ", needConvergence=" + needConvergence +
                ", supportDryNode=" + supportDryNode +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", batteryInfo=" + batteryInfo +
                '}';
    }
}