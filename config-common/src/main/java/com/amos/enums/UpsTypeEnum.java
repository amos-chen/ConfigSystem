package com.amos.enums;

/**
 * Created by chenlunwei on 2018/2/16.
 */
public enum UpsTypeEnum {
	//对应不需要管理功能，两线制UPS，不需要汇流柜，不支持干节点情况
	TYPE1(0,true,true,true,true,false,false,false),
	//对应不需要管理功能，两线制UPS，不需要汇流柜，支持干节点情况
	TYPE2(1,true,true,true,true,false,false,false),
	//对应不需要管理功能，两线制UPS，需要汇流柜，不支持干节点情况
	TYPE3(2,false,false,false,false,false,true,false),
	//对应不需要管理功能，两线制UPS，需要汇流柜，支持干节点情况
	TYPE4(3,false,false,false,false,false,true,false),
	TYPE5(4,true,true,true,true,false,false,false),
	TYPE6(5,true,true,true,true,false,false,false),
	TYPE7(6,false,false,false,false,false,true,false),
	TYPE8(7,false,false,false,false,false,true,false),
	TYPE9(8,true,false,false,false,false,false,true),
	TYPE10(9,true,true,true,true,false,false,false),
	TYPE11(10,false,false,false,false,true,false,true),
	TYPE12(11,false,false,false,false,false,true,false),
	TYPE13(12,true,false,false,false,false,false,true),
	TYPE14(13,true,true,true,true,false,false,false),
	TYPE15(14,false,false,false,false,true,false,true),
	TYPE16(15,false,false,false,false,false,true,false);


	private int UpsTypeCode;
	private boolean needSmartHallSensor;
	private boolean neddSmartVoltagecollector;
	private boolean needLeageSensor;
	private boolean needSmartGateWay;
	private boolean needConvergenceCabinet;
	private boolean needManagementCabinet;
	private boolean needSmartControlCabinet;


	UpsTypeEnum(int UpsTypeCode, boolean needSmartHallSensor,
				boolean neddSmartVoltagecollector, boolean needLeageSensor,
				boolean needSmartGateWay, boolean needConvergenceCabinet,
				boolean needManagementCabinet,boolean needSmartControlCabinet) {
		this.UpsTypeCode = UpsTypeCode;
		this.needSmartHallSensor = needSmartHallSensor;
		this.neddSmartVoltagecollector = neddSmartVoltagecollector;
		this.needLeageSensor = needLeageSensor;
		this.needSmartGateWay = needSmartGateWay;
		this.needConvergenceCabinet = needConvergenceCabinet;
		this.needManagementCabinet = needManagementCabinet;
		this.needSmartControlCabinet = needSmartControlCabinet;
	}

	public int getUpsTypeCode() {
		return UpsTypeCode;
	}

	public boolean isNeedSmartHallSensor() {
		return needSmartHallSensor;
	}

	public boolean isNeddSmartVoltagecollector() {
		return neddSmartVoltagecollector;
	}

	public boolean isNeedLeageSensor() {
		return needLeageSensor;
	}

	public boolean isNeedSmartGateWay() {
		return needSmartGateWay;
	}

	public boolean isNeedConvergenceCabinet() {
		return needConvergenceCabinet;
	}

	public boolean isNeedSmartControlCabinet() {
		return needSmartControlCabinet;
	}

	public boolean isNeedManagementCabinet() {
		return needManagementCabinet;
	}

	public static UpsTypeEnum stateOf(int upsTypeCode){
		for (UpsTypeEnum upsTypeEnum : values()) {
			if(upsTypeCode == upsTypeEnum.getUpsTypeCode()){
				return upsTypeEnum;
			}
		}
		return null;
	}
}
