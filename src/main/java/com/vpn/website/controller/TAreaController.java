package com.vpn.website.controller;

import com.vpn.website.client.dto.TAreaDTO;
import com.vpn.website.client.query.TAreaQuery;
import com.vpn.website.client.vo.TAreaVo;
import com.vpn.website.common.base.BaseResult;
import com.vpn.website.common.base.PageBean;
import com.vpn.website.service.TAreaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "区域")
@RequestMapping("/area")
@RestController
public class TAreaController {
    @Autowired
    TAreaService tAreaService;

    @ApiOperation(value = "获取区域列表", notes = "获取区域列表")
    @PostMapping("/listArea")
    public BaseResult list(TAreaQuery query) {
        try {
            PageBean<TAreaDTO> page = tAreaService.listPage(query);
            return BaseResult.initSuccessResult(page);
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResult.initFailResult("操作失败");
        }
    }

    @ApiOperation(value = "获取区域列表id-name", notes = "获取区域列表id-name")
    @PostMapping("/listAreaName")
    public List<TAreaVo> listName() {
            return tAreaService.getName();
    }
}
