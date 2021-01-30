package com.vpn.website.client.query;

import com.vpn.website.client.model.TBuildinglease;

import com.vpn.website.common.annotation.MyQuery;
import com.vpn.website.common.base.BasePageQuery;
import com.vpn.website.common.base.BaseQuery;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TBuildingleaseQuery extends BasePageQuery {

    @ApiModelProperty(value = "编号")
    @MyQuery(value = BaseQuery.eq,column = TBuildinglease.COL_NO)
    private String no;

    @ApiModelProperty(value = "地区id")
    @MyQuery(value = BaseQuery.eq,column = TBuildinglease.COL_AREAID)
    private String areaId;

    @ApiModelProperty(value = "标题")
    @MyQuery(value = BaseQuery.like,column = TBuildinglease.COL_TITLE)
    private String title;

    @ApiModelProperty(value = "地区名称模糊查询")
    @MyQuery(value = BaseQuery.like,column = TBuildinglease.COL_AREANAME)
    private String areaName;

    @ApiModelProperty(value = "建筑面积用'-'隔开,例如(面积在100m²-300m²),(面积小于100m² -100m²)(面积大于1000m² 1000m²-)")
    @MyQuery(value = BaseQuery.between,column = TBuildinglease.COL_BUILDINGAREA)
    private String buildingAreaBetween;

    @ApiModelProperty(value = "价格范围用'-'隔开,例如(价格在2-10),(价格小于2 -2)(价格大于10 10-)")
    @MyQuery(value = BaseQuery.between,column = TBuildinglease.COL_PRICE)
    private String priceBetween;

    @ApiModelProperty(value = "提交者id-员工")
    @MyQuery(value = BaseQuery.eq,column = TBuildinglease.COL_EMPLOYEEID)
    private String employeeId;

    @ApiModelProperty(value = "提交者姓名-员工")
    @MyQuery(value = BaseQuery.like,column = TBuildinglease.COL_EMPLOYEENAME)
    private String employeeName;

    @ApiModelProperty(value = "联系人")
    @MyQuery(value = BaseQuery.like,column = TBuildinglease.COL_CONTACTNAME)
    private String contactName;

    @ApiModelProperty(value = "是否热门, 1表示热门,0表示不热门")
    @MyQuery(value = BaseQuery.eq,column = TBuildinglease.COL_ISHOT)
    private String isHot;

    @ApiModelProperty(value = "是否新发布, 1表示新发布,0表示不是新发布")
    @MyQuery(value = BaseQuery.eq,column = TBuildinglease.COL_ISNEW)
    private String isNew;

    @ApiModelProperty(value = "是否置顶, 1表示置顶,0表示不置顶")
    @MyQuery(value = BaseQuery.eq,column = TBuildinglease.COL_ISTOP)
    private String isTop;

    @ApiModelProperty(value = "状态 10草稿 1正常 0失效 ")
    @MyQuery(value = BaseQuery.eq,column = TBuildinglease.COL_STATUS)
    private String status;


}