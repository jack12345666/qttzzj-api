package com.vpn.website.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.vpn.website.client.dto.OutletsAddDTO;
import com.vpn.website.client.model.Outlets;
import com.vpn.website.common.base.BaseResult;
import com.vpn.website.service.OutletsService;
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
 *
 * @author tao
 * @since 2020-12-10
 */
@Api(tags = "新区网点")
@RestController
@RequestMapping("/outlets")
public class OutletsController {

    @Autowired
    OutletsService outletsService;

    @ApiOperation(value = "添加新区网点信息", notes = "添加新区网点信息")
    @PostMapping("/addOutlets")
    public BaseResult addOutlets(HttpServletRequest request, @Validated OutletsAddDTO outletsAddDTO, BindingResult bindingResult) {
        HttpSession httpSession = request.getSession();
        if(null == httpSession.getAttribute("userId")) {
            return BaseResult.initFailResult("无权限");
        }
        if(bindingResult.hasErrors()){
            return BaseResult.initFailResult(bindingResult.getFieldError().getDefaultMessage());
        }
        try {
            outletsService.addOutlets(request, outletsAddDTO);
            return BaseResult.initSuccessResult("添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResult.initFailResult("操作失败");
        }
    }

    @ApiOperation(value = "获取新区网点详情", notes = "获取新区网点详情")
    @GetMapping("/detail/{id}")
    public BaseResult detail(@ApiParam(value = "id") @PathVariable(value = "id") Integer id) {
        if(null == id){
            return BaseResult.initFailResult("参数为空");
        }
        try {
            Outlets outlets = outletsService.getByPrimaryKey(id);
            return BaseResult.initSuccessResult(outlets);
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResult.initFailResult("操作失败");
        }
    }

    @ApiOperation(value = "新区网点列表(前端)", notes = "新区网点列表(前端)")
    @PostMapping("/outletsList")
    public BaseResult outletsList(@RequestParam(defaultValue = "1") Integer currentPage,
                                  @RequestParam(defaultValue = "10") Integer pageSize,
                                  String category) {
        if(null == category) {
            return BaseResult.initFailResult("分类不能为空");
        }
        try {
            Page<Outlets> page = new Page<>(currentPage, pageSize);
            QueryWrapper<Outlets> wrapper = new QueryWrapper<>();
            wrapper.eq("status", 1);
            wrapper.eq("category", category);
            wrapper.orderByDesc("displayNo");
            IPage<Outlets> list = outletsService.selectOutletsList(page, wrapper);
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

    @ApiOperation(value = "新区网点列表(管理员)", notes = "新区网点列表(管理员)")
    @PostMapping("/outletsListAdmin")
    public BaseResult outletsListAdmin(HttpServletRequest request, @RequestParam(defaultValue = "1") Integer currentPage,
                                       @RequestParam(defaultValue = "10") Integer pageSize,
                                       String category, String status, String name) {
        HttpSession httpSession = request.getSession();
        if(null == httpSession.getAttribute("userId")) {
            return BaseResult.initFailResult("无权限");
        }
        try {
            Page<Outlets> page = new Page<>(currentPage, pageSize);
            QueryWrapper<Outlets> wrapper = new QueryWrapper<>();
            if(null != category) {
                wrapper.eq("category", category);
            }
            if(null != status) {
                wrapper.eq("status", status);
            }
            if(null != name) {
                wrapper.like("name", name);
            }
            IPage<Outlets> list = outletsService.selectOutletsList(page, wrapper);
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

    @ApiOperation(value = "新区网点列表(员工)", notes = "新区网点列表(员工)")
    @PostMapping("/outletsListByEmployee")
    public BaseResult outletsListByEmployee(HttpServletRequest request, @RequestParam(defaultValue = "1") Integer currentPage,
                                       @RequestParam(defaultValue = "10") Integer pageSize,
                                       String category, String status, String name) {
        HttpSession httpSession = request.getSession();
        if(null == httpSession.getAttribute("userId")) {
            return BaseResult.initFailResult("无权限");
        }
        try {
            Page<Outlets> page = new Page<>(currentPage, pageSize);
            QueryWrapper<Outlets> wrapper = new QueryWrapper<>();
            if(null != category) {
                wrapper.eq("category", category);
            }
            if(null != status) {
                wrapper.eq("status", status);
            }
            if(null != name) {
                wrapper.like("name", name);
            }
            wrapper.eq("userId", httpSession.getAttribute("userId"));
            IPage<Outlets> list = outletsService.selectOutletsList(page, wrapper);
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

    @ApiOperation(value = "修改新区网点信息", notes = "修改新区网点信息")
    @PostMapping("/updateOutlets")
    public BaseResult updateOutlets(HttpServletRequest request, @Validated OutletsAddDTO outletsAddDTO, BindingResult bindingResult) {
        HttpSession httpSession = request.getSession();
        if(null == httpSession.getAttribute("userId")) {
            return BaseResult.initFailResult("无权限");
        }
        if(null == outletsAddDTO.getId()) {
            return BaseResult.initFailResult("id不能为空");
        }
        if(bindingResult.hasErrors()){
            return BaseResult.initFailResult(bindingResult.getFieldError().getDefaultMessage());
        }
        try {
            Integer result = outletsService.updateOutlets(outletsAddDTO);
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

