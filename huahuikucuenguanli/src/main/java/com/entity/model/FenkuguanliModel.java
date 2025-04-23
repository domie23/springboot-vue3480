package com.entity.model;

import com.entity.FenkuguanliEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 分库管理员
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class FenkuguanliModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 员工姓名
     */
    private String fenkuguanliName;


    /**
     * 头像
     */
    private String fenkuguanliPhoto;


    /**
     * 手机号
     */
    private String fenkuguanliPhone;


    /**
     * 电子邮箱
     */
    private String fenkuguanliEmail;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 设置：账户
	 */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 设置：密码
	 */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：员工姓名
	 */
    public String getFenkuguanliName() {
        return fenkuguanliName;
    }


    /**
	 * 设置：员工姓名
	 */
    public void setFenkuguanliName(String fenkuguanliName) {
        this.fenkuguanliName = fenkuguanliName;
    }
    /**
	 * 获取：头像
	 */
    public String getFenkuguanliPhoto() {
        return fenkuguanliPhoto;
    }


    /**
	 * 设置：头像
	 */
    public void setFenkuguanliPhoto(String fenkuguanliPhoto) {
        this.fenkuguanliPhoto = fenkuguanliPhoto;
    }
    /**
	 * 获取：手机号
	 */
    public String getFenkuguanliPhone() {
        return fenkuguanliPhone;
    }


    /**
	 * 设置：手机号
	 */
    public void setFenkuguanliPhone(String fenkuguanliPhone) {
        this.fenkuguanliPhone = fenkuguanliPhone;
    }
    /**
	 * 获取：电子邮箱
	 */
    public String getFenkuguanliEmail() {
        return fenkuguanliEmail;
    }


    /**
	 * 设置：电子邮箱
	 */
    public void setFenkuguanliEmail(String fenkuguanliEmail) {
        this.fenkuguanliEmail = fenkuguanliEmail;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
