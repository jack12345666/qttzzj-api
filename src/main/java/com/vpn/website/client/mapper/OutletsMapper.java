package com.vpn.website.client.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.vpn.website.client.model.Outlets;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author tao
 * @since 2020-12-10
 */
@Mapper
public interface OutletsMapper extends BaseMapper<Outlets> {
    IPage<Outlets> selectOutletsList(Page<Outlets> page, @Param(Constants.WRAPPER) QueryWrapper<Outlets> wrapper);
}
