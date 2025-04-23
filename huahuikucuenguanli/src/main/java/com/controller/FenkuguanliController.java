
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
 * 分库管理员
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/fenkuguanli")
public class FenkuguanliController {
    private static final Logger logger = LoggerFactory.getLogger(FenkuguanliController.class);

    @Autowired
    private FenkuguanliService fenkuguanliService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

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
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = fenkuguanliService.queryPage(params);

        //字典表数据转换
        List<FenkuguanliView> list =(List<FenkuguanliView>)page.getList();
        for(FenkuguanliView c:list){
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
        FenkuguanliEntity fenkuguanli = fenkuguanliService.selectById(id);
        if(fenkuguanli !=null){
            //entity转view
            FenkuguanliView view = new FenkuguanliView();
            BeanUtils.copyProperties( fenkuguanli , view );//把实体数据重构到view中

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
    public R save(@RequestBody FenkuguanliEntity fenkuguanli, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,fenkuguanli:{}",this.getClass().getName(),fenkuguanli.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<FenkuguanliEntity> queryWrapper = new EntityWrapper<FenkuguanliEntity>()
            .eq("username", fenkuguanli.getUsername())
            .or()
            .eq("fenkuguanli_phone", fenkuguanli.getFenkuguanliPhone())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FenkuguanliEntity fenkuguanliEntity = fenkuguanliService.selectOne(queryWrapper);
        if(fenkuguanliEntity==null){
            fenkuguanli.setCreateTime(new Date());
            fenkuguanli.setPassword("123456");
            fenkuguanliService.insert(fenkuguanli);
            return R.ok();
        }else {
            return R.error(511,"账户或者手机号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody FenkuguanliEntity fenkuguanli, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,fenkuguanli:{}",this.getClass().getName(),fenkuguanli.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<FenkuguanliEntity> queryWrapper = new EntityWrapper<FenkuguanliEntity>()
            .notIn("id",fenkuguanli.getId())
            .andNew()
            .eq("username", fenkuguanli.getUsername())
            .or()
            .eq("fenkuguanli_phone", fenkuguanli.getFenkuguanliPhone())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FenkuguanliEntity fenkuguanliEntity = fenkuguanliService.selectOne(queryWrapper);
        if("".equals(fenkuguanli.getFenkuguanliPhoto()) || "null".equals(fenkuguanli.getFenkuguanliPhoto())){
                fenkuguanli.setFenkuguanliPhoto(null);
        }
        if(fenkuguanliEntity==null){
            fenkuguanliService.updateById(fenkuguanli);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"账户或者手机号已经被使用");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        fenkuguanliService.deleteBatchIds(Arrays.asList(ids));
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
            List<FenkuguanliEntity> fenkuguanliList = new ArrayList<>();//上传的东西
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
                            FenkuguanliEntity fenkuguanliEntity = new FenkuguanliEntity();
//                            fenkuguanliEntity.setUsername(data.get(0));                    //账户 要改的
//                            //fenkuguanliEntity.setPassword("123456");//密码
//                            fenkuguanliEntity.setFenkuguanliName(data.get(0));                    //员工姓名 要改的
//                            fenkuguanliEntity.setFenkuguanliPhoto("");//详情和图片
//                            fenkuguanliEntity.setFenkuguanliPhone(data.get(0));                    //手机号 要改的
//                            fenkuguanliEntity.setFenkuguanliEmail(data.get(0));                    //电子邮箱 要改的
//                            fenkuguanliEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            fenkuguanliEntity.setCreateTime(date);//时间
                            fenkuguanliList.add(fenkuguanliEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //手机号
                                if(seachFields.containsKey("fenkuguanliPhone")){
                                    List<String> fenkuguanliPhone = seachFields.get("fenkuguanliPhone");
                                    fenkuguanliPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> fenkuguanliPhone = new ArrayList<>();
                                    fenkuguanliPhone.add(data.get(0));//要改的
                                    seachFields.put("fenkuguanliPhone",fenkuguanliPhone);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<FenkuguanliEntity> fenkuguanliEntities_username = fenkuguanliService.selectList(new EntityWrapper<FenkuguanliEntity>().in("username", seachFields.get("username")));
                        if(fenkuguanliEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(FenkuguanliEntity s:fenkuguanliEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //手机号
                        List<FenkuguanliEntity> fenkuguanliEntities_fenkuguanliPhone = fenkuguanliService.selectList(new EntityWrapper<FenkuguanliEntity>().in("fenkuguanli_phone", seachFields.get("fenkuguanliPhone")));
                        if(fenkuguanliEntities_fenkuguanliPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(FenkuguanliEntity s:fenkuguanliEntities_fenkuguanliPhone){
                                repeatFields.add(s.getFenkuguanliPhone());
                            }
                            return R.error(511,"数据库的该表中的 [手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        fenkuguanliService.insertBatch(fenkuguanliList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }


    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        FenkuguanliEntity fenkuguanli = fenkuguanliService.selectOne(new EntityWrapper<FenkuguanliEntity>().eq("username", username));
        if(fenkuguanli==null || !fenkuguanli.getPassword().equals(password))
            return R.error("账号或密码不正确");
        //  // 获取监听器中的字典表
        // ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        // Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        // Map<Integer, String> role_types = dictionaryMap.get("role_types");
        // role_types.get(.getRoleTypes());
        String token = tokenService.generateToken(fenkuguanli.getId(),username, "fenkuguanli", "分库管理员");
        R r = R.ok();
        r.put("token", token);
        r.put("role","分库管理员");
        r.put("username",fenkuguanli.getFenkuguanliName());
        r.put("tableName","fenkuguanli");
        r.put("userId",fenkuguanli.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody FenkuguanliEntity fenkuguanli){
//    	ValidatorUtils.validateEntity(user);
        Wrapper<FenkuguanliEntity> queryWrapper = new EntityWrapper<FenkuguanliEntity>()
            .eq("username", fenkuguanli.getUsername())
            .or()
            .eq("fenkuguanli_phone", fenkuguanli.getFenkuguanliPhone())
            ;
        FenkuguanliEntity fenkuguanliEntity = fenkuguanliService.selectOne(queryWrapper);
        if(fenkuguanliEntity != null)
            return R.error("账户或者手机号已经被使用");
        fenkuguanli.setCreateTime(new Date());
        fenkuguanliService.insert(fenkuguanli);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        FenkuguanliEntity fenkuguanli = new FenkuguanliEntity();
        fenkuguanli.setPassword("123456");
        fenkuguanli.setId(id);
        fenkuguanliService.updateById(fenkuguanli);
        return R.ok();
    }


    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        FenkuguanliEntity fenkuguanli = fenkuguanliService.selectOne(new EntityWrapper<FenkuguanliEntity>().eq("username", username));
        if(fenkuguanli!=null){
            fenkuguanli.setPassword("123456");
            boolean b = fenkuguanliService.updateById(fenkuguanli);
            if(!b){
               return R.error();
            }
        }else{
           return R.error("账号不存在");
        }
        return R.ok();
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrFenkuguanli(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        FenkuguanliEntity fenkuguanli = fenkuguanliService.selectById(id);
        if(fenkuguanli !=null){
            //entity转view
            FenkuguanliView view = new FenkuguanliView();
            BeanUtils.copyProperties( fenkuguanli , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }





}
