package com.vpn.website.client.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.vpn.website.client.model.Land;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xiaotao
 * @since 2020-12-10
 */
@Mapper
public interface LandMapper extends BaseMapper<Land> {
    IPage<Land> selectLandList(Page<Land> page, @Param(Constants.WRAPPER) QueryWrapper<Land> wrapper);
}
