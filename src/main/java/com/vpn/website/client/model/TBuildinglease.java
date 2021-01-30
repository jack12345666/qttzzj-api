package com.vpn.website.client.model;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@ApiModel(value = "com-vpn-website-client-model-TBuildinglease")
@TableName(value = "t_buildinglease")
public class TBuildinglease implements Serializable {

  private static final Long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  @ApiModelProperty(value = "id")
  private Long id;

  @TableField(value = "no")
  @ApiModelProperty(value = "编号")
  private String no;

  @TableField(value = "areaId")
  @ApiModelProperty(value = "区域序号")
  private String areaId;

  @TableField(value = "areaName")
  @ApiModelProperty(value = "区域名称")
  private String areaName;

  @TableField(value = "title")
  @ApiModelProperty("标题")
  private String title;

  @TableField(value = "address")
  @ApiModelProperty(value = "地址")
  private String address;

  @TableField(value = "thumbnail")
  @ApiModelProperty(value = "缩略图-用于列表")
  private String thumbnail;

  @TableField(value = "mainPic")
  @ApiModelProperty(value = "主图，大图")
  private String mainPic;

  @TableField(value = "buildingNo")
  @ApiModelProperty(value = "楼幢")
  private String buildingNo;

  @TableField(value = "landUsage")
  @ApiModelProperty(value = "用地性质")
  private String landUsage;

  @TableField(value = "floorArea")
  @ApiModelProperty(value = "占地面积")
  private BigDecimal floorArea;

  @TableField(value = "floorAreaUnit")
  @ApiModelProperty(value = "占地面积单位")
  private String floorAreaUnit;

  @TableField(value = "buildingArea")
  @ApiModelProperty(value = "建筑面积")
  private BigDecimal buildingArea;

  @TableField(value = "buildingAreaUnit")
  @ApiModelProperty(value = "建筑面积单位")
  private String buildingAreaUnit;

  @TableField(value = "totalFloor")
  @ApiModelProperty(value = "总楼层")
  private String totalFloor;

  @TableField(value = "floorHeight")
  @ApiModelProperty(value = "层高")
  private String floorHeight;

  @TableField(value = "loadBearing")
  @ApiModelProperty(value = "承重")
  private String loadBearing;

  @TableField(value = "loadBearingUnit")
  @ApiModelProperty(value = "承重单位")
  private String loadBearingUnit;

  @TableField(value = "millConstruction")
  @ApiModelProperty(value = "厂房结构")
  private String millConstruction;

  @TableField(value = "buildingUsage")
  @ApiModelProperty(value = "设计用途")
  private String buildingUsage;

  @TableField(value = "isStandard")
  @ApiModelProperty(value = "是否标准厂房")
  private Long isStandard;

  @TableField(value = "existElevator")
  @ApiModelProperty(value = "是否有电梯")
  private Long existElevator;

  @TableField(value = "electricity")
  @ApiModelProperty(value = "用电")
  private String electricity;

  @TableField(value = "spareArea")
  @ApiModelProperty(value = "目前空余面积")
  private String spareArea;

  @TableField(value = "price")
  @ApiModelProperty(value = "价格")
  private BigDecimal price;

  @TableField(value = "priceUnit")
  @ApiModelProperty(value = "价格单位")
  private String priceUnit;

  @TableField(value = "priceLow")
  @ApiModelProperty(value = "价格区间低价")
  private BigDecimal priceLow;

  @TableField(value = "priceHigh")
  @ApiModelProperty(value = "价格区间高价")
  private BigDecimal priceHigh;

  @TableField(value = "bridgeCrane")
  @ApiModelProperty(value = "是否有行车")
  private Long bridgeCrane;

  @TableField(value = "bridgeCraneTon")
  @ApiModelProperty(value = "行车吨位")
  private String bridgeCraneTon;

  @TableField(value = "description")
  @ApiModelProperty(value = "租赁说明")
  private String description;

  @TableField(value = "contactName")
  @ApiModelProperty(value = "联系人姓名")
  private String contactName;

  @TableField(value = "contactTel")
  @ApiModelProperty(value = "联系人电话")
  private String contactTel;

  @TableField(value = "contactMobile")
  @ApiModelProperty(value = "联系人手机")
  private String contactMobile;

  @TableField(value = "createTime", fill = FieldFill.INSERT)
  @ApiModelProperty(value = "创建时间")
  private Date createTime;

  @TableField(value = "orgContactId")
  @ApiModelProperty(value = "提交者id-用户")
  private Long orgContactId;

  @TableField(value = "orgContactName")
  @ApiModelProperty(value = "提交者姓名-用户")
  private String orgContactName;

  @TableField(value = "orgContactTel")
  @ApiModelProperty(value = "提交者电话-用户")
  private String orgContactTel;

  @TableField(value = "orgContactMobile")
  @ApiModelProperty(value = "提交者手机-用户")
  private String orgContactMobile;

  @TableField(value = "employeeId")
  @ApiModelProperty(value = "提交者id-员工")
  private Long employeeId;

  @TableField(value = "employeeName")
  @ApiModelProperty(value = "提交者姓名-员工")
  private String employeeName;

  @TableField(value = "editTime")
  @ApiModelProperty(value = "编辑时间")
  private Date editTime;

  @TableField(value = "examTime")
  @ApiModelProperty(value = "审核时间")
  private Date examTime;

  @TableField(value = "examinantId")
  @ApiModelProperty(value = "审核人id")
  private Long examinantId;

  @TableField(value = "examinantName")
  @ApiModelProperty(value = "审核人姓名")
  private String examinantName;

  @TableField(value = "examResult")
  @ApiModelProperty(value = "审核结果")
  private String examResult;

  @TableField(value = "viewCount")
  @ApiModelProperty(value = "浏览量")
  private Long viewCount;

  @TableField(value = "displayNo")
  @ApiModelProperty(value = "显示顺序")
  private Long displayNo;

  @TableField(value = "isHot")
  @ApiModelProperty(value = "是否热门")
  private Long isHot;

  @TableField(value = "isNew")
  @ApiModelProperty(value = "是否新发布")
  private Long isNew;

  @TableField(value = "isTop")
  @ApiModelProperty(value = "是否置顶")
  private Long isTop;

  @TableField(value = "comment")
  @ApiModelProperty(value = "备注")
  private String comment;

  @TableField(value = "status")
  @ApiModelProperty(value = "状态")
  private Long status;


  public static final String COL_ID = "id";
  public static final String COL_NO = "no";
  public static final String COL_TITLE = "title";
  public static final String COL_AREAID = "areaId";
  public static final String COL_AREANAME = "areaName";
  public static final String COL_VIEWCOUNT= "viewCount";
  public static final String COL_CONTACTNAME = "contactName";
  public static final String COL_EMPLOYEEID= "employeeId";
  public static final String COL_EMPLOYEENAME= "employeeName";
  public static final String COL_BUILDINGAREA= "buildingArea";
  public static final String COL_PRICELOW= "priceLow";
  public static final String COL_PRICEHIGH= "priceHigh";
  public static final String COL_PRICE= "price";
  public static final String COL_ISHOT= "isHot";
  public static final String COL_ISNEW= "isNew";
  public static final String COL_ISTOP= "isTop";
  public static final String COL_STATUS= "status";



}
