package com.vpn.website.client.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author xiaotao
 * @since 2020-12-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_outlets")
@ApiModel(value="Outlets对象", description="")
public class Outlets implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "联系电话")
    private String tel;

    @ApiModelProperty(value = "经度")
    private BigDecimal lng;

    @ApiModelProperty(value = "纬度")
    private BigDecimal lat;

    @ApiModelProperty(value = "运行状态(0未运行，1运行)")
    @TableField("runStatus")
    private Integer runStatus;

    @ApiModelProperty(value = "0表示失效，1表示正常，10表示草稿")
    private Integer status;

    @ApiModelProperty(value = "分类(办事服务点，学校网点，区内医院，购物综合体)")
    private String category;

    @ApiModelProperty(value = "显示顺序")
    @TableField("displayNo")
    private Integer displayNo;

    @ApiModelProperty(value = "提交者Id")
    @TableField("userId")
    private Integer userId;

    @ApiModelProperty(value = "提交者姓名")
    @TableField("userName")
    private String userName;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("createTime")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("updateTime")
    private Date updateTime;


}
