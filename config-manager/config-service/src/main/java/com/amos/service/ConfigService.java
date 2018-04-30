package com.amos.service;

import com.amos.dto.ExcelElement;
import com.amos.pojo.ApplicationInfo;
import com.amos.pojo.ConfigResult;
import com.amos.pojo.ConfigurationInfo;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by chenlunwei on 2018/2/16.
 */
public interface ConfigService {

	Map<String,List<ExcelElement>> insertConfiguration(ConfigurationInfo configurationInfo);

	List<ApplicationInfo> queryList(String search,String order);

	Map<String, Object> queryConfigInfo(Integer configId);

	ConfigResult queryConfigResult(Integer configId);

	Map<String,List<ExcelElement>> getConfiguration(Integer configId,Integer application);

}
