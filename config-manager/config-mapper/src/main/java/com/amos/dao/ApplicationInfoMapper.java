package com.amos.dao;

import com.amos.pojo.ApplicationInfo;
import javafx.application.Application;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ApplicationInfoMapper {
    /**
     *  根据主键删除数据库的记录,application_info
     *
     * @param id
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *  新写入数据库记录,application_info
     *
     * @param record
     */
    int insert(ApplicationInfo record);

    /**
     *  动态字段,写入数据库记录,application_info
     *
     * @param record
     */
    int insertSelective(ApplicationInfo record);

    /**
     *  根据指定主键获取一条数据库记录,application_info
     *
     * @param id
     */
    ApplicationInfo selectByPrimaryKey(Integer id);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,application_info
     *
     * @param record
     */
    int updateByPrimaryKeySelective(ApplicationInfo record);

    /**
     *  根据主键来更新符合条件的数据库记录,application_info
     *
     * @param record
     */
    int updateByPrimaryKey(ApplicationInfo record);

    int insertBatchSelective(List<ApplicationInfo> records);

    int updateBatchByPrimaryKeySelective(List<ApplicationInfo> records);

	List<ApplicationInfo> selectList(@Param("search") String search,@Param("order") String order);
}