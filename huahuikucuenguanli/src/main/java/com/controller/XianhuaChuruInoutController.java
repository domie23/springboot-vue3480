
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 出入库
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/xianhuaChuruInout")
public class XianhuaChuruInoutController {
    private static final Logger logger = LoggerFactory.getLogger(XianhuaChuruInoutController.class);

    @Autowired
    private XianhuaChuruInoutService xianhuaChuruInoutService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private YonghuService yonghuService;

    // 列表详情的表级联service
    @Autowired
    private XianhuaChuruInoutListService xianhuaChuruInoutListService;
//    @Autowired
//    private YonghuService yonghuService;
    @Autowired
    private XianhuaService xianhuaService;
    @Autowired
    private FenkuguanliService fenkuguanliService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("分库管理员".equals(role))
            params.put("fenkuguanliId",request.getSession().getAttribute("userId"));
        else if("员工".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = xianhuaChuruInoutService.queryPage(params);

        //字典表数据转换
        List<XianhuaChuruInoutView> list =(List<XianhuaChuruInoutView>)page.getList();
        for(XianhuaChuruInoutView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        XianhuaChuruInoutEntity xianhuaChuruInout = xianhuaChuruInoutService.selectById(id);
        if(xianhuaChuruInout !=null){
            //entity转view
            XianhuaChuruInoutView view = new XianhuaChuruInoutView();
            BeanUtils.copyProperties( xianhuaChuruInout , view );//把实体数据重构到view中

                //级联表
                YonghuEntity yonghu = yonghuService.selectById(xianhuaChuruInout.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody XianhuaChuruInoutEntity xianhuaChuruInout, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xianhuaChuruInout:{}",this.getClass().getName(),xianhuaChuruInout.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("员工".equals(role))
            xianhuaChuruInout.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<XianhuaChuruInoutEntity> queryWrapper = new EntityWrapper<XianhuaChuruInoutEntity>()
            .eq("xianhua_churu_inout_uuid_number", xianhuaChuruInout.getXianhuaChuruInoutUuidNumber())
            .eq("yonghu_id", xianhuaChuruInout.getYonghuId())
            .eq("xianhua_churu_inout_name", xianhuaChuruInout.getXianhuaChuruInoutName())
            .eq("xianhua_churu_inout_types", xianhuaChuruInout.getXianhuaChuruInoutTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XianhuaChuruInoutEntity xianhuaChuruInoutEntity = xianhuaChuruInoutService.selectOne(queryWrapper);
        if(xianhuaChuruInoutEntity==null){
            xianhuaChuruInout.setInsertTime(new Date());
            xianhuaChuruInout.setCreateTime(new Date());
            xianhuaChuruInoutService.insert(xianhuaChuruInout);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XianhuaChuruInoutEntity xianhuaChuruInout, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,xianhuaChuruInout:{}",this.getClass().getName(),xianhuaChuruInout.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("员工".equals(role))
//            xianhuaChuruInout.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<XianhuaChuruInoutEntity> queryWrapper = new EntityWrapper<XianhuaChuruInoutEntity>()
            .notIn("id",xianhuaChuruInout.getId())
            .andNew()
            .eq("xianhua_churu_inout_uuid_number", xianhuaChuruInout.getXianhuaChuruInoutUuidNumber())
            .eq("yonghu_id", xianhuaChuruInout.getYonghuId())
            .eq("xianhua_churu_inout_name", xianhuaChuruInout.getXianhuaChuruInoutName())
            .eq("xianhua_churu_inout_types", xianhuaChuruInout.getXianhuaChuruInoutTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XianhuaChuruInoutEntity xianhuaChuruInoutEntity = xianhuaChuruInoutService.selectOne(queryWrapper);
        if(xianhuaChuruInoutEntity==null){
            xianhuaChuruInoutService.updateById(xianhuaChuruInout);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 出库
    */
    @RequestMapping("/outXianhuaChuruInoutList")
    public R outXianhuaChuruInoutList(@RequestBody  Map<String, Object> params,HttpServletRequest request){
        logger.debug("outXianhuaChuruInoutList方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        String role = String.valueOf(request.getSession().getAttribute("role"));

        //取出入库名称并判断是否存在
        String xianhuaChuruInoutName = String.valueOf(params.get("xianhuaChuruInoutName"));
        Wrapper<XianhuaChuruInoutEntity> queryWrapper = new EntityWrapper<XianhuaChuruInoutEntity>()
            .eq("xianhua_churu_inout_name", xianhuaChuruInoutName)
            ;
        XianhuaChuruInoutEntity xianhuaChuruInoutSelectOne = xianhuaChuruInoutService.selectOne(queryWrapper);
        if(xianhuaChuruInoutSelectOne != null)
            return R.error(511,"出入库名称已被使用");


    //取当前表的级联表并判断是否前台传入

        Map<String, Integer> map = (Map<String, Integer>) params.get("map");
        if(map == null || map.size() == 0)
            return R.error(511,"列表内容不能为空");


        Set<String> ids = map.keySet();

        List<XianhuaEntity> xianhuaList = xianhuaService.selectBatchIds(ids);
        if(xianhuaList == null || xianhuaList.size() == 0){
            return R.error(511,"查数据库查不到数据");
        }else{
            for(XianhuaEntity w:xianhuaList){
                Integer value = w.getXianhuaKucunNumber()-map.get(String.valueOf(w.getId()));
                if(value <0){
                    return R.error(511,"出库数量大于库存数量");
                }
                w.setXianhuaKucunNumber(value);
            }
        }

        //当前表
        XianhuaChuruInoutEntity xianhuaChuruInoutEntity = new XianhuaChuruInoutEntity<>();
            xianhuaChuruInoutEntity.setXianhuaChuruInoutUuidNumber(String.valueOf(new Date().getTime()));
            if("员工".equals(role))
                xianhuaChuruInoutEntity.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
            xianhuaChuruInoutEntity.setXianhuaChuruInoutName(xianhuaChuruInoutName);
            xianhuaChuruInoutEntity.setXianhuaChuruInoutTypes(1);
            xianhuaChuruInoutEntity.setXianhuaChuruInoutContent(String.valueOf(params.get("xianhuaChuruInoutContent")));
            xianhuaChuruInoutEntity.setInsertTime(new Date());
            xianhuaChuruInoutEntity.setCreateTime(new Date());

        boolean insertXianhuaChuruInout = xianhuaChuruInoutService.insert(xianhuaChuruInoutEntity);
        if(insertXianhuaChuruInout){
            //级联表
            ArrayList<XianhuaChuruInoutListEntity> xianhuaChuruInoutLists = new ArrayList<>();
            for(String id:ids){
                XianhuaChuruInoutListEntity xianhuaChuruInoutListEntity = new XianhuaChuruInoutListEntity();
                    xianhuaChuruInoutListEntity.setXianhuaChuruInoutId(xianhuaChuruInoutEntity.getId());
                    xianhuaChuruInoutListEntity.setXianhuaId(Integer.valueOf(id));
                    xianhuaChuruInoutListEntity.setXianhuaChuruInoutListNumber(map.get(id));
                    xianhuaChuruInoutListEntity.setInsertTime(new Date());
                    xianhuaChuruInoutListEntity.setCreateTime(new Date());
                xianhuaChuruInoutLists.add(xianhuaChuruInoutListEntity);
                xianhuaService.updateBatchById(xianhuaList);
            }
            xianhuaChuruInoutListService.insertBatch(xianhuaChuruInoutLists);
        }
        return R.ok();
    }

    /**
    *入库
    */
    @RequestMapping("/inXianhuaChuruInoutList")
    public R inXianhuaChuruInoutList(@RequestBody  Map<String, Object> params,HttpServletRequest request){
        logger.debug("inXianhuaChuruInoutList方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        //params:{"map":{"1":2,"2":3},"wuziOutinName":"订单1"}

        String role = String.valueOf(request.getSession().getAttribute("role"));

        //取当前表名称并判断
        String xianhuaChuruInoutName = String.valueOf(params.get("xianhuaChuruInoutName"));
        Wrapper<XianhuaChuruInoutEntity> queryWrapper = new EntityWrapper<XianhuaChuruInoutEntity>()
            .eq("xianhua_churu_inout_name", xianhuaChuruInoutName)
            ;
        XianhuaChuruInoutEntity xianhuaChuruInoutSelectOne = xianhuaChuruInoutService.selectOne(queryWrapper);
        if(xianhuaChuruInoutSelectOne != null)
            return R.error(511,"出入库名称已被使用");


        //取当前表的级联表并判断是否前台传入

        Map<String, Integer> map = (Map<String, Integer>) params.get("map");
        if(map == null || map.size() == 0)
            return R.error(511,"列表内容不能为空");

        Set<String> ids = map.keySet();

        List<XianhuaEntity> xianhuaList = xianhuaService.selectBatchIds(ids);
        if(xianhuaList == null || xianhuaList.size() == 0){
            return R.error(511,"查数据库查不到数据");
        }else{
            for(XianhuaEntity w:xianhuaList){
                w.setXianhuaKucunNumber(w.getXianhuaKucunNumber()+map.get(String.valueOf(w.getId())));
            }
        }

        //当前表
        XianhuaChuruInoutEntity xianhuaChuruInoutEntity = new XianhuaChuruInoutEntity<>();
            xianhuaChuruInoutEntity.setXianhuaChuruInoutUuidNumber(String.valueOf(new Date().getTime()));
            if("员工".equals(role))
                xianhuaChuruInoutEntity.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
            xianhuaChuruInoutEntity.setXianhuaChuruInoutName(xianhuaChuruInoutName);
            xianhuaChuruInoutEntity.setXianhuaChuruInoutTypes(2);
            xianhuaChuruInoutEntity.setXianhuaChuruInoutContent(String.valueOf(params.get("xianhuaChuruInoutContent")));
            xianhuaChuruInoutEntity.setInsertTime(new Date());
            xianhuaChuruInoutEntity.setCreateTime(new Date());


        boolean insertXianhuaChuruInout = xianhuaChuruInoutService.insert(xianhuaChuruInoutEntity);
        if(insertXianhuaChuruInout){
            //级联表
            ArrayList<XianhuaChuruInoutListEntity> xianhuaChuruInoutLists = new ArrayList<>();
            for(String id:ids){
                XianhuaChuruInoutListEntity xianhuaChuruInoutListEntity = new XianhuaChuruInoutListEntity();
                xianhuaChuruInoutListEntity.setXianhuaChuruInoutId(xianhuaChuruInoutEntity.getId());
                xianhuaChuruInoutListEntity.setXianhuaId(Integer.valueOf(id));
                xianhuaChuruInoutListEntity.setXianhuaChuruInoutListNumber(map.get(id));
                xianhuaChuruInoutListEntity.setInsertTime(new Date());
                xianhuaChuruInoutListEntity.setCreateTime(new Date());
                xianhuaChuruInoutLists.add(xianhuaChuruInoutListEntity);
                xianhuaService.updateBatchById(xianhuaList);
            }
            xianhuaChuruInoutListService.insertBatch(xianhuaChuruInoutLists);
        }

        return R.ok();
    }
    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        xianhuaChuruInoutService.deleteBatchIds(Arrays.asList(ids));
        xianhuaChuruInoutListService.delete(new EntityWrapper<XianhuaChuruInoutListEntity>().in("xianhua_churu_inout_id",ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<XianhuaChuruInoutEntity> xianhuaChuruInoutList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            XianhuaChuruInoutEntity xianhuaChuruInoutEntity = new XianhuaChuruInoutEntity();
//                            xianhuaChuruInoutEntity.setXianhuaChuruInoutUuidNumber(data.get(0));                    //出入库流水号 要改的
//                            xianhuaChuruInoutEntity.setYonghuId(Integer.valueOf(data.get(0)));   //负责人 要改的
//                            xianhuaChuruInoutEntity.setXianhuaChuruInoutName(data.get(0));                    //出入库名称 要改的
//                            xianhuaChuruInoutEntity.setXianhuaChuruInoutTypes(Integer.valueOf(data.get(0)));   //出入库类型 要改的
//                            xianhuaChuruInoutEntity.setXianhuaChuruInoutContent("");//详情和图片
//                            xianhuaChuruInoutEntity.setInsertTime(date);//时间
//                            xianhuaChuruInoutEntity.setCreateTime(date);//时间
                            xianhuaChuruInoutList.add(xianhuaChuruInoutEntity);


                            //把要查询是否重复的字段放入map中
                                //出入库流水号
                                if(seachFields.containsKey("xianhuaChuruInoutUuidNumber")){
                                    List<String> xianhuaChuruInoutUuidNumber = seachFields.get("xianhuaChuruInoutUuidNumber");
                                    xianhuaChuruInoutUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> xianhuaChuruInoutUuidNumber = new ArrayList<>();
                                    xianhuaChuruInoutUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("xianhuaChuruInoutUuidNumber",xianhuaChuruInoutUuidNumber);
                                }
                        }

                        //查询是否重复
                         //出入库流水号
                        List<XianhuaChuruInoutEntity> xianhuaChuruInoutEntities_xianhuaChuruInoutUuidNumber = xianhuaChuruInoutService.selectList(new EntityWrapper<XianhuaChuruInoutEntity>().in("xianhua_churu_inout_uuid_number", seachFields.get("xianhuaChuruInoutUuidNumber")));
                        if(xianhuaChuruInoutEntities_xianhuaChuruInoutUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(XianhuaChuruInoutEntity s:xianhuaChuruInoutEntities_xianhuaChuruInoutUuidNumber){
                                repeatFields.add(s.getXianhuaChuruInoutUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [出入库流水号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        xianhuaChuruInoutService.insertBatch(xianhuaChuruInoutList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
