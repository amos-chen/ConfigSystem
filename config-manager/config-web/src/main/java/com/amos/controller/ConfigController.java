package com.amos.controller;

import com.amos.dto.ExcelElement;
import com.amos.dto.ExecuteItemsJsonResult;
import com.amos.pojo.ApplicationInfo;
import com.amos.pojo.ConfigResult;
import com.amos.pojo.ConfigurationInfo;
import com.amos.service.ConfigService;
import com.amos.utils.ExcelUtils;
import com.amos.utils.ExecuteJsonResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by chenlunwei on 2018/2/15.
 */
@Controller
@RequestMapping(value = "/config")
public class ConfigController {

	@Autowired
	private ConfigService configService;

	@RequestMapping(value = "/ups/configuration", method = RequestMethod.POST)
	@ResponseBody
	public void addDataCenterConfig(@RequestBody ConfigurationInfo configurationInfo,
									HttpServletRequest request, HttpServletResponse response) {
		try {
			Map<String, List<ExcelElement>> excelData = configService.insertConfiguration(configurationInfo);
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String createDate = sdf.format(date);
			String excelFileName = configurationInfo.getApplicationInfo().getProjectTitle() + "配置" + createDate;
			String language = configurationInfo.getApplicationInfo().getLanguage();
			ExcelUtils.export(language, excelFileName, excelData, response, request);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/telecom/configuration", method = RequestMethod.POST)
	@ResponseBody
	public void addTelecomConfig(@RequestBody ConfigurationInfo configurationInfo,
								 HttpServletRequest request, HttpServletResponse response) {
		try {
			Map<String, List<ExcelElement>> excelData = configService.insertConfiguration(configurationInfo);
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String createDate = sdf.format(date);
			String excelFileName = configurationInfo.getApplicationInfo().getProjectTitle() + "配置" + createDate;
			String language = configurationInfo.getApplicationInfo().getLanguage();
			ExcelUtils.export(language, excelFileName, excelData, response, request);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/powerutility/configuration", method = RequestMethod.POST)
	public void addPowerutilityConfig(@RequestBody ConfigurationInfo configurationInfo,
									  HttpServletRequest request, HttpServletResponse response) {
		try {
			Map<String, List<ExcelElement>> excelData = configService.insertConfiguration(configurationInfo);
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String createDate = sdf.format(date);
			String excelFileName = configurationInfo.getApplicationInfo().getProjectTitle() + "配置" + createDate;
			String language = configurationInfo.getApplicationInfo().getLanguage();
			ExcelUtils.export(language, excelFileName, excelData, response, request);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/configuration/list", method = RequestMethod.GET)
	@ResponseBody
	public ExecuteItemsJsonResult<List<ApplicationInfo>> listApplication(Integer offset, Integer limit, String search, String sort,
																		 String order) {
		ExecuteItemsJsonResult<List<ApplicationInfo>> result;
		try {
			PageHelper.offsetPage(offset, limit);
			List<ApplicationInfo> configList = configService.queryList(search,order);
			PageInfo<ApplicationInfo> configPageInfo = new PageInfo<>(configList);
			long total = configPageInfo.getTotal();
			result = new ExecuteItemsJsonResult<>(true, total, configList);
		} catch (Exception e) {
			result = new ExecuteItemsJsonResult<>(false, e.getMessage());
		}
		return result;
	}

	@RequestMapping(value = "/{configId}/Info", method = RequestMethod.GET)
	@ResponseBody
	public ExecuteJsonResult<Map<String, Object>> getConfigInfo(@PathVariable("configId") Integer configId) {
		ExecuteJsonResult<Map<String, Object>> result;
		try {
			Map<String, Object> resultMap = configService.queryConfigInfo(configId);
			result = new ExecuteJsonResult<>(true, resultMap);
		} catch (Exception e) {
			result = new ExecuteJsonResult<>(false, e.getMessage());
		}
		return result;
	}

	@RequestMapping(value = "/{configId}/Result", method = RequestMethod.GET)
	@ResponseBody
	public ExecuteJsonResult<ConfigResult> getConfigResult(@PathVariable("configId") Integer configId) {


		ExecuteJsonResult<ConfigResult> result;
		try {
			ConfigResult configResult = configService.queryConfigResult(configId);
			result = new ExecuteJsonResult<>(true, configResult);
		} catch (Exception e) {
			result = new ExecuteJsonResult<>(false, e.getMessage());
		}
		return result;
	}

	@RequestMapping(value = "/download/configuration", method = RequestMethod.POST)
	@ResponseBody
	public void downloadConfig(Integer configId,Integer application,String projectName,String language,
							   HttpServletRequest request, HttpServletResponse response) {
		try {
			Map<String, List<ExcelElement>> excelData = configService.getConfiguration(configId,application);
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String createDate = sdf.format(date);
			String excelFileName = projectName + "配置" + createDate;
			ExcelUtils.export(language, excelFileName, excelData, response, request);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
