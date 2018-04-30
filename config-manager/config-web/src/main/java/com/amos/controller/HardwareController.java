package com.amos.controller;

import com.amos.dao.HardwareParamMapper;
import com.amos.dto.ExcelElement;
import com.amos.dto.ExecuteItemsJsonResult;
import com.amos.dto.JSTree;
import com.amos.exception.ConfigException;
import com.amos.exception.DataDeleteFailException;
import com.amos.exception.DataInsertFailException;
import com.amos.exception.DataUpdateFailException;
import com.amos.pojo.HardwareParam;
import com.amos.service.HardwareService;
import com.amos.utils.ExcelUtils;
import com.amos.utils.ExecuteJsonResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by ${chenlunwei} on 2018/4/11.
 */
@Controller
@RequestMapping("/config/hardware")
public class HardwareController {
    @Autowired
    private HardwareService hardwareService;

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    @ResponseBody
    public List<JSTree> getHardwareCat() {
        return hardwareService.getJSTreeNodes();
    }


    @RequestMapping(value = "/category/add", method = RequestMethod.POST,
            produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public ExecuteJsonResult<List<Integer>> getContentCatList(String[] ParentId, String ContentName) {
        ExecuteJsonResult<List<Integer>> result;
        try {
            List<Integer> data = hardwareService.addHardwareCat(ParentId, ContentName);
            result = new ExecuteJsonResult<>(true, data);
            return result;
        } catch (DataInsertFailException e) {
            result = new ExecuteJsonResult<>(false, e.getMessage());
            return result;
        } catch (ConfigException e) {
            result = new ExecuteJsonResult<>(false, e.getMessage());
            return result;
        }
    }


    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST,
            produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public ExecuteJsonResult<Integer> updateContentCat(@PathVariable("id") String id, String ContentName) {
        ExecuteJsonResult<Integer> result;
        try {
            int data = hardwareService.updateContentCat(id, ContentName);
            result = new ExecuteJsonResult<>(true, data);
            return result;
        } catch (DataUpdateFailException e) {
            result = new ExecuteJsonResult<>(false, e.getMessage());
            return result;
        } catch (ConfigException e) {
            result = new ExecuteJsonResult<>(false, e.getMessage());
            return result;
        }
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST,
            produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public ExecuteJsonResult<Integer> deleteContentCat(@PathVariable("id") String id) {
        ExecuteJsonResult<Integer> result;
        try {
            Integer data = hardwareService.deleteContentCat(id);
            result = new ExecuteJsonResult<>(true, data);
            return result;
        } catch (DataUpdateFailException e) {
            result = new ExecuteJsonResult<>(false, e.getMessage());
            return result;
        } catch (ConfigException e) {
            result = new ExecuteJsonResult<>(false, e.getMessage());
            return result;
        }
    }

    @RequestMapping(value = "/param/list", method = RequestMethod.GET)
    @ResponseBody
    public ExecuteItemsJsonResult<List<HardwareParam>> queryList(String id, Integer offset, Integer limit, String search, String sort,
                                                                 String order) {
        ExecuteItemsJsonResult<List<HardwareParam>> result;
        try {
            PageHelper.offsetPage(offset, limit);
            List<HardwareParam> hardwareParams = hardwareService.queryParamList(id,search);
            PageInfo<HardwareParam> tbContentPageInfo = new PageInfo<>(hardwareParams);
            long total = tbContentPageInfo.getTotal();
            result = new ExecuteItemsJsonResult<>(true, total, hardwareParams);
        } catch (Exception e) {
            result = new ExecuteItemsJsonResult<>(false, e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "/add/{cid}/content", method = RequestMethod.POST)
    @ResponseBody
    public ExecuteJsonResult<List<Integer>> addHardwareContent(@PathVariable("cid") Integer cid, HardwareParam hardwareParam,
                                   @RequestParam("fileInput") MultipartFile[] files) {
        System.out.println(files.length);
        ExecuteJsonResult<List<Integer>> result;
        try {
            List<Integer> data = hardwareService.addHardwareContent(files, hardwareParam, cid);
            result = new ExecuteJsonResult<>(true, data);
            return result;
        } catch (DataUpdateFailException e) {
            result = new ExecuteJsonResult<>(false, e.getMessage());
            return result;
        } catch (ConfigException e) {
            result = new ExecuteJsonResult<>(false, e.getMessage());
            return result;
        }
    }

    @RequestMapping(value = "/update/content", method = RequestMethod.POST)
    @ResponseBody
    public ExecuteJsonResult<Integer> updateHardwareContent(HardwareParam hardwareParam,
                                                         HttpServletRequest request) {
        ExecuteJsonResult<Integer> result;
        try {
            Integer data = hardwareService.updateHardwareContent((MultipartHttpServletRequest) request, hardwareParam);
            result = new ExecuteJsonResult<>(true, data);
            return result;
        } catch (DataUpdateFailException e) {
            result = new ExecuteJsonResult<>(false, e.getMessage());
            return result;
        } catch (ConfigException e) {
            result = new ExecuteJsonResult<>(false, e.getMessage());
            return result;
        }
    }

    @RequestMapping(value = "/delete/content",method = RequestMethod.POST,
            produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public ExecuteJsonResult<List<Integer>> deleteContent(String[] contentIdList,String cid){
        ExecuteJsonResult<List<Integer>> result;
        try {
            List data = hardwareService.deleteContent(contentIdList,cid);
            result = new ExecuteJsonResult<List<Integer>>(true,data);
            return result;
        }catch (DataDeleteFailException e){
            return new ExecuteJsonResult<>(false,e.getMessage());
        }catch (ConfigException e){
            return new ExecuteJsonResult<>(false,e.getMessage());
        }

    }

    @RequestMapping(value = "/download", method = RequestMethod.POST)
    @ResponseBody
    public void downloadConfig(Integer id, HttpServletResponse response) {
        try {
            hardwareService.download(id,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
