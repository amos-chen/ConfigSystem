package com.amos.service;

import com.amos.dao.*;
import com.amos.dto.ExcelElement;
import com.amos.enums.ApplicationEnum;
import com.amos.enums.UpsTypeEnum;
import com.amos.exception.ConfigException;
import com.amos.exception.DataInsertFailException;
import com.amos.pojo.*;
import com.amos.utils.JsonUtils;
import com.amos.utils.PropertyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by chenlunwei on 2018/2/16.
 */

@Service
public class ConfigServiceImpl implements ConfigService {

	private Properties pros;
	@Autowired
	private BatteryInfoMapper batteryInfoMapper;
	@Autowired
	private UpsInfoMapper upsInfoMapper;
	@Autowired
	private EnvironmentInfoMapper environmentInfoMapper;
	@Autowired
	private ApplicationInfoMapper applicationInfoMapper;
	@Autowired
	private ConfigResultMapper configResultMapper;
	@Autowired
	private CabinetDeviceMapper cabinetDeviceMapper;
	@Autowired
	private ConfigurationInfoMapper configurationInfoMapper;
	@Autowired
	private SmpsInfoMapper smpsInfoMapper;
	@Autowired
	private DirectCurrentPanelInfoMapper directCurrentPanelInfoMapper;
	@Autowired
	private TelBatteryInfoMapper telBatteryInfoMapper;
	@Autowired
	private PowBatteryInfoMapper powBatteryInfoMapper;

	private Properties loadProperties(String language) {
		if ("中文".equals(language)) {
			return PropertyUtil.loadProps("/properties/excel-zh.properties");
		} else {
			return PropertyUtil.loadProps("/properties/excel-en.properties");
		}
	}

	@Override
	public List<ApplicationInfo> queryList(String search) {
		return applicationInfoMapper.selectList(search);
	}

	@Override
	public Map<String, Object> queryConfigInfo(Integer configId) {
		int powerCount=0;
		ConfigurationInfo configurationInfo = configurationInfoMapper.selectByPrimaryKey(configId);
		ApplicationInfo applicationInfo = configurationInfo.getApplicationInfo();
		EnvironmentInfo environmentInfo = configurationInfo.getEnvironmentInfo();
		List<UpsInfo> upsInfos = configurationInfo.getUpsInfos();
		List<DirectCurrentPanelInfo> directCurrentPanelInfos = configurationInfo.getDirectCurrentPanelInfos();
		List<SmpsInfo> smpsInfos = configurationInfo.getSmpsInfos();
		Map<String, Object> baseMap = new LinkedHashMap<>();
		Map<String, Object> resltMap = new LinkedHashMap<>();
		String application = "";
		switch (applicationInfo.getApplication()) {
			case 1:
				application = "数据中心";
				break;
			case 2:
				application = "电信";
				break;
			case 3:
				application = "电力";
				break;
		}
		baseMap.put("项目标题", applicationInfo.getProjectTitle());
		baseMap.put("应用场景", application);
		baseMap.put("是否需要管理功能", applicationInfo.getManagementFunction() == true ? "是" : "否");
		baseMap.put("是否需要本地部署", environmentInfo.getNeedServer() == true ? "是" : "否");
		baseMap.put("是否需要短信告警功能", environmentInfo.getNeedGsmModem() == true ? "是" : "否");
		baseMap.put("是否需要备品", environmentInfo.getNeedBackup() == true ? "是" : "否");
		if (environmentInfo.getBatteryRoomNumber() != null && environmentInfo.getBatteryRoomNumber() != 0) {
			baseMap.put("电池房数量", environmentInfo.getBatteryRoomNumber());
		}
		resltMap.put("基本信息", baseMap);
		if (upsInfos != null) {
			for (UpsInfo upsInfo : upsInfos) {
				Map<String, Object> powerMap = new LinkedHashMap<>();
				BatteryInfo batteryInfo = upsInfo.getBatteryInfo();
				powerMap.put("UPS品牌", upsInfo.getBrand());
				powerMap.put("UPS型号", upsInfo.getModel());
				powerMap.put("UPS功率", upsInfo.getPower() + "KVA");
				powerMap.put("数量", upsInfo.getNumber() + "台");
				powerMap.put("是否为三线制", upsInfo.getIsThreeWire() == true ? "是" : "否");
				powerMap.put("是否需要汇流柜", upsInfo.getNeedConvergence() == true ? "是" : "否");
				powerMap.put("是否支持干接点", upsInfo.getSupportDryNode() == true ? "是" : "否");
				powerMap.put("每台UPS对应电池单体电压", batteryInfo.getBatteryVoltage() + "V");
				powerMap.put("每台UPS对应电池容量", batteryInfo.getBatteryCapacity() + "Ah");
				powerMap.put("每台UPS对应电池组数", batteryInfo.getBanks() + "组");
				powerMap.put("每台UPS对应单组电池数量", batteryInfo.getEachBankNumber() + "只");
				powerMap.put("电池母线线径", batteryInfo.getBusDiameter() + "mm2");
				resltMap.put("电源信息"+(++powerCount), powerMap);
			}
		}
		if (directCurrentPanelInfos != null) {
			for (DirectCurrentPanelInfo dcpi : directCurrentPanelInfos) {
				Map<String, Object> powerMap = new LinkedHashMap<>();
				PowBatteryInfo powBatteryInfo = dcpi.getPowBatteryInfo();
				powerMap.put("直流屏品牌", dcpi.getBrand());
				powerMap.put("直流屏型号", dcpi.getModel());
				powerMap.put("直流屏最大充电电流", dcpi.getMaxChargeCurrent() + "A");
				powerMap.put("直流屏最大放电电流", dcpi.getMaxDischargeCurrent() + "A");
				powerMap.put("是否需要漏液监测", dcpi.getNeedLeakageSensor() == true ? "是" : "否");
				powerMap.put("每台直流屏对应电池单体电压", powBatteryInfo.getBatteryVoltage() + "V");
				powerMap.put("每台直流屏对应电池容量", powBatteryInfo.getBatteryCapacity() + "Ah");
				powerMap.put("每台直流屏对应电池组数", powBatteryInfo.getBanks() + "组");
				powerMap.put("每台直流屏对应单组电池数量", powBatteryInfo.getEachBankNumber() + "只");
				powerMap.put("电池母线线径", powBatteryInfo.getBusDiameter() + "mm2");
				resltMap.put("电源信息"+(++powerCount), powerMap);
			}
		}
		if (smpsInfos != null) {
			for (SmpsInfo smpsInfo : smpsInfos) {
				Map<String, Object> powerMap = new LinkedHashMap<>();
				TelBatteryInfo telBatteryInfo = smpsInfo.getTelBatteryInfo();
				powerMap.put("运营商", smpsInfo.getBrand());
				powerMap.put("开关电源功率", smpsInfo.getPower() + "KW");
				powerMap.put("是否需要单体采集", smpsInfo.getNeedSingleMonitor() == true ? "是" : "否");
				powerMap.put("是否需要空调节能", smpsInfo.getNeedEnergySaving() == true ? "是" : "否");
				powerMap.put("是否需要智能电表", smpsInfo.getNeedSmartMeter() == true ? "是" : "否");
				powerMap.put("是否需要漏液监测", smpsInfo.getNeedLeakageSensor() == true ? "是" : "否");
				powerMap.put("每台开关电源对应电池单体电压", telBatteryInfo.getBatteryVoltage() + "V");
				powerMap.put("每台开关电源对应电池容量", telBatteryInfo.getBatteryCapacity() + "Ah");
				powerMap.put("每台开关电源对应电池组数", telBatteryInfo.getBanks() + "组");
				powerMap.put("每台开关电源对应单组电池数量", telBatteryInfo.getEachBankNumber() + "只");
				powerMap.put("电池母线线径", telBatteryInfo.getBusDiameter() + "mm2");
				resltMap.put("电源信息"+(++powerCount), powerMap);
			}
		}
		return resltMap;
	}

	@Override
	public ConfigResult queryConfigResult(Integer configId) {
		ConfigurationInfo configurationInfo = configurationInfoMapper.selectBaseInfoById(configId);
		ConfigResult configResult = configResultMapper.selectByPrimaryKey(configurationInfo.getConfigResultId());
		return configResult;
	}


	@Override
	@Transactional
	public Map<String, List<ExcelElement>> insertConfiguration(ConfigurationInfo configurationInfo) throws DataInsertFailException, ConfigException {
		try {
			Date date = new Date();
			List<Integer> resultData = new ArrayList<>();
			//向数据表config_result中插入数据
			ConfigResult configResult = new ConfigResult();
			Map<String, List<ExcelElement>> configData = null;
			if (configurationInfo.getApplicationInfo().getApplication() == ApplicationEnum.DATACENTER.getApplication()) {
				configData = generatePowerutilityExcelConfig(configurationInfo.getApplicationInfo(), configurationInfo.getEnvironmentInfo()
						, configurationInfo.getUpsInfos());
			} else if (configurationInfo.getApplicationInfo().getApplication() == ApplicationEnum.TELECOM.getApplication()) {
				configData = generatePowerutilityExcelConfig(configurationInfo.getApplicationInfo(), configurationInfo.getEnvironmentInfo()
						, configurationInfo.getSmpsInfos());
			} else if (configurationInfo.getApplicationInfo().getApplication() == ApplicationEnum.POWERUTILITY.getApplication()) {
				configData = generatePowerutilityExcelConfig(configurationInfo.getApplicationInfo(), configurationInfo.getEnvironmentInfo()
						, configurationInfo.getDirectCurrentPanelInfos());
			}
			configResult.setConfigData(JsonUtils.objectToJson(configData));
			configResult.setCreateTime(date);
			configResult.setUpdateTime(date);
			configResult.setTitle(configurationInfo.getApplicationInfo().getProjectTitle());
			int insertConfigResult = configResultMapper.insert(configResult);
			resultData.add(insertConfigResult);

			//向数据表configuration_info中插入数据
			configurationInfo.setConfigResultId(configResult.getId());
			configurationInfo.setCreateTime(date);
			configurationInfo.setUpdateTime(date);
			int insertConfigurationInfo = configurationInfoMapper.insert(configurationInfo);
			resultData.add(insertConfigurationInfo);

			//向数据表application_info中插入数据
			ApplicationInfo applicationInfo = configurationInfo.getApplicationInfo();
			applicationInfo.setCreateTime(date);
			applicationInfo.setUpdateTime(date);
			applicationInfo.setConfigId(configurationInfo.getId());
			int insertApplicationInfo = applicationInfoMapper.insert(applicationInfo);
			resultData.add(insertApplicationInfo);

			//向数据表environment_info中插入数据
			EnvironmentInfo environmentInfo = configurationInfo.getEnvironmentInfo();
			environmentInfo.setCreateTime(date);
			environmentInfo.setUpdateTime(date);
			environmentInfo.setConfigId(configurationInfo.getId());
			int insertEnvironemntInfo = environmentInfoMapper.insert(environmentInfo);
			resultData.add(insertEnvironemntInfo);

			List<UpsInfo> upsInfos = configurationInfo.getUpsInfos();
			if (upsInfos != null && upsInfos.size() > 0) {
				for (UpsInfo upsInfo : upsInfos) {
					//向数据表ups_info中插入数据
					upsInfo.setCreateTime(date);
					upsInfo.setUpdateTime(date);
					upsInfo.setConfigId(configurationInfo.getId());
					int insertUpsInfo = upsInfoMapper.insert(upsInfo);
					resultData.add(insertUpsInfo);
					//向数据表battery_info中插入数据
					BatteryInfo batteryInfo = upsInfo.getBatteryInfo();
					batteryInfo.setPowerId(upsInfo.getId());
					batteryInfo.setCreateTime(date);
					batteryInfo.setUpdateTime(date);
					int insertBatteryInfo = batteryInfoMapper.insert(batteryInfo);
					resultData.add(insertBatteryInfo);
				}
			}

			List<SmpsInfo> smpsInfos = configurationInfo.getSmpsInfos();
			if (smpsInfos != null && smpsInfos.size() > 0) {
				for (SmpsInfo smpsInfo : smpsInfos) {
					//向数据表smps_info中插入数据
					smpsInfo.setUpdateTime(date);
					smpsInfo.setCreateTime(date);
					smpsInfo.setConfigId(configurationInfo.getId());
					int insertSmps = smpsInfoMapper.insert(smpsInfo);
					resultData.add(insertSmps);
					//向数据表battery_info中插入数据
					TelBatteryInfo batteryInfo = smpsInfo.getTelBatteryInfo();
					batteryInfo.setPowerId(smpsInfo.getId());
					batteryInfo.setCreateTime(date);
					batteryInfo.setUpdateTime(date);
					if (batteryInfo.getBatteryVoltage() == 12) {
						batteryInfo.setEachBankNumber(4);
					} else {
						batteryInfo.setEachBankNumber(24);
					}
					int insertBatteryInfo = telBatteryInfoMapper.insert(batteryInfo);
					resultData.add(insertBatteryInfo);
				}
			}

			List<DirectCurrentPanelInfo> dcpis = configurationInfo.getDirectCurrentPanelInfos();
			if (dcpis != null && dcpis.size() > 0) {
				for (DirectCurrentPanelInfo dcpi : dcpis) {
					//向数据表direct_current_panel_info中插入数据
					dcpi.setConfigId(configurationInfo.getId());
					dcpi.setCreateTime(date);
					dcpi.setUpdateTime(date);
					int insertDcpi = directCurrentPanelInfoMapper.insert(dcpi);
					resultData.add(insertDcpi);
					//向数据表battery_info中插入数据
					PowBatteryInfo batteryInfo = dcpi.getPowBatteryInfo();
					batteryInfo.setPowerId(dcpi.getId());
					batteryInfo.setCreateTime(date);
					batteryInfo.setUpdateTime(date);
					int insertBatteryInfo = powBatteryInfoMapper.insert(batteryInfo);
					resultData.add(insertBatteryInfo);
				}
			}

			if (resultData.contains(0)) {
				throw new DataInsertFailException("数据插入失败，请稍后再试！");
			} else {
				return configData;
			}
		} catch (DataInsertFailException e) {
			throw e;
		} catch (ConfigException e) {
			throw new ConfigException("系统内部错误:" + e.getMessage());
		}
	}

	private Map<String, List<ExcelElement>> generatePowerutilityExcelConfig(ApplicationInfo applicationInfo
			, EnvironmentInfo environmentInfo, List<?> powerList) {
		boolean needManagement = applicationInfo.getManagementFunction();
		//根据语言加载不同的配置文件
		Properties properties = loadProperties(applicationInfo.getLanguage());
		//用于存Excel的数据
		Map<String, List<ExcelElement>> hardWareGroup = new LinkedHashMap<>();
		//同一型号电源的数量
		int powerTypeNum = powerList.size();
		//电源总数量
		int powerTotalNum = 0;
		//线槽总长
		int troughsLength = 0;
		//12V采集模块数量
		int acquisitionTWE = 0;
		//2V采集模块数量
		int acquisitionTWO = 0;
		//是否需要通信柜
		boolean needCommunicateCabinetAndSwitch = true;
		System.out.println("powerTypeNum:" + powerTypeNum);
		for (int i = 0; i < powerTypeNum; i++) {
			//判断是否需要采集模块
			boolean needSingleMonitor = true;

			Object power = powerList.get(i);
			Class<?> clazz = power.getClass();
			try {
				Method getBatteryInfo;
				if (applicationInfo.getApplication() == ApplicationEnum.DATACENTER.getApplication()) {
					//通过反射获取电源对象的getBatteryInfo方法
					getBatteryInfo = clazz.getDeclaredMethod("getBatteryInfo", new Class[0]);
				} else if (applicationInfo.getApplication() == ApplicationEnum.TELECOM.getApplication()) {
					getBatteryInfo = clazz.getDeclaredMethod("getTelBatteryInfo", new Class[0]);
				} else {
					getBatteryInfo = clazz.getDeclaredMethod("getPowBatteryInfo", new Class[0]);
				}
				//通过反射获取电源对象的getNumber方法
				Method getNumber = clazz.getDeclaredMethod("getNumber", new Class[0]);
				//通过反射获取电源对象的getBrand方法
				Method getBrand = clazz.getDeclaredMethod("getBrand", new Class[0]);
				//通过反射调用getBatteryInfo方法，获取batteryInfo的值
				BaseBatteryInfo batteryInfo = (BaseBatteryInfo) getBatteryInfo.invoke(power);
				//通过反射调用getNumber方法，获取powerNumber的值
				Integer powerNumber = (Integer) getNumber.invoke(power);
				//通过反射调用getBrand方法，获取Brand的值
				String powerBrand = (String) getBrand.invoke(power);
				//累加算出所有电源的数量
				powerTotalNum += powerNumber;
				//电源型号
				String model;
				//除了采集模块外的所有其他硬件
				List<ExcelElement> allHardware;
				//不同的应用场景获取不同的电源设备，调用不同的方法
				if (applicationInfo.getApplication() == ApplicationEnum.DATACENTER.getApplication()) {
					allHardware = setOtherDevices(needManagement, (UpsInfo) power, batteryInfo, properties);
					//通过反射获取电源对象的getModel方法
					Method getModel = clazz.getDeclaredMethod("getModel", new Class[0]);
					model = (String) getModel.invoke(power);
				} else if (applicationInfo.getApplication() == ApplicationEnum.TELECOM.getApplication()) {
					//设置电信应用场景电池的数量
					if (batteryInfo.getBatteryVoltage() == 12) {
						batteryInfo.setEachBankNumber(4);
					} else {
						batteryInfo.setEachBankNumber(24);
					}
					allHardware = setOtherDevices(needManagement, (SmpsInfo) power, batteryInfo, properties);
					needCommunicateCabinetAndSwitch = false;
					//电信应用场景中，电源信息里没有开关电源的信号信息
					model = "";
					Method neeSingleMonitor = clazz.getDeclaredMethod("getNeedSingleMonitor", new Class[0]);
					//判断是否需要单体采集模块
					needSingleMonitor = (boolean) neeSingleMonitor.invoke(power);
				} else {
					allHardware = setOtherDevices(needManagement, (DirectCurrentPanelInfo) power, batteryInfo, properties);
					//通过反射获取电源对象的getModel方法
					Method getModel = clazz.getDeclaredMethod("getModel", new Class[0]);
					model = (String) getModel.invoke(power);
				}
				//根据电池的数量和电池的宽计算需要线槽的长度
				troughsLength += batteryInfo.getWidth() * batteryInfo.getEachBankNumber()
						* batteryInfo.getBanks() * powerNumber;
				//一种类型UPS的电池数量
				int totalBatteryNun = powerNumber * batteryInfo.getBanks() * batteryInfo.getEachBankNumber();
				String powerColumnTitle;
				if ("中文".equals(applicationInfo.getLanguage())) {
					powerColumnTitle = powerNumber + "台" + powerBrand + " " + model + " 电源 "
							+ batteryInfo.getBanks() + "组" + batteryInfo.getBatteryVoltage() +
							"V" + batteryInfo.getBatteryCapacity() + "Ah共" + totalBatteryNun +
							"节电池";
				} else {
					String unit = "sets";
					if (powerNumber == 1) {
						unit = "set";
					}
					powerColumnTitle = powerNumber + " " + unit + " " + powerBrand + " " + model + " Power "
							+ batteryInfo.getBanks() + " banks " + batteryInfo.getBatteryVoltage() +
							"V" + batteryInfo.getBatteryCapacity() + "Ah " + totalBatteryNun +
							" batteries in total";
				}
				if (needSingleMonitor) {
					//设置采集模块配置信息
					ExcelElement acquisition = setAcquisition(properties, batteryInfo, powerNumber);
					if (batteryInfo.getBatteryVoltage() == 12) {
						acquisitionTWE += acquisition.getNumber();
					} else {
						acquisitionTWO += acquisition.getNumber();
					}
					allHardware.add(0, acquisition);
				}

				//设置网关硬件驱动的配置
				ExcelElement firmwawre = new ExcelElement();
				firmwawre.setTitle(properties.getProperty("excel.firmwawre.name"));
				firmwawre.setUnit(properties.getProperty("excel.firmwawre.unit"));
				firmwawre.setModel(properties.getProperty("excel.firmwawre.model"));
				firmwawre.setRemark(properties.getProperty("excel.firmwawre.remark"));
				firmwawre.setNumber(powerNumber);
				allHardware.add(firmwawre);
				hardWareGroup.put(powerColumnTitle, allHardware);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//工程安装配置
		List<ExcelElement> installationList = new ArrayList<>();
		//设置工程辅料
		ExcelElement engineeringMaterials = new ExcelElement();
		engineeringMaterials.setTitle(properties.getProperty("excel.engineeringMaterials.name"));
		engineeringMaterials.setUnit(properties.getProperty("excel.engineeringMaterials.unit"));
		engineeringMaterials.setRemark(properties.getProperty("excel.engineeringMaterials.remark"));
		engineeringMaterials.setModel("");
		engineeringMaterials.setNumber(powerTotalNum);
		//设置线槽
		ExcelElement troughs = new ExcelElement();
		troughs.setNumber((int) Math.ceil(troughsLength * 1.1 / 1000));
		troughs.setTitle(properties.getProperty("excel.troughs.name"));
		troughs.setUnit(properties.getProperty("excel.troughs.unit"));
		troughs.setModel(properties.getProperty("excel.troughs.model"));
		//判断是否需要通信柜和交换机
		if (needCommunicateCabinetAndSwitch) {
			//设置通信柜
			ExcelElement communicateCabinet = new ExcelElement();
			communicateCabinet.setTitle(properties.getProperty("excel.communicateCabinet.name"));
			communicateCabinet.setUnit(properties.getProperty("excel.communicateCabinet.unit"));
			communicateCabinet.setModel(properties.getProperty("excel.communicateCabinet.model"));
			communicateCabinet.setRemark(properties.getProperty("excel.communicateCabinet.remark"));
			communicateCabinet.setNumber(environmentInfo.getBatteryRoomNumber());
			//设置交换机
			ExcelElement switchDevice = new ExcelElement();
			switchDevice.setTitle(properties.getProperty("excel.switch.name"));
			switchDevice.setUnit(properties.getProperty("excel.switch.unit"));
			switchDevice.setRemark(properties.getProperty("excel.switch.remark"));
			switchDevice.setModel("");
			switchDevice.setNumber(environmentInfo.getBatteryRoomNumber());
			installationList.add(communicateCabinet);
			installationList.add(switchDevice);
		}
		installationList.add(engineeringMaterials);
		installationList.add(troughs);
		//工程安装数据组标题
		String installationTitle = properties.getProperty("excel.installation.title");
		hardWareGroup.put(installationTitle, installationList);

		//软件系统配置
		List<ExcelElement> platformList = new ArrayList<>();
		String platform = properties.getProperty("excel.platform.title");
		//设置平台软件
		ExcelElement platformSoftware = new ExcelElement();
		platformSoftware.setTitle(properties.getProperty("excel.platformSoftware.name"));
		platformSoftware.setUnit(properties.getProperty("excel.platformSoftware.unit"));
		platformSoftware.setModel(properties.getProperty("excel.platformSoftware.model"));
		platformSoftware.setRemark(properties.getProperty("excel.platformSoftware.remark"));
		platformSoftware.setNumber(1);
		platformList.add(platformSoftware);
		//设置服务器
		if (environmentInfo.getNeedServer()) {
			ExcelElement server = new ExcelElement();
			server.setTitle(properties.getProperty("excel.server.name"));
			server.setUnit(properties.getProperty("excel.server.unit"));
			server.setModel(properties.getProperty("excel.server.model"));
			server.setRemark(properties.getProperty("excel.server.remark"));
			server.setNumber(1);
			ExcelElement serverComputer = new ExcelElement();
			serverComputer.setTitle(properties.getProperty("excel.serverComputer.name"));
			serverComputer.setUnit(properties.getProperty("excel.serverComputer.unit"));
			serverComputer.setModel(properties.getProperty("excel.serverComputer.model"));
			serverComputer.setRemark(properties.getProperty("excel.serverComputer.remark"));
			serverComputer.setNumber(1);
			platformList.add(server);
			platformList.add(serverComputer);
		}
		//设置短信告警模块
		if (environmentInfo.getNeedGsmModem()) {
			ExcelElement gsmModem = new ExcelElement();
			gsmModem.setTitle(properties.getProperty("excel.gsmModem.name"));
			gsmModem.setUnit(properties.getProperty("excel.gsmModem.unit"));
			gsmModem.setModel(properties.getProperty("excel.gsmModem.model"));
			gsmModem.setRemark(properties.getProperty("excel.gsmModem.remark"));
			gsmModem.setNumber(1);
			platformList.add(gsmModem);
		}
		hardWareGroup.put(platform, platformList);

		//设置备品信息
		if (environmentInfo.getNeedBackup()) {
			if (!(acquisitionTWE == 0 && acquisitionTWO == 0)) {
				String backupTitle = properties.getProperty("excel.backupTitle.name");
				List<ExcelElement> backupList = new ArrayList<>();
				if (acquisitionTWE != 0) {
					ExcelElement backupTWE = new ExcelElement();
					backupTWE.setTitle(properties.getProperty("excel.acquisition.name"));
					backupTWE.setUnit(properties.getProperty("excel.acquisition.unit"));
					backupTWE.setRemark(properties.getProperty("excel.acquisition.remark"));
					backupTWE.setModel("SLSU4-12");
					backupTWE.setNumber((int) Math.ceil(acquisitionTWE * 0.03));
					backupList.add(backupTWE);
				}
				if (acquisitionTWO != 0) {
					ExcelElement backupTWO = new ExcelElement();
					backupTWO.setTitle(properties.getProperty("excel.acquisition.name"));
					backupTWO.setUnit(properties.getProperty("excel.acquisition.unit"));
					backupTWO.setRemark(properties.getProperty("excel.acquisition.remark"));
					backupTWO.setModel("SLSU4-2");
					backupTWO.setNumber((int) Math.ceil(acquisitionTWO * 0.03));
					backupList.add(backupTWO);
				}
				hardWareGroup.put(backupTitle, backupList);
			}
		}
		return hardWareGroup;
	}

	public ExcelElement setAcquisition(Properties properties, BaseBatteryInfo batteryInfo, int powerNumber) {
		//设置采集模块的信息
		ExcelElement acquisitionElement = new ExcelElement();
		acquisitionElement.setTitle(properties.getProperty("excel.acquisition.name"));
		acquisitionElement.setUnit(properties.getProperty("excel.acquisition.unit"));
		acquisitionElement.setRemark(properties.getProperty("excel.acquisition.remark"));
		String acquisitionModel = "";
		if (batteryInfo.getBatteryVoltage() == 12) {
			acquisitionModel = "SLSU4-12";
		} else {
			acquisitionModel = "SLSU4-2";
		}
		acquisitionElement.setModel(acquisitionModel);
		int acquisitionNum = (int) Math.ceil((batteryInfo.getEachBankNumber() / (double) 4)) * batteryInfo.getBanks() * powerNumber;
		acquisitionElement.setNumber(acquisitionNum);
		return acquisitionElement;
	}

	public List<ExcelElement> setOtherDevices(boolean needManagement, UpsInfo upsInfo, BaseBatteryInfo batteryInfo, Properties properties) {
		boolean isThreeWire = upsInfo.getIsThreeWire();
		Boolean needConvergence = upsInfo.getNeedConvergence();
		Boolean supportDryNode = upsInfo.getSupportDryNode();
		int upsTypeCode = (int) (Math.pow(2, 3) * booleanToint(needManagement) +
				Math.pow(2, 2) * booleanToint(isThreeWire) + Math.pow(2, 1) * booleanToint(needConvergence) +
				Math.pow(2, 0) * booleanToint(supportDryNode));
		UpsTypeEnum upsTypeEnum = UpsTypeEnum.stateOf(upsTypeCode);
		List<ExcelElement> excelElements = new ArrayList<>();
		if (upsTypeEnum.isNeedSmartHallSensor()) {
			ExcelElement hallSensorElement = new ExcelElement();
			hallSensorElement.setTitle(properties.getProperty("excel.hallSensor.name"));
			hallSensorElement.setUnit(properties.getProperty("excel.hallSensor.unit"));
			hallSensorElement.setRemark(properties.getProperty("excel.hallSensor.remark"));
			hallSensorElement.setModel(properties.getProperty("excel.hallSensor.model"));
			hallSensorElement.setNumber(upsInfo.getNumber() * batteryInfo.getBanks());
			excelElements.add(hallSensorElement);
		}
		if (upsTypeEnum.isNeddSmartVoltagecollector()) {
			ExcelElement voltageCollector = new ExcelElement();
			voltageCollector.setTitle(properties.getProperty("excel.voltageCollector.name"));
			voltageCollector.setUnit(properties.getProperty("excel.voltageCollector.unit"));
			voltageCollector.setRemark(properties.getProperty("excel.voltageCollector.remark"));
			voltageCollector.setModel(properties.getProperty("excel.voltageCollector.model"));
			voltageCollector.setNumber(upsInfo.getNumber());
			excelElements.add(voltageCollector);
		}
		if (upsTypeEnum.isNeedLeageSensor()) {
			ExcelElement leakageSensor = new ExcelElement();
			leakageSensor.setTitle(properties.getProperty("excel.leakageSensor.name"));
			leakageSensor.setUnit(properties.getProperty("excel.leakageSensor.unit"));
			leakageSensor.setRemark(properties.getProperty("excel.leakageSensor.remark"));
			leakageSensor.setModel(properties.getProperty("excel.leakageSensor.model"));
			leakageSensor.setNumber(upsInfo.getNumber());
			excelElements.add(leakageSensor);
		}
		if (upsTypeEnum.isNeedSmartGateWay()) {
			ExcelElement smartGateway = new ExcelElement();
			smartGateway.setTitle(properties.getProperty("excel.smartGateway.name"));
			smartGateway.setUnit(properties.getProperty("excel.smartGateway.unit"));
			smartGateway.setRemark(properties.getProperty("excel.smartGateway.remark"));
			smartGateway.setNumber(upsInfo.getNumber());
			if (upsInfo.getSupportDryNode() && needManagement) {
				smartGateway.setModel(properties.getProperty("excel.smartGateway.dryNodeModel"));
			} else {
				smartGateway.setModel(properties.getProperty("excel.smartGateway.baseModel"));
			}
			excelElements.add(smartGateway);
		}
		if (upsTypeEnum.isNeedConvergenceCabinet()) {
			ExcelElement convergenceCabinet = new ExcelElement();
			convergenceCabinet.setTitle(properties.getProperty("excel.convergenceCabinet.name"));
			convergenceCabinet.setUnit(properties.getProperty("excel.convergenceCabinet.unit"));
			convergenceCabinet.setRemark(properties.getProperty("excel.convergenceCabinet.remark"));
			//计算电池组的最大充电电压和每组电池的最大电流
			int voltage = batteryInfo.getBatteryVoltage();
			double maxCurrent = 0;
			if (voltage == 12) {
				//如果电池组大于1组则最大电流按电池组数-1来计算
				if (batteryInfo.getBanks() > 1) {
					maxCurrent = upsInfo.getPower() * 1000 / 6 / 1.75 / batteryInfo.getEachBankNumber() / (batteryInfo.getBanks() - 1);
				} else {
					maxCurrent = upsInfo.getPower() * 1000 / 6 / 1.75 / batteryInfo.getEachBankNumber() / batteryInfo.getBanks();
				}
			} else {
				if (batteryInfo.getBanks() > 1) {
					maxCurrent = upsInfo.getPower() * 1000 / 1.75 / batteryInfo.getEachBankNumber() / (batteryInfo.getBanks() - 1);
				} else {
					maxCurrent = upsInfo.getPower() * 1000 / 1.75 / batteryInfo.getEachBankNumber() / batteryInfo.getBanks();
				}
			}

			//柜子型号说明，1.两线制控制柜；2.三线制控制柜；3.两线制管理规；4.三线制管理规；5.两线制汇流柜；6.三线制汇流柜;
			String model = "";
			if (upsInfo.getIsThreeWire()) {
				model = cabinetDeviceMapper.selectConvergenceByInfo(6, batteryInfo.getBanks(), maxCurrent);
			} else {
				model = cabinetDeviceMapper.selectConvergenceByInfo(5, batteryInfo.getBanks(), maxCurrent);
			}
			convergenceCabinet.setModel(model);
			convergenceCabinet.setNumber(upsInfo.getNumber());
			excelElements.add(convergenceCabinet);
		}
		if (upsTypeEnum.isNeedManagementCabinet()) {
			ExcelElement managementCabinet = new ExcelElement();
			managementCabinet.setTitle(properties.getProperty("excel.managementCabinet.name"));
			managementCabinet.setUnit(properties.getProperty("excel.managementCabinet.unit"));
			managementCabinet.setRemark(properties.getProperty("excel.managementCabinet.remark"));
			managementCabinet.setNumber(upsInfo.getNumber());
			//计算管理规的型号
			//计算电池组的最大充电电压和每组电池的最大电流
			int voltage = batteryInfo.getBatteryVoltage();
			double maxCurrent = 0;
			if (voltage == 12) {
				//如果电池组大于1组则最大电流按电池组数-1来计算
				if (batteryInfo.getBanks() > 1) {
					maxCurrent = upsInfo.getPower() * 1000 / 6 / 1.75 / batteryInfo.getEachBankNumber() / (batteryInfo.getBanks() - 1);
				} else {
					maxCurrent = upsInfo.getPower() * 1000 / 6 / 1.75 / batteryInfo.getEachBankNumber() / batteryInfo.getBanks();
				}
			} else {
				if (batteryInfo.getBanks() > 1) {
					maxCurrent = upsInfo.getPower() * 1000 / 1.75 / batteryInfo.getEachBankNumber() / (batteryInfo.getBanks() - 1);
				} else {
					maxCurrent = upsInfo.getPower() * 1000 / 1.75 / batteryInfo.getEachBankNumber() / batteryInfo.getBanks();
				}
			}
			//柜子型号说明，1.两线制控制柜；2.三线制控制柜；3.两线制管理规；4.三线制管理规；5.两线制汇流柜；6.三线制汇流柜;
			String model = "";
			if (upsInfo.getIsThreeWire()) {
				model = cabinetDeviceMapper.selectManagementCabinetByInfo(4, batteryInfo.getBanks(), maxCurrent);
			} else {
				model = cabinetDeviceMapper.selectManagementCabinetByInfo(3, batteryInfo.getBanks(), maxCurrent);
			}
			managementCabinet.setModel(model);
			excelElements.add(managementCabinet);
		}
		if (upsTypeEnum.isNeedSmartControlCabinet()) {
			ExcelElement controlCabinet = new ExcelElement();
			controlCabinet.setTitle(properties.getProperty("excel.controlCabinet.name"));
			controlCabinet.setUnit(properties.getProperty("excel.controlCabinet.unit"));
			controlCabinet.setRemark(properties.getProperty("excel.controlCabinet.remark"));
			controlCabinet.setNumber(upsInfo.getNumber());
			int voltage = batteryInfo.getBatteryVoltage();
			double maxCurrent = 0;
			double totalVoltage = voltage * batteryInfo.getEachBankNumber();
			if (voltage == 12) {
				//如果电池组大于1组则最大电流按电池组数-1来计算
				maxCurrent = upsInfo.getPower() * 1000 / 6 / 1.75 / batteryInfo.getEachBankNumber();
			} else {
				maxCurrent = upsInfo.getPower() * 1000 / 1.75 / batteryInfo.getEachBankNumber();
			}
			//柜子型号说明，1.两线制控制柜；2.三线制控制柜；3.两线制管理规；4.三线制管理规；5.两线制汇流柜；6.三线制汇流柜;
			String model = "";
			if (upsInfo.getIsThreeWire()) {
				model = cabinetDeviceMapper.selectControlCabinetByInfo(2, totalVoltage, maxCurrent);
			} else {
				model = cabinetDeviceMapper.selectControlCabinetByInfo(1, totalVoltage, maxCurrent);
			}
			controlCabinet.setModel(model);
			excelElements.add(controlCabinet);
		}
		return excelElements;
	}

	public List<ExcelElement> setOtherDevices(boolean needManagement, SmpsInfo smpsInfo, BaseBatteryInfo batteryInfo, Properties properties) {
		Boolean needEnergySaving = smpsInfo.getNeedEnergySaving();
		Boolean needSmartMeter = smpsInfo.getNeedSmartMeter();
		Boolean needLeakageSensor = smpsInfo.getNeedLeakageSensor();
		List<ExcelElement> excelElements = new ArrayList<>();
		//如果不需要管理功能，则添加不带管理功能的网关
		ExcelElement smartGateway = new ExcelElement();
		smartGateway.setTitle(properties.getProperty("excel.smartGateway.name"));
		smartGateway.setUnit(properties.getProperty("excel.smartGateway.unit"));
		smartGateway.setRemark(properties.getProperty("excel.smartGateway.remark"));
		smartGateway.setNumber(smpsInfo.getNumber());
		//根据不同的应用场景选择不同的网关型号
		if (!needManagement) {
			smartGateway.setModel(properties.getProperty("excel.smartGateway.telecomBaseModel"));
			//霍尔传感器
			ExcelElement smartHallSensor = new ExcelElement();
			smartHallSensor.setTitle(properties.getProperty("excel.hallSensor.name"));
			smartHallSensor.setUnit(properties.getProperty("excel.hallSensor.unit"));
			smartHallSensor.setRemark(properties.getProperty("excel.hallSensor.remark"));
			smartHallSensor.setModel(properties.getProperty("excel.hallSensor.model100"));
			smartHallSensor.setNumber(batteryInfo.getBanks() * smpsInfo.getNumber());
			excelElements.add(smartHallSensor);
		} else {
			double maxCurrent = smpsInfo.getPower() * 1000 / 46;
			int banks = batteryInfo.getBanks();
			if (maxCurrent < 100 && banks <= 1) {
				smartGateway.setModel(properties.getProperty("excel.smartGateway.telecomControlModel101"));
			} else if (maxCurrent >= 100 && banks <= 1) {
				smartGateway.setModel(properties.getProperty("excel.smartGateway.telecomControlModel201"));
			} else if (maxCurrent < 100 && banks > 1) {
				smartGateway.setModel(properties.getProperty("excel.smartGateway.telecomControlModel102"));
			} else {
				smartGateway.setModel(properties.getProperty("excel.smartGateway.telecomControlModel202"));
			}
		}
		excelElements.add(smartGateway);
		//空调红外控制器
		if (needEnergySaving) {
			ExcelElement infraredController = new ExcelElement();
			infraredController.setTitle(properties.getProperty("excel.infraredController.name"));
			infraredController.setUnit(properties.getProperty("excel.infraredController.unit"));
			infraredController.setRemark(properties.getProperty("excel.infraredController.remark"));
			infraredController.setModel("");
			infraredController.setNumber(smpsInfo.getNumber());
			excelElements.add(infraredController);
		}
		//智能电表
		if (needSmartMeter) {
			ExcelElement smartElectricMeter = new ExcelElement();
			smartElectricMeter.setTitle(properties.getProperty("excel.smartElectricMeter.name"));
			smartElectricMeter.setUnit(properties.getProperty("excel.smartElectricMeter.unit"));
			smartElectricMeter.setRemark(properties.getProperty("excel.smartElectricMeter.remark"));
			smartElectricMeter.setModel("");
			smartElectricMeter.setNumber(smpsInfo.getNumber());
			excelElements.add(smartElectricMeter);
		}
		//漏电流传感器
		if (needLeakageSensor) {
			ExcelElement leakageSensor = new ExcelElement();
			leakageSensor.setTitle(properties.getProperty("excel.leakageSensor.name"));
			leakageSensor.setUnit(properties.getProperty("excel.leakageSensor.unit"));
			leakageSensor.setModel(properties.getProperty("excel.leakageSensor.model"));
			leakageSensor.setRemark(properties.getProperty("excel.leakageSensor.remark"));
			leakageSensor.setNumber(smpsInfo.getNumber());
			excelElements.add(leakageSensor);
		}
		return excelElements;
	}

	public List<ExcelElement> setOtherDevices(boolean needManagement, DirectCurrentPanelInfo dcpInfo, BaseBatteryInfo batteryInfo, Properties properties) {
		Boolean needLeakageSensor = dcpInfo.getNeedLeakageSensor();
		List<ExcelElement> excelElements = new ArrayList<>();
		if (!needManagement) {
			ExcelElement smartGateway = new ExcelElement();
			smartGateway.setTitle(properties.getProperty("excel.smartGateway.name"));
			smartGateway.setUnit(properties.getProperty("excel.smartGateway.unit"));
			smartGateway.setModel(properties.getProperty("excel.smartGateway.baseModel"));
			if (batteryInfo.getBatteryVoltage() == 12) {
				//如果是12V电池，每个直流屏配一台网关
				smartGateway.setNumber(dcpInfo.getNumber());
			} else {
				//如果是2V电池，每组电池配一台网关
				smartGateway.setNumber(dcpInfo.getNumber() * batteryInfo.getBanks());
			}
			excelElements.add(smartGateway);
			//霍尔传感器
			ExcelElement smartHallSensor = new ExcelElement();
			smartHallSensor.setTitle(properties.getProperty("excel.hallSensor.name"));
			smartHallSensor.setUnit(properties.getProperty("excel.hallSensor.unit"));
			smartHallSensor.setRemark(properties.getProperty("excel.hallSensor.remark"));
			smartHallSensor.setModel(properties.getProperty("excel.hallSensor.model100"));
			smartHallSensor.setNumber(batteryInfo.getBanks() * dcpInfo.getNumber());
			excelElements.add(smartHallSensor);
			//电压采集器
			ExcelElement voltageCollector = new ExcelElement();
			voltageCollector.setTitle(properties.getProperty("excel.voltageCollector.name"));
			voltageCollector.setUnit(properties.getProperty("excel.voltageCollector.unit"));
			voltageCollector.setRemark(properties.getProperty("excel.voltageCollector.remark"));
			voltageCollector.setModel(properties.getProperty("excel.voltageCollector.model"));
			voltageCollector.setNumber(dcpInfo.getNumber());
			excelElements.add(voltageCollector);
		} else {
			double maxCurrent = Math.max(dcpInfo.getMaxChargeCurrent(), dcpInfo.getMaxDischargeCurrent());
			ExcelElement controlDevice = new ExcelElement();
			if (maxCurrent <= 200) {
				controlDevice.setTitle(properties.getProperty("excel.controlBox.name"));
				controlDevice.setUnit(properties.getProperty("excel.controlBox.unit"));
				controlDevice.setRemark(properties.getProperty("excel.controlBox.remark"));
				controlDevice.setModel(properties.getProperty("excel.controlBox.model"));
			} else {
				int voltage = batteryInfo.getEachBankNumber() * batteryInfo.getBatteryVoltage();
				controlDevice.setTitle(properties.getProperty("excel.controlCabinet.name"));
				controlDevice.setUnit(properties.getProperty("excel.controlCabinet.unit"));
				controlDevice.setRemark(properties.getProperty("excel.controlCabinet.remark"));
				String model = cabinetDeviceMapper.selectControlCabinetByInfo(1, voltage, maxCurrent);
				controlDevice.setModel(model);
			}
			//TODO 确认泰国电力三组电池是否共用一台直流屏
			controlDevice.setNumber(dcpInfo.getNumber());
			excelElements.add(controlDevice);
			if (needLeakageSensor) {
				ExcelElement leakageSensor = new ExcelElement();
				leakageSensor.setUnit(properties.getProperty("excel.leakageSensor.unit"));
				leakageSensor.setTitle(properties.getProperty("excel.leakageSensor.name"));
				leakageSensor.setModel(properties.getProperty("excel.leakageSensor.model"));
				leakageSensor.setRemark(properties.getProperty("excel.leakageSensor.remark"));
				leakageSensor.setNumber(dcpInfo.getNumber());
				excelElements.add(leakageSensor);
			}
		}
		return excelElements;
	}

	public int booleanToint(boolean val) {
		if (val) {
			return 1;
		} else {
			return 0;
		}
	}


}
