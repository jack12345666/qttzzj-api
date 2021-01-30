package com.vpn.website.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.vpn.website.client.dto.TBuildingLeaseAddDTO;
import com.vpn.website.client.dto.TBuildingLeaseDTO;
import com.vpn.website.client.model.TBuildinglease;
import com.vpn.website.client.vo.UserLeaseVo;

import javax.servlet.http.HttpServletRequest;

public interface TBuildingleaseService extends IService<TBuildinglease> {

    Integer addBuilding(HttpServletRequest request, TBuildingLeaseAddDTO tBuildingLeaseAddDTO);
    TBuildingLeaseDTO getByPrimaryKey(int id);
    Integer updateInfoById(TBuildingLeaseAddDTO tBuildingLeaseAddDTO);
    IPage<UserLeaseVo> selectUserList(Page<TBuildingLeaseDTO> page, QueryWrapper<TBuildingLeaseDTO> wrapper);
    IPage<TBuildingLeaseDTO> getLeaseList(Page<TBuildingLeaseDTO> page, QueryWrapper<TBuildingLeaseDTO> wrapper);
}
