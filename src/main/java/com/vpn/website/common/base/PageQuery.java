package com.vpn.website.common.base;

import com.vpn.website.common.CommonValues;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author bitwang
 * @Date 2020/4/15 14:37
 * @Desc
 */
public class PageQuery {
    // 当前页
    @ApiModelProperty(value="当前页码",dataType="int",required = true)
    public Integer currentPage = 1;
    // 每页显示的总条数
    @ApiModelProperty(value="每页条数",dataType="int",required = true)
    public Integer pageSize = CommonValues.DEFAULT_PAGE_SIZE;

    @ApiModelProperty(value="排序方式，并非所有接口都写实现",dataType="string")
    public String orderStr;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrderStr() {
        return orderStr;
    }

    public void setOrderStr(String orderStr) {
        this.orderStr = orderStr;
    }
}
