package com.vpn.website.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.vpn.website.client.dto.LandAddDTO;
import com.vpn.website.client.model.Land;
import com.vpn.website.common.base.BaseResult;
import com.vpn.website.service.LandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xiaotao
 * @since 2020-12-10
 */
@Api(tags = "推介用地")
@RestController
@RequestMapping("/land")
public class LandController {

    @Autowired
    LandService landService;

    @ApiOperation(value = "添加推介用地信息", notes = "添加推介用地信息")
    @PostMapping("/addLand")
    public BaseResult addLand(HttpServletRequest request, @Validated LandAddDTO landAddDTO, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return BaseResult.initFailResult(bindingResult.getFieldError().getDefaultMessage());
        }
        HttpSession httpSession = request.getSession();
        if(null == httpSession.getAttribute("userId")) {
            return BaseResult.initFailResult("无权限");
        }
        try {
            landService.addLand(request, landAddDTO);
            return BaseResult.initSuccessResult("添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResult.initFailResult("操作失败");
        }
    }

    @ApiOperation(value = "获取推介详情", notes = "获取推介详情")
    @GetMapping("/detail/{id}")
    public BaseResult detail(@ApiParam(value = "id") @PathVariable(value = "id") Integer id) {
        if(null == id){
            return BaseResult.initFailResult("参数为空");
        }
        try {
            Land land = landService.getByPrimaryKey(id);
            return BaseResult.initSuccessResult(land);
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResult.initFailResult("操作失败");
        }
    }

    @ApiOperation(value = "推介用地列表(网站前端)", notes = "推介用地列表(网站前端)")
    @PostMapping("/landList")
    public BaseResult landList(@RequestParam(defaultValue = "1") Integer currentPage,
                               @RequestParam(defaultValue = "10") Integer pageSize) {
        try {
            Page<Land> page = new Page<>(currentPage, pageSize);
            QueryWrapper<Land> wrapper = new QueryWrapper<>();
            wrapper.eq("status", 1);
            wrapper.orderByDesc("displayNo");
            IPage<Land> list = landService.selectLandList(page, wrapper);
            Map<String, Object> map = new HashMap<>(10);
            map.put("items", list.getRecords());
            map.put("total", list.getTotal());
            map.put("pageSize", pageSize);
            map.put("currentPage", currentPage);
            map.put("pages", list.getPages());
            return BaseResult.initSuccessResult(map);
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResult.initFailResult("操作失败");
        }
    }

    @ApiOperation(value = "推介用地列表(员工)", notes = "推介用地列表(员工)")
    @PostMapping("/landListByEmployee")
    public BaseResult landListByEmployee(HttpServletRequest request,@RequestParam(defaultValue = "1") Integer currentPage,
                               @RequestParam(defaultValue = "10") Integer pageSize) {
        HttpSession httpSession = request.getSession();
        if(null == httpSession.getAttribute("userId")) {
            return BaseResult.initFailResult("无权限");
        }
        try {
            Page<Land> page = new Page<>(currentPage, pageSize);
            QueryWrapper<Land> wrapper = new QueryWrapper<>();
            wrapper.eq("userId",  httpSession.getAttribute("userId"));
            wrapper.orderByDesc("displayNo");
            IPage<Land> list = landService.selectLandList(page, wrapper);
            Map<String, Object> map = new HashMap<>(10);
            map.put("items", list.getRecords());
            map.put("total", list.getTotal());
            map.put("pageSize", pageSize);
            map.put("currentPage", currentPage);
            map.put("pages", list.getPages());
            return BaseResult.initSuccessResult(map);
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResult.initFailResult("操作失败");
        }
    }

    @ApiOperation(value = "推介用地列表(管理员)", notes = "推介用地列表(管理员)")
    @PostMapping("/landListAdmin")
    public BaseResult landListAdmin(HttpServletRequest request,@RequestParam(defaultValue = "1") Integer currentPage,
                                         @RequestParam(defaultValue = "10") Integer pageSize) {
        HttpSession httpSession = request.getSession();
        if(null == httpSession.getAttribute("userId")) {
            return BaseResult.initFailResult("无权限");
        }
        try {
            Page<Land> page = new Page<>(currentPage, pageSize);
            QueryWrapper<Land> wrapper = new QueryWrapper<>();
            IPage<Land> list = landService.selectLandList(page, wrapper);
            Map<String, Object> map = new HashMap<>(10);
            map.put("items", list.getRecords());
            map.put("total", list.getTotal());
            map.put("pageSize", pageSize);
            map.put("currentPage", currentPage);
            map.put("pages", list.getPages());
            return BaseResult.initSuccessResult(map);
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResult.initFailResult("操作失败");
        }
    }

    @ApiOperation(value = "修改推介用地信息", notes = "修改推介用地信息")
    @PostMapping("/updateLand")
    public BaseResult updateLand(HttpServletRequest request, @Validated LandAddDTO landAddDTO, BindingResult bindingResult) {
        HttpSession httpSession = request.getSession();
        if(null == httpSession.getAttribute("userId")) {
            return BaseResult.initFailResult("无权限");
        }
        if(null == landAddDTO.getId()) {
            return BaseResult.initFailResult("id不能为空");
        }
        if(bindingResult.hasErrors()){
            return BaseResult.initFailResult(bindingResult.getFieldError().getDefaultMessage());
        }
        try {
           Integer result = landService.updateLand(landAddDTO);
           if(1 == result) {
               return BaseResult.initSuccessResult("修改成功");
           }else {
               return BaseResult.initFailResult("操作失败");
           }
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResult.initFailResult("操作失败");
        }
    }
}

