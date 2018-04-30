package com.amos.dao;

import com.amos.pojo.HardwareCategory;

import java.util.List;

/**
 * Created by ${chenlunwei} on 2018/4/11.
 */
public interface HardwareCategoryMapper {

    int insertCategory(HardwareCategory hardwareCategory);

    HardwareCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(HardwareCategory hardwareCategory);

    int deleteByPrimaryKey(Integer id);

    List<HardwareCategory> selectList();

    List<HardwareCategory> queryByParentId(Integer parentId);

    String queryCatName(Integer id);
}
