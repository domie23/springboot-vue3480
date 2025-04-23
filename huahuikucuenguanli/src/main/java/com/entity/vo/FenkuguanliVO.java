package com.entity.vo;

import com.entity.FenkuguanliEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 分库管理员
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("fenkuguanli")
public class FenkuguanliVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 账户
     */

    @TableField(value = "username")
    private String username;


    /**
     * 密码
     */

    @TableField(value = "password")
    private String password;


    /**
     * 员工姓名
     */

    @TableField(value = "fenkuguanli_name")
    private String fenkuguanliName;


    /**
     * 头像
     */

    @TableField(value = "fenkuguanli_photo")
    private String fenkuguanliPhoto;


    /**
     * 手机号
     */

    @TableField(value = "fenkuguanli_phone")
    private String fenkuguanliPhone;


    /**
     * 电子邮箱
     */

    @TableField(value = "fenkuguanli_email")
    private String fenkuguanliEmail;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：员工姓名
	 */
    public String getFenkuguanliName() {
        return fenkuguanliName;
    }


    /**
	 * 获取：员工姓名
	 */

    public void setFenkuguanliName(String fenkuguanliName) {
        this.fenkuguanliName = fenkuguanliName;
    }
    /**
	 * 设置：头像
	 */
    public String getFenkuguanliPhoto() {
        return fenkuguanliPhoto;
    }


    /**
	 * 获取：头像
	 */

    public void setFenkuguanliPhoto(String fenkuguanliPhoto) {
        this.fenkuguanliPhoto = fenkuguanliPhoto;
    }
    /**
	 * 设置：手机号
	 */
    public String getFenkuguanliPhone() {
        return fenkuguanliPhone;
    }


    /**
	 * 获取：手机号
	 */

    public void setFenkuguanliPhone(String fenkuguanliPhone) {
        this.fenkuguanliPhone = fenkuguanliPhone;
    }
    /**
	 * 设置：电子邮箱
	 */
    public String getFenkuguanliEmail() {
        return fenkuguanliEmail;
    }


    /**
	 * 获取：电子邮箱
	 */

    public void setFenkuguanliEmail(String fenkuguanliEmail) {
        this.fenkuguanliEmail = fenkuguanliEmail;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
