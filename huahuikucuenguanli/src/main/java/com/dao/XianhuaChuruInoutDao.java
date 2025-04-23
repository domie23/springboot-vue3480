package com.dao;

import com.entity.XianhuaChuruInoutEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.XianhuaChuruInoutView;

/**
 * 出入库 Dao 接口
 *
 * @author 
 */
public interface XianhuaChuruInoutDao extends BaseMapper<XianhuaChuruInoutEntity> {

   List<XianhuaChuruInoutView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
