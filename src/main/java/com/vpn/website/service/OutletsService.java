package com.vpn.website.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.vpn.website.client.dto.OutletsAddDTO;
import com.vpn.website.client.model.Outlets;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xiaotao
 * @since 2020-12-10
 */
public interface OutletsService extends IService<Outlets> {
    Integer addOutlets(HttpServletRequest request, OutletsAddDTO outletsAddDTO);
    IPage<Outlets> selectOutletsList(Page<Outlets> page, @Param(Constants.WRAPPER) QueryWrapper<Outlets> wrapper);
    Integer updateOutlets(OutletsAddDTO outletsAddDTO);
    Outlets getByPrimaryKey(Integer id);
}
