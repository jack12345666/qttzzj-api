package com.vpn.website.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.vpn.website.client.dto.LandAddDTO;
import com.vpn.website.client.model.Land;
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
public interface LandService extends IService<Land> {
    Integer addLand(HttpServletRequest request, LandAddDTO landAddDTO);
    IPage<Land> selectLandList(Page<Land> page, @Param(Constants.WRAPPER) QueryWrapper<Land> wrapper);
    Integer updateLand(LandAddDTO landAddDTO);
    Land getByPrimaryKey(Integer id);
}
