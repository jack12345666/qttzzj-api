package com.vpn.website.client.model;

import com.baomidou.mybatisplus.annotation.*;
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
@TableName("t_land")
@ApiModel(value="新区网点", description="")
public class Land implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "序号")
    private String no;

    @ApiModelProperty(value = "所属板块id")
    @TableField("plateId")
    private Integer plateId;

    @ApiModelProperty(value = "所属板块名称")
    @TableField("plateName")
    private String plateName;

    @ApiModelProperty(value = "地块名称")
    private String name;

    @ApiModelProperty(value = "规划用途")
    @TableField("plannedUse")
    private String plannedUse;

    @ApiModelProperty(value = "控规容积率")
    @TableField("plotRatio")
    private BigDecimal plotRatio;

    @ApiModelProperty(value = "土地面积")
    @TableField("landArea")
    private BigDecimal landArea;

    @ApiModelProperty(value = "土地面积单位")
    @TableField("landAreaUnit")
    private String landAreaUnit;

    @ApiModelProperty(value = "建筑面积")
    @TableField("buildingArea")
    private BigDecimal buildingArea;

    @ApiModelProperty(value = "建筑面积单位")
    @TableField("buildingAreaUnit")
    private String buildingAreaUnit;

    @ApiModelProperty(value = "经度")
    private BigDecimal lng;

    @ApiModelProperty(value = "纬度")
    private BigDecimal lat;

    @ApiModelProperty(value = "提交者id")
    @TableField("userId")
    private Integer userId;

    @ApiModelProperty(value = "提交者姓名")
    @TableField("userName")
    private String userName;

    @ApiModelProperty(value = "出让状态(0未出让，1已出让)")
    @TableField("saleStatus")
    private Integer saleStatus;

    @ApiModelProperty(value = "0表示失效，1表示正常，10表示草稿")
    private Integer status;

    @ApiModelProperty(value = "显示顺序")
    @TableField("displayNo")
    private Integer displayNo;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("createTime")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("updateTime")
    private Date updateTime;


}
