package com.entity.vo;

import com.entity.CangkuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 仓库信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("cangku")
public class CangkuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 仓库编号
     */

    @TableField(value = "cangku_name")
    private String cangkuName;


    /**
     * 仓库类型
     */

    @TableField(value = "cangku_types")
    private Integer cangkuTypes;


    /**
     * 仓库地址
     */

    @TableField(value = "cangku_address")
    private String cangkuAddress;


    /**
     * 最大库存
     */

    @TableField(value = "cangku_max_number")
    private Integer cangkuMaxNumber;


    /**
     * 最小库存
     */

    @TableField(value = "cangku_min_number")
    private Integer cangkuMinNumber;


    /**
     * 货物现有库存
     */

    @TableField(value = "cangku_kucun_number")
    private Integer cangkuKucunNumber;


    /**
     * 仓库详情
     */

    @TableField(value = "cangku_content")
    private String cangkuContent;


    /**
     * 创建时间 show1 show2 nameShow
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
	 * 设置：仓库编号
	 */
    public String getCangkuName() {
        return cangkuName;
    }


    /**
	 * 获取：仓库编号
	 */

    public void setCangkuName(String cangkuName) {
        this.cangkuName = cangkuName;
    }
    /**
	 * 设置：仓库类型
	 */
    public Integer getCangkuTypes() {
        return cangkuTypes;
    }


    /**
	 * 获取：仓库类型
	 */

    public void setCangkuTypes(Integer cangkuTypes) {
        this.cangkuTypes = cangkuTypes;
    }
    /**
	 * 设置：仓库地址
	 */
    public String getCangkuAddress() {
        return cangkuAddress;
    }


    /**
	 * 获取：仓库地址
	 */

    public void setCangkuAddress(String cangkuAddress) {
        this.cangkuAddress = cangkuAddress;
    }
    /**
	 * 设置：最大库存
	 */
    public Integer getCangkuMaxNumber() {
        return cangkuMaxNumber;
    }


    /**
	 * 获取：最大库存
	 */

    public void setCangkuMaxNumber(Integer cangkuMaxNumber) {
        this.cangkuMaxNumber = cangkuMaxNumber;
    }
    /**
	 * 设置：最小库存
	 */
    public Integer getCangkuMinNumber() {
        return cangkuMinNumber;
    }


    /**
	 * 获取：最小库存
	 */

    public void setCangkuMinNumber(Integer cangkuMinNumber) {
        this.cangkuMinNumber = cangkuMinNumber;
    }
    /**
	 * 设置：货物现有库存
	 */
    public Integer getCangkuKucunNumber() {
        return cangkuKucunNumber;
    }


    /**
	 * 获取：货物现有库存
	 */

    public void setCangkuKucunNumber(Integer cangkuKucunNumber) {
        this.cangkuKucunNumber = cangkuKucunNumber;
    }
    /**
	 * 设置：仓库详情
	 */
    public String getCangkuContent() {
        return cangkuContent;
    }


    /**
	 * 获取：仓库详情
	 */

    public void setCangkuContent(String cangkuContent) {
        this.cangkuContent = cangkuContent;
    }
    /**
	 * 设置：创建时间 show1 show2 nameShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show1 show2 nameShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
