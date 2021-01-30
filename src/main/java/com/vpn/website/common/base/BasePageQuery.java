package com.vpn.website.common.base;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vpn.website.common.CommonValues;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Data;

/**
 * @author wang
 * @Date 2020/4/15 14:37
 * @Desc
 */
@Data
public abstract class BasePageQuery<T> extends BaseQuery<T> {
    // 当前页
    @ApiModelProperty(value="当前页码,非分页调用时，参数无效",dataType="int",required = true)
    public Integer currentPage = 1;
    // 每页显示的总条数
    @ApiModelProperty(value="每页条数,非分页调用时，参数无效",dataType="int",required = true)
    public Integer pageSize = CommonValues.DEFAULT_PAGE_SIZE;

    @ApiModelProperty(value="排序方式，并非所有接口都写实现",dataType="string")
    public String orderStr;

    @JsonIgnore
    @ApiParam(hidden = true)
    public Page buildPage(){
        if(currentPage==null){
            currentPage = 1;
        }
        if(pageSize==null){
            pageSize = CommonValues.DEFAULT_PAGE_SIZE;
        }
        return new Page<T>(this.currentPage,this.pageSize);
    }
}
