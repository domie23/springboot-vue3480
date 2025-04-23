package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XianhuaChuruInoutListEntity;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 * 出入库详情 服务类
 */
public interface XianhuaChuruInoutListService extends IService<XianhuaChuruInoutListEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}