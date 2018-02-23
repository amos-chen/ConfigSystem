package com.amos.enums;

/**
 * Created by chenlunwei on 2018/2/21.
 */
public enum  ApplicationEnum {
	DATACENTER(1),
	TELECOM(2),
	POWERUTILITY(3);

	private int application;

	ApplicationEnum(int application){
		this.application = application;
	}

	public int getApplication() {
		return application;
	}

	public void setApplication(int application) {
		this.application = application;
	}
	public static ApplicationEnum stateOf(int application){
		for (ApplicationEnum applicationEnum : values()) {
			if(application == applicationEnum.getApplication()){
				return applicationEnum;
			}
		}
		return null;
	}
}
