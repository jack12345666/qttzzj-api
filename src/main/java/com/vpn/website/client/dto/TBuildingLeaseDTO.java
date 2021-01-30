package com.vpn.website.client.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vpn.website.client.model.TBuildingleaseattachment;
import com.vpn.website.client.model.TBuildingleasestreet;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class TBuildingLeaseDTO {

    @ApiModelProperty(value = "id, 修改时必填")
    private Long id;

    @ApiModelProperty(value = "编号")
    private String no;

    @ApiModelProperty(value = "所属街道")
    private List<TBuildingleasestreet> streetList;

    @NotNull(message = "标题不能为空")
    @ApiModelProperty(value = "标题", required = true)
    private String title;

    @NotNull(message = "地址不能为空")
    @ApiModelProperty(value = "地址", required = true)
    private String address;

    @ApiModelProperty(value = "缩略图-用于列表")
    private String thumbnail;

    @NotNull(message = "主图不能为空")
    @ApiModelProperty(value = "主图，大图", required = true)
    private String mainPic;

    @ApiModelProperty(value = "楼幢")
    private String buildingNo;

    @ApiModelProperty(value = "用地性质")
    private String landUsage;

    @NotNull(message = "占地面积不能为空")
    @ApiModelProperty(value = "占地面积", required = true)
    private BigDecimal floorArea;

    @ApiModelProperty(value = "占地面积单位")
    private String floorAreaUnit;

    @ApiModelProperty(value = "建筑面积")
    private BigDecimal buildingArea;

    @ApiModelProperty(value = "建筑面积单位")
    private String buildingAreaUnit;

    @ApiModelProperty(value = "总楼层")
    private String totalFloor;

    @ApiModelProperty(value = "层高")
    private String floorHeight;

    @ApiModelProperty(value = "承重")
    private String loadBearing;

    @ApiModelProperty(value = "承重单位")
    private String loadBearingUnit;

    @ApiModelProperty(value = "厂房结构")
    private String millConstruction;

    @ApiModelProperty(value = "设计用途")
    private String buildingUsage;

    @ApiModelProperty(value = "是否标准厂房")
    private Long isStandard;

    @ApiModelProperty(value = "是否有电梯")
    private Long existElevator;

    @ApiModelProperty(value = "用电")
    private String electricity;

    @ApiModelProperty(value = "目前空余面积")
    private String spareArea;

    @ApiModelProperty(value = "价格", required = true)
    private BigDecimal price;

    @ApiModelProperty(value = "价格单位")
    private String priceUnit;

    @ApiModelProperty(value = "价格区间低价", required = true)
    private BigDecimal priceLow;


    @ApiModelProperty(value = "价格区间高价", required = true)
    private BigDecimal priceHigh;

    @ApiModelProperty(value = "是否有行车")
    private Long bridgeCrane;

    @ApiModelProperty(value = "行车吨位")
    private String bridgeCraneTon;

    @ApiModelProperty(value = "租赁说明")
    private String description;

    @ApiModelProperty(value = "联系人姓名")
    private String contactName;

    @ApiModelProperty(value = "联系人电话")
    private String contactTel;

    @ApiModelProperty(value = "联系人手机")
    private String contactMobile;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "联系人id-用户")
    private Long orgContactId;

    @ApiModelProperty(value = "联系人姓名-用户")
    private String orgContactName;

    @ApiModelProperty(value = "联系人电话-用户")
    private String orgContactTel;

    @ApiModelProperty(value = "联系人手机-用户")
    private String orgContactMobile;

    @ApiModelProperty(value = "提交者id-员工")
    private Long employeeId;

    @ApiModelProperty(value = "提交者姓名-员工")
    private String employeeName;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "编辑时间")
    private Date editTime;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "审核时间")
    private Date examTime;

    @ApiModelProperty(value = "审核人id")
    private Long examinantId;

    @ApiModelProperty(value = "审核人姓名")
    private String examinantName;

    @ApiModelProperty(value = "审核结果")
    private String examResult;

    @ApiModelProperty(value = "浏览量")
    private Long viewCount;

    @ApiModelProperty(value = "显示顺序")
    private Long displayNo;

    @ApiModelProperty(value = "是否热门")
    private Long isHot;

    @ApiModelProperty(value = "是否新发布")
    private Long isNew;

    @ApiModelProperty(value = "是否置顶")
    private Long isTop;

    @ApiModelProperty(value = "备注")
    private String comment;

    @ApiModelProperty(value = "状态")
    private Long status;

    @ApiModelProperty(value = "附件")
    private List<TBuildingleaseattachment> attachmentList;

}