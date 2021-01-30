package com.vpn.website.client.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.vpn.website.client.dto.TBuildingLeaseAddDTO;
import com.vpn.website.client.dto.TBuildingLeaseDTO;
import com.vpn.website.client.model.TBuildinglease;
import com.vpn.website.client.vo.UserLeaseVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface TBuildingleaseMapper extends BaseMapper<TBuildinglease> {
    int addBuilding(TBuildingLeaseAddDTO tBuildingLeaseAddDTO);
    IPage<UserLeaseVo> selectLeaseList(Page<TBuildingLeaseDTO> page, @Param(Constants.WRAPPER) QueryWrapper<TBuildingLeaseDTO> wrapper);
    int updateBuildingStatus(Integer status, Long id);
    IPage<TBuildingLeaseDTO> getLeaseList(Page<TBuildingLeaseDTO> page, @Param(Constants.WRAPPER) QueryWrapper<TBuildingLeaseDTO> wrapper);
}
