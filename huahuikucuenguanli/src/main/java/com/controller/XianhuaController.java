
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
 * 货物
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/xianhua")
public class XianhuaController {
    private static final Logger logger = LoggerFactory.getLogger(XianhuaController.class);

    @Autowired
    private XianhuaService xianhuaService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private CangkuService cangkuService;

    @Autowired
    private FenkuguanliService fenkuguanliService;
    @Autowired
    private YonghuService yonghuService;


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
        params.put("xianhuaDeleteStart",1);params.put("xianhuaDeleteEnd",1);
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = xianhuaService.queryPage(params);

        //字典表数据转换
        List<XianhuaView> list =(List<XianhuaView>)page.getList();
        for(XianhuaView c:list){
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
        XianhuaEntity xianhua = xianhuaService.selectById(id);
        if(xianhua !=null){
            //entity转view
            XianhuaView view = new XianhuaView();
            BeanUtils.copyProperties( xianhua , view );//把实体数据重构到view中

                //级联表
                CangkuEntity cangku = cangkuService.selectById(xianhua.getCangkuId());
                if(cangku != null){
                    BeanUtils.copyProperties( cangku , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setCangkuId(cangku.getId());
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
    public R save(@RequestBody XianhuaEntity xianhua, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xianhua:{}",this.getClass().getName(),xianhua.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<XianhuaEntity> queryWrapper = new EntityWrapper<XianhuaEntity>()
            .eq("xianhua_uuid_number", xianhua.getXianhuaUuidNumber())
            .eq("xianhua_name", xianhua.getXianhuaName())
            .eq("gongyingshang_name", xianhua.getGongyingshangName())
            .eq("gongyingshang_phone", xianhua.getGongyingshangPhone())
            .eq("cangku_id", xianhua.getCangkuId())
            .eq("xianhua_types", xianhua.getXianhuaTypes())
            .eq("xianhua_kucun_number", xianhua.getXianhuaKucunNumber())
            .eq("shangxia_types", xianhua.getShangxiaTypes())
            .eq("xianhua_delete", xianhua.getXianhuaDelete())
            .eq("xianhua_text", xianhua.getXianhuaText())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XianhuaEntity xianhuaEntity = xianhuaService.selectOne(queryWrapper);
        if(xianhuaEntity==null){
            xianhua.setShangxiaTypes(1);
            xianhua.setXianhuaDelete(1);
            xianhua.setCreateTime(new Date());
            xianhuaService.insert(xianhua);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XianhuaEntity xianhua, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,xianhua:{}",this.getClass().getName(),xianhua.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<XianhuaEntity> queryWrapper = new EntityWrapper<XianhuaEntity>()
            .notIn("id",xianhua.getId())
            .andNew()
            .eq("xianhua_uuid_number", xianhua.getXianhuaUuidNumber())
            .eq("xianhua_name", xianhua.getXianhuaName())
            .eq("gongyingshang_name", xianhua.getGongyingshangName())
            .eq("gongyingshang_phone", xianhua.getGongyingshangPhone())
            .eq("cangku_id", xianhua.getCangkuId())
            .eq("xianhua_types", xianhua.getXianhuaTypes())
            .eq("xianhua_kucun_number", xianhua.getXianhuaKucunNumber())
            .eq("shangxia_types", xianhua.getShangxiaTypes())
            .eq("xianhua_delete", xianhua.getXianhuaDelete())
            .eq("xianhua_text", xianhua.getXianhuaText())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XianhuaEntity xianhuaEntity = xianhuaService.selectOne(queryWrapper);
        if("".equals(xianhua.getXianhuaPhoto()) || "null".equals(xianhua.getXianhuaPhoto())){
                xianhua.setXianhuaPhoto(null);
        }
        if(xianhuaEntity==null){
            xianhuaService.updateById(xianhua);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        ArrayList<XianhuaEntity> list = new ArrayList<>();
        for(Integer id:ids){
            XianhuaEntity xianhuaEntity = new XianhuaEntity();
            xianhuaEntity.setId(id);
            xianhuaEntity.setXianhuaDelete(2);
            list.add(xianhuaEntity);
        }
        if(list != null && list.size() >0){
            xianhuaService.updateBatchById(list);
        }
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
            List<XianhuaEntity> xianhuaList = new ArrayList<>();//上传的东西
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
                            XianhuaEntity xianhuaEntity = new XianhuaEntity();
//                            xianhuaEntity.setXianhuaUuidNumber(data.get(0));                    //货物编号 要改的
//                            xianhuaEntity.setXianhuaName(data.get(0));                    //货物名称 要改的
//                            xianhuaEntity.setXianhuaPhoto("");//详情和图片
//                            xianhuaEntity.setGongyingshangName(data.get(0));                    //货物供应商 要改的
//                            xianhuaEntity.setGongyingshangPhone(data.get(0));                    //供应商联系方式 要改的
//                            xianhuaEntity.setCangkuId(Integer.valueOf(data.get(0)));   //仓库 要改的
//                            xianhuaEntity.setXianhuaTypes(Integer.valueOf(data.get(0)));   //货物类型 要改的
//                            xianhuaEntity.setXianhuaKucunNumber(Integer.valueOf(data.get(0)));   //货物库存 要改的
//                            xianhuaEntity.setXianhuaXiaoshouMoney(data.get(0));                    //现价 要改的
//                            xianhuaEntity.setShangxiaTypes(Integer.valueOf(data.get(0)));   //是否上架 要改的
//                            xianhuaEntity.setXianhuaDelete(1);//逻辑删除字段
//                            xianhuaEntity.setXianhuaText(data.get(0));                    //货物存放规则 要改的
//                            xianhuaEntity.setXianhuaContent("");//详情和图片
//                            xianhuaEntity.setCreateTime(date);//时间
                            xianhuaList.add(xianhuaEntity);


                            //把要查询是否重复的字段放入map中
                                //货物编号
                                if(seachFields.containsKey("xianhuaUuidNumber")){
                                    List<String> xianhuaUuidNumber = seachFields.get("xianhuaUuidNumber");
                                    xianhuaUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> xianhuaUuidNumber = new ArrayList<>();
                                    xianhuaUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("xianhuaUuidNumber",xianhuaUuidNumber);
                                }
                        }

                        //查询是否重复
                         //货物编号
                        List<XianhuaEntity> xianhuaEntities_xianhuaUuidNumber = xianhuaService.selectList(new EntityWrapper<XianhuaEntity>().in("xianhua_uuid_number", seachFields.get("xianhuaUuidNumber")).eq("xianhua_delete", 1));
                        if(xianhuaEntities_xianhuaUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(XianhuaEntity s:xianhuaEntities_xianhuaUuidNumber){
                                repeatFields.add(s.getXianhuaUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [货物编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        xianhuaService.insertBatch(xianhuaList);
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
