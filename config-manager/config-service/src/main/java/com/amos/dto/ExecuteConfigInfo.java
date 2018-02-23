package com.amos.dto;

import com.amos.pojo.*;

import java.util.List;

/**
 * Created by chenlunwei on 2018/2/22.
 */
public class ExecuteConfigInfo {
	private String projectTitle;
	private Integer application;
	private boolean needManagementFunction;
	private List<UpsInfo> upsInfoList;
	private List<BatteryInfo> BatteryInfo;
	private List<DirectCurrentPanelInfo> directCurrentPanelInfos;
	private List<PowBatteryInfo> powBatteryInfos;
	private List<SmpsInfo> smpsInfos;
	private List<TelBatteryInfo> telBatteryInfos;
	private boolean needServer;
	private boolean needGsmModem;
	private boolean needBackup;
	private Integer batteryRoom;

	public String getProjectTitle() {
		return projectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}

	public Integer getApplication() {
		return application;
	}

	public void setApplication(Integer application) {
		this.application = application;
	}

	public boolean isNeedManagementFunction() {
		return needManagementFunction;
	}

	public void setNeedManagementFunction(boolean needManagementFunction) {
		this.needManagementFunction = needManagementFunction;
	}

	public List<UpsInfo> getUpsInfoList() {
		return upsInfoList;
	}

	public void setUpsInfoList(List<UpsInfo> upsInfoList) {
		this.upsInfoList = upsInfoList;
	}

	public List<com.amos.pojo.BatteryInfo> getBatteryInfo() {
		return BatteryInfo;
	}

	public void setBatteryInfo(List<com.amos.pojo.BatteryInfo> batteryInfo) {
		BatteryInfo = batteryInfo;
	}

	public List<DirectCurrentPanelInfo> getDirectCurrentPanelInfos() {
		return directCurrentPanelInfos;
	}

	public void setDirectCurrentPanelInfos(List<DirectCurrentPanelInfo> directCurrentPanelInfos) {
		this.directCurrentPanelInfos = directCurrentPanelInfos;
	}

	public List<PowBatteryInfo> getPowBatteryInfos() {
		return powBatteryInfos;
	}

	public void setPowBatteryInfos(List<PowBatteryInfo> powBatteryInfos) {
		this.powBatteryInfos = powBatteryInfos;
	}

	public List<SmpsInfo> getSmpsInfos() {
		return smpsInfos;
	}

	public void setSmpsInfos(List<SmpsInfo> smpsInfos) {
		this.smpsInfos = smpsInfos;
	}

	public List<TelBatteryInfo> getTelBatteryInfos() {
		return telBatteryInfos;
	}

	public void setTelBatteryInfos(List<TelBatteryInfo> telBatteryInfos) {
		this.telBatteryInfos = telBatteryInfos;
	}

	public boolean isNeedServer() {
		return needServer;
	}

	public void setNeedServer(boolean needServer) {
		this.needServer = needServer;
	}

	public boolean isNeedGsmModem() {
		return needGsmModem;
	}

	public void setNeedGsmModem(boolean needGsmModem) {
		this.needGsmModem = needGsmModem;
	}

	public boolean isNeedBackup() {
		return needBackup;
	}

	public void setNeedBackup(boolean needBackup) {
		this.needBackup = needBackup;
	}

	public Integer getBatteryRoom() {
		return batteryRoom;
	}

	public void setBatteryRoom(Integer batteryRoom) {
		this.batteryRoom = batteryRoom;
	}
}
