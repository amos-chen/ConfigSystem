package com.amos.service;

import com.amos.dto.JSTree;
import com.amos.exception.ConfigException;
import com.amos.exception.DataInsertFailException;
import com.amos.pojo.HardwareParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by ${chenlunwei} on 2018/4/11.
 */
public interface HardwareService {

    List<JSTree> getJSTreeNodes();

    List<Integer> addHardwareCat(String[] parentId,String catName) throws DataInsertFailException,ConfigException;

    int updateContentCat(String id, String catName);

    Integer deleteContentCat(String id);

    List<HardwareParam> queryParamList(String cid,String search);

    List<Integer> addHardwareContent(MultipartFile[] files, HardwareParam hardwareParam, Integer cid);

    Integer updateHardwareContent(MultipartHttpServletRequest request, HardwareParam hardwareParam);

    List deleteContent(String[] contentIdList, String cid);

    void download(Integer id,HttpServletResponse response);
}
