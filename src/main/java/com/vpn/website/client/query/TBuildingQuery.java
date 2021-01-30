package com.vpn.website.client.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TBuildingQuery {

    @ApiModelProperty(value = "地区id")
    private String areaId;

    @ApiModelProperty(value = "建筑面积用'-'隔开,例如(面积在100m²-300m²),(面积小于100m² -100m²)(面积大于1000m² 1000m²-)")
    private String buildingAreaBetween;

    @ApiModelProperty(value = "价格范围用'-'隔开,例如(价格在2-10),(价格小于2 -2)(价格大于10 10-)")
    private String priceBetween;

    @ApiModelProperty(value = "按创建时间排序(desc, asc)")
    private String createTime;

    @ApiModelProperty(value = "按单价排序(desc, asc)")
    private String price;

}