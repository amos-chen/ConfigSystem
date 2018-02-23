package com.amos.controller;


import com.amos.dao.*;
import com.amos.service.ConfigService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by chenlunwei on 2018/2/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-*.xml")
public class ConfigControllerTest {
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
	private ConfigService configService;

	/*@Test
	public void addConfig() throws Exception {
		Properties props = com.amos.utils.PropertyUtil.loadProps("/properties/excel-zh.properties");
		String property = props.getProperty("excel.acquisition.name");
		System.out.println(property);

	}

	@Test
	public void test01() {
		Date date = new Date();
		ConfigResult result = new ConfigResult();
		ConfigurationInfo configurationInfo = new ConfigurationInfo();
		ApplicationInfo applicationInfo = new ApplicationInfo();
		EnvironmentInfo environmentInfo = new EnvironmentInfo();
		List<UpsInfo> upsInfos = new ArrayList<>();
		UpsInfo upsInfo = new UpsInfo();
		BatteryInfo batteryInfo = new BatteryInfo();
		result.setTitle("1");
		result.setConfigData("1");
//		result.setConfigurationInfo(configurationInfo);
		configResultMapper.insert(result);

		configurationInfo.setConfigResultId(result.getId());
//		configurationInfo.setApplicationInfo(applicationInfo);
//		configurationInfo.setUpsInfos(upsInfos);
//		configurationInfo.setEnvironmentInfo(environmentInfo);
		configurationInfoMapper.insert(configurationInfo);

		applicationInfo.setConfigId(configurationInfo.getId());
		applicationInfo.setApplication(1);
		applicationInfo.setLanguage("2");
		applicationInfo.setManagementFunction(true);
		applicationInfo.setProjectTitle("2");
		applicationInfoMapper.insert(applicationInfo);

		environmentInfo.setConfigId(configurationInfo.getId());
		environmentInfo.setBatteryRoomNumber(3);
		environmentInfo.setNeedBackup(true);
		environmentInfo.setNeedGsmModem(true);
		environmentInfo.setNeedServer(true);
		environmentInfoMapper.insert(environmentInfo);

		upsInfo.setBrand("3");
		upsInfo.setConfigId(configurationInfo.getId());
		upsInfo.setIsThreeWire(true);
		upsInfo.setModel("3");
		upsInfo.setNeedConvergence(true);
		upsInfo.setNumber(3);
		upsInfo.setPower(3);
		upsInfo.setSupportDryNode(true);
//		upsInfo.setBatteryInfo(batteryInfo);
		upsInfos.add(upsInfo);
		upsInfoMapper.insert(upsInfo);

		batteryInfo.setBanks(4);
		batteryInfo.setBatteryCapacity(4);
		batteryInfo.setBatteryVoltage(4);
		batteryInfo.setBusDiameter(4);
		batteryInfo.setEachBankNumber(4);
		batteryInfo.setPowerId(upsInfo.getId());
		batteryInfo.setWidth(4d);
		batteryInfoMapper.insert(batteryInfo);

	}

	@Test
	public void test02() {
		String dataCenterJson = "{\"applicationInfo\":{\"projectTitle\":\"东江湖项目\",\"application\":\"1\",\"managementFunction\":\"1\",\"language\":\"中文\"},\"environmentInfo\":{\"needServer\":\"1\",\"needGsmModem\":\"1\",\"needBackup\":\"1\",\"batteryRoomNumber\":\"3\"},\"upsInfos\":[{\"brand\":\"施耐德\",\"model\":\"Galaxy7000\",\"power\":\"500\",\"number\":\"5\",\"isThreeWire\":\"0\",\"needConvergence\":\"1\",\"supportDryNode\":\"0\",\"batteryInfo\":{\"batteryVoltage\":\"12\",\"batteryCapacity\":\"200\",\"banks\":\"3\",\"eachBankNumber\":\"44\",\"busDiameter\":\"240\",\"width\":\"200\"}},{\"brand\":\"艾默生\",\"model\":\"NXr\",\"power\":\"500\",\"number\":\"2\",\"isThreeWire\":\"0\",\"needConvergence\":\"1\",\"supportDryNode\":\"0\",\"batteryInfo\":{\"batteryVoltage\":\"12\",\"batteryCapacity\":\"230\",\"banks\":\"3\",\"eachBankNumber\":\"40\",\"busDiameter\":\"240\",\"width\":\"200\"}}]}";
		String telecomJson = "{\"applicationInfo\":{\"projectTitle\":\"东莞联通\",\"application\":\"2\",\"managementFunction\":\"true\",\"language\":\"中文\"},\"environmentInfo\":{\"needServer\":\"false\",\"needGsmModem\":\"false\",\"needBackup\":\"true\"},\"smpsInfos\":[{\"brand\":\"中国联通\",\"power\":\"2\",\"number\":\"2\",\"needSingleMonitor\":\"false\",\"needEnergySaving\":\"true\",\"needSmartMeter\":\"true\",\"needLeakageSensor\":\"false\",\"telBatteryInfo\":{\"batteryVoltage\":\"2\",\"batteryCapacity\":\"500\",\"banks\":\"2\",\"busDiameter\":\"70\",\"width\":\"200\"}},{\"brand\":\"中国联通\",\"power\":\"2\",\"number\":\"2\",\"needSingleMonitor\":\"true\",\"needEnergySaving\":\"true\",\"needSmartMeter\":\"true\",\"needLeakageSensor\":\"false\",\"telBatteryInfo\":{\"batteryVoltage\":\"2\",\"batteryCapacity\":\"500\",\"banks\":\"2\",\"busDiameter\":\"70\",\"width\":\"200\"}}]}";
		String powerutilityJson="{\"applicationInfo\":{\"projectTitle\":\"越南电力\",\"application\":\"3\",\"managementFunction\":\"true\",\"language\":\"英文\"},\"environmentInfo\":{\"needServer\":\"false\",\"needGsmModem\":\"false\",\"needBackup\":\"true\",\"batteryRoomNumber\":\"2\"},\"directCurrentPanelInfos\":[{\"brand\":\"NTC\",\"model\":\"200-800\",\"number\":\"1\",\"maxChargeCurrent\":\"431.85\",\"maxDischargeCurrent\":\"800\",\"needLeakageSensor\":\"false\",\"powBatteryInfo\":{\"batteryVoltage\":\"2\",\"batteryCapacity\":\"1000\",\"banks\":\"1\",\"eachBankNumber\":\"107\",\"busDiameter\":\"240\",\"width\":\"230\"}},{\"brand\":\"NTC\",\"model\":\"200-100\",\"number\":\"2\",\"maxChargeCurrent\":\"50\",\"maxDischargeCurrent\":\"100\",\"needLeakageSensor\":\"true\",\"powBatteryInfo\":{\"batteryVoltage\":\"2\",\"batteryCapacity\":\"300\",\"banks\":\"2\",\"eachBankNumber\":\"107\",\"busDiameter\":\"70\",\"width\":\"200\"}}]}";
		ConfigurationInfo configurationInfo = JsonUtils.parseJsonToObj(powerutilityJson, ConfigurationInfo.class);
		Map<String, List<ExcelElement>> stringListMap = configService.insertConfiguration(configurationInfo);
		ExcelUtils.export("中文", "/Users/chenlunwei/Desktop/config/test.xlsx", stringListMap, null, null);

		System.out.println(JsonUtils.objectToJson(stringListMap));
	}

	@Test
	public void test03() {
		for (int i = 81; i < 84; i++) {
			configResultMapper.deleteByPrimaryKey(i);
		}


	}*/

}