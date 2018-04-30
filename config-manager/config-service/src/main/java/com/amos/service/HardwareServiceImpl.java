package com.amos.service;

import com.amos.dao.HardwareCategoryMapper;
import com.amos.dao.HardwareParamMapper;
import com.amos.dto.JSTree;
import com.amos.exception.ConfigException;
import com.amos.exception.DataDeleteFailException;
import com.amos.exception.DataInsertFailException;
import com.amos.exception.DataUpdateFailException;
import com.amos.pojo.HardwareCategory;
import com.amos.pojo.HardwareParam;
import com.amos.utils.FtpUtil;
import com.amos.utils.PDFUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.*;

/**
 * Created by ${chenlunwei} on 2018/4/11.
 */
@Service
public class HardwareServiceImpl implements HardwareService {
    @Autowired
    private HardwareCategoryMapper hardwareCategoryMapper;

    @Autowired
    private HardwareParamMapper hardwareParamMapper;

    @Value("${FTP.HOST}")
    private String FTP_HOST;

    @Value("${FTP.PORT}")
    private Integer FTP_PORT;

    @Value("${FTP.USERNAME}")
    private String FTP_USERNAME;

    @Value("${FTP.PASSWORD}")
    private String FTP_PASSWORD;

    @Value("${FTP.BASEPATH}")
    private String FTP_BASEPATH;

    @Override
    public List<JSTree> getJSTreeNodes() {
        return getContentCatTree(0);
    }

    @Override
    @Transactional
    public List<Integer> addHardwareCat(String[] parentId, String catName) throws DataInsertFailException, ConfigException {
        try {
            HardwareCategory hardwareCategory = new HardwareCategory();
            Date date = new Date();
            hardwareCategory.setUpdateTime(date);
            hardwareCategory.setCreateTime(date);
            hardwareCategory.setName(catName);
            hardwareCategory.setParent(false);
            boolean isNumber = StringUtils.isNumeric(parentId[0]);
            List<Integer> resultList = new ArrayList<>();
            if (isNumber) {
                hardwareCategory.setParentId(Integer.parseInt(parentId[0]));
                int insert = hardwareCategoryMapper.insertCategory(hardwareCategory);
                resultList.add(insert);
            } else {
                HardwareCategory parent = new HardwareCategory();
                parent.setParent(true);
                parent.setName(parentId[0]);
                parent.setCreateTime(date);
                parent.setUpdateTime(date);
                int insert1 = hardwareCategoryMapper.insertCategory(parent);
                hardwareCategory.setParentId(parent.getId());
                int insert2 = hardwareCategoryMapper.insertCategory(hardwareCategory);
                resultList.add(insert1);
                resultList.add(insert2);
            }
            if (resultList.contains(0)) {
                throw new DataInsertFailException("类目插入失败");
            } else {
                return resultList;
            }
        } catch (DataInsertFailException e1) {
            throw e1;
        } catch (Exception e2) {
            throw new ConfigException("系统内部错误" + e2.getMessage());
        }
    }

    @Override
    public int updateContentCat(String id, String catName) throws DataUpdateFailException, ConfigException {
        try {
            Date date = new Date();
            int catId = Integer.parseInt(id);
            HardwareCategory hardwareCategory = hardwareCategoryMapper.selectByPrimaryKey(catId);
            hardwareCategory.setName(catName);
            hardwareCategory.setUpdateTime(date);
            int result = hardwareCategoryMapper.updateByPrimaryKey(hardwareCategory);
            if (result == 0) {
                throw new DataUpdateFailException("类目更新失败");
            } else {
                return result;
            }
        } catch (DataUpdateFailException e1) {
            throw e1;
        } catch (Exception e2) {
            throw new ConfigException("系统内部错误" + e2.getMessage());
        }
    }

    @Override
    public Integer deleteContentCat(String id) throws DataDeleteFailException, ConfigException {
        try {
            int catId = Integer.parseInt(id);
            int result = hardwareCategoryMapper.deleteByPrimaryKey(catId);
            if (result == 0) {
                throw new DataDeleteFailException("类目删除失败");
            } else {
                return result;
            }
        } catch (DataDeleteFailException e1) {
            throw e1;
        } catch (Exception e2) {
            throw new ConfigException("系统内部错误" + e2.getMessage());
        }
    }

    @Override
    public List<HardwareParam> queryParamList(String cid, String search) {
        return hardwareParamMapper.queryList(Integer.parseInt(cid), search);
    }

    @Override
    @Transactional
    public List<Integer> addHardwareContent(MultipartFile[] files, HardwareParam hardware, Integer cid) throws DataInsertFailException, ConfigException {
        try {
            HardwareCategory hardwareCategory = hardwareCategoryMapper.selectByPrimaryKey(cid);
            Integer parentId = hardwareCategory.getParentId();
            List<Integer> resultList = new ArrayList<>();
            if (files != null && files.length > 0) {
                for (MultipartFile file : files) {
                    String catName = hardwareCategoryMapper.queryCatName(cid);
                    Date date = new Date();
                    HardwareParam hardwareParam = new HardwareParam();
                    hardwareParam.setLanguage(hardware.getLanguage());
                    hardwareParam.setCategoryId(cid);
                    hardwareParam.setCreateTime(date);
                    hardwareParam.setUpdateTime(date);
                    List<Double> dimension = null;
                    if (parentId == 1 || parentId == 2) {
                        dimension = PDFUtils.getDimension(file.getInputStream());
                    }
                    String name = file.getOriginalFilename();
                    FtpUtil.uploadFile(FTP_HOST, FTP_PORT, FTP_USERNAME, FTP_PASSWORD, FTP_BASEPATH, catName, name, file.getInputStream());
                    String filePath = FTP_BASEPATH + "/" + catName + "/" + name;
                    hardwareParam.setModel(name);
                    if (dimension != null && dimension.size() > 0) {
                        hardwareParam.setLength(dimension.get(0));
                        hardwareParam.setWidth(dimension.get(1));
                        hardwareParam.setHeight(dimension.get(2));
                    } else {
                        hardwareParam.setLength(0);
                        hardwareParam.setWidth(0);
                        hardwareParam.setHeight(0);
                    }
                    hardwareParam.setFilePath(filePath);
                    int result = hardwareParamMapper.insertParam(hardwareParam);
                    if (result == 0) {
                        throw new DataInsertFailException("数据插入失败");
                    } else {
                        resultList.add(result);
                    }
                }
            }
            return resultList;
        } catch (DataInsertFailException e1) {
            throw e1;
        } catch (Exception e) {
            throw new ConfigException("系统内部错误" + e.getMessage());
        }

    }

    @Override
    public Integer updateHardwareContent(MultipartHttpServletRequest request, HardwareParam hardwareParam) throws DataUpdateFailException, ConfigException {
        Map<String, MultipartFile> fileMap = request.getFileMap();
        Integer cid = hardwareParam.getCategoryId();
        HardwareCategory hardwareCategory = hardwareCategoryMapper.selectByPrimaryKey(cid);
        Integer parentId = hardwareCategory.getParentId();
        String catName = hardwareCategoryMapper.queryCatName(cid);
        Date date = new Date();
        try {
            hardwareParam.setUpdateTime(date);
            if (fileMap != null && fileMap.size() > 0) {
                for (Map.Entry<String, MultipartFile> entry : fileMap.entrySet()) {
                    MultipartFile file = entry.getValue();
                    List<Double> dimension = null;
                    if (parentId == 1 || parentId == 2) {
                        dimension = PDFUtils.getDimension(file.getInputStream());
                    }
                    String name = file.getOriginalFilename();
                    FtpUtil.uploadFile(FTP_HOST, FTP_PORT, FTP_USERNAME, FTP_PASSWORD, FTP_BASEPATH, catName, name, file.getInputStream());
                    String filePath = FTP_BASEPATH + "/" + catName + "/" + name;
                    hardwareParam.setModel(name);
                    if (dimension != null && dimension.size() > 0) {
                        hardwareParam.setLength(dimension.get(0));
                        hardwareParam.setWidth(dimension.get(1));
                        hardwareParam.setHeight(dimension.get(2));
                    } else {
                        hardwareParam.setLength(0);
                        hardwareParam.setWidth(0);
                        hardwareParam.setHeight(0);
                    }
                    hardwareParam.setFilePath(filePath);
                }
            }
            int result = hardwareParamMapper.updateByPrimaryKey(hardwareParam);
            if (result == 0) {
                throw new DataUpdateFailException("数据更新失败");
            } else {
                return result;
            }
        } catch (DataInsertFailException e1) {
            throw e1;
        } catch (Exception e) {
            throw new ConfigException("系统内部错误" + e.getMessage());
        }
    }

    @Override
    @Transactional
    public List deleteContent(String[] contentIdList, String cid) throws DataDeleteFailException, ConfigException {
        try {
            List<Integer> resultList = new ArrayList<>();
            for (String str : contentIdList) {
                int data = hardwareParamMapper.deleteByPrimaryKey(Integer.parseInt(str));
                if (data == 0) {
                    throw new DataDeleteFailException("数据删除失败!");
                } else {
                    resultList.add(data);
                }
            }
            if (resultList != null && resultList.size() > 0 && !resultList.contains(0)) {
                return resultList;
            } else {
                throw new DataDeleteFailException("数据删除失败!");
            }
        } catch (DataDeleteFailException e) {
            throw e;
        } catch (Exception e) {
            throw new ConfigException("系统内部错误:" + e.getMessage());
        }
    }

    @Override
    public void download(Integer id, HttpServletResponse response) {
        HardwareParam hardwareParam = hardwareParamMapper.selectByPrimaryKey(id);
        String filePath = hardwareParam.getFilePath();
        String remotePath = filePath.substring(0, filePath.lastIndexOf("/"));
        String fileName = filePath.substring(filePath.lastIndexOf("/") + 1);
        try {
            FtpUtil.downloadFile(FTP_HOST, FTP_PORT, FTP_USERNAME, FTP_PASSWORD, remotePath, fileName, response);
        } catch (ConfigException e) {
            throw e;
        } catch (Exception e) {
            throw new ConfigException("系统内部错误:" + e.getMessage());
        }
    }

    public List<JSTree> getContentCatTree(Integer id) {
        List<JSTree> list = new ArrayList<>();
        JSTree jsTree;
        List<HardwareCategory> hcs = hardwareCategoryMapper.queryByParentId(id);
        for (HardwareCategory hc : hcs) {
            if (hc.isParent()) {
                jsTree = new JSTree(hc.getId().toString(), hc.getName(),
                        "iconfont icon-wenjianjia-zhankai icon-fw", hc.isParent());
                jsTree.setChildren(getContentCatTree(hc.getId()));
            } else {
                jsTree = new JSTree(hc.getId().toString(), hc.getName(),
                        "iconfont icon-wenjian icon-fw", hc.isParent());
            }
            list.add(jsTree);
        }
        return list;
    }

}
