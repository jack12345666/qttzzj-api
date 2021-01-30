package com.vpn.website.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.vpn.website.client.dto.TBuildingLeaseAddDTO;
import com.vpn.website.client.dto.TBuildingLeaseDTO;
import com.vpn.website.client.query.TBuildingQuery;
import com.vpn.website.client.vo.UserLeaseVo;
import com.vpn.website.common.base.BaseResult;
import com.vpn.website.service.TBuildingleaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 */
@Api(tags = "厂房")
@RequestMapping("/building")
@RestController
public class TBuildingleaseController {

    private TBuildingleaseService tBuildingleaseService;

    public TBuildingleaseController(TBuildingleaseService tBuildingleaseService) {
        this.tBuildingleaseService = tBuildingleaseService;
    }

    @ApiOperation(value = "用户获取厂房列表", notes = "用户获取厂房列表")
    @PostMapping("/listByUser")
    public BaseResult leaseUserList(@RequestParam(defaultValue = "1") Integer currentPage,
                                    @RequestParam(defaultValue = "10") Integer pageSize,
                                    TBuildingQuery query) {
        try {
            Page<TBuildingLeaseDTO> page = new Page<>(currentPage, pageSize);
            QueryWrapper<TBuildingLeaseDTO> wrapper = getWrapper(query);
            IPage<UserLeaseVo> list = tBuildingleaseService.selectUserList(page, wrapper);
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

    @ApiOperation(value = "获取厂房列表(管理员)", notes = "获取厂房列表(管理员)")
    @PostMapping("/leaseList")
    public BaseResult getLeaseList(HttpServletRequest request, @RequestParam(defaultValue = "1") Integer currentPage,
                                    @RequestParam(defaultValue = "10") Integer pageSize,
                                   String title, Integer status) {
        HttpSession httpSession = request.getSession();
        if(null == httpSession.getAttribute("userId")) {
            return BaseResult.initFailResult("无权限");
        }
        try {
            Page<TBuildingLeaseDTO> page = new Page<>(currentPage, pageSize);
            QueryWrapper<TBuildingLeaseDTO> queryWrapper = new QueryWrapper<>();
            if(!StringUtils.isEmpty(title)) {
                queryWrapper.like("title", title);
            }
            if(!StringUtils.isEmpty(status)) {
                queryWrapper.eq("status", status);
            }
            IPage<TBuildingLeaseDTO> list = tBuildingleaseService.getLeaseList(page, queryWrapper);
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


    @ApiOperation(value = "员工获取厂房列表", notes = "员工获取厂房列表")
    @PostMapping("/leaseListByEmployee")
    public BaseResult getLeaseListByEmployee(HttpServletRequest request, @RequestParam(defaultValue = "1") Integer currentPage,
                                             @RequestParam(defaultValue = "10") Integer pageSize,
                                             String title, Integer status) {
        HttpSession httpSession = request.getSession();
        if(null == httpSession.getAttribute("userId")) {
            return BaseResult.initFailResult("无权限");
        }
        try {
            Page<TBuildingLeaseDTO> page = new Page<>(currentPage, pageSize);
            QueryWrapper<TBuildingLeaseDTO> queryWrapper = new QueryWrapper<>();
            if(!StringUtils.isEmpty(title)) {
                queryWrapper.like("title", title);
            }
            if(!StringUtils.isEmpty(status)) {
                queryWrapper.eq("status", status);
            }
            queryWrapper.eq("employeeId", httpSession.getAttribute("userId"));
            IPage<TBuildingLeaseDTO> list = tBuildingleaseService.getLeaseList(page, queryWrapper);
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

    @ApiOperation(value = "添加厂房信息", notes = "添加厂房信息")
    @PostMapping("/addBuilding")
    public BaseResult addBuilding(HttpServletRequest request, @Validated TBuildingLeaseAddDTO tBuildingLeaseAddDTO, BindingResult bindingResult) {
        HttpSession httpSession = request.getSession();
        if(null == httpSession.getAttribute("userId")) {
            return BaseResult.initFailResult("无权限");
        }
        if(bindingResult.hasErrors()){
           return BaseResult.initFailResult(bindingResult.getFieldError().getDefaultMessage());
        }
        try {
            tBuildingleaseService.addBuilding(request, tBuildingLeaseAddDTO);
            return BaseResult.initSuccessResult("添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResult.initFailResult("操作失败");
        }
    }

    @ApiOperation(value = "获取厂房详情", notes = "获取厂房详情")
    @GetMapping("/detail/{id}")
    public BaseResult detail(@ApiParam(value = "id") @PathVariable(value = "id") Integer id) {
         if(null == id){
             return BaseResult.initFailResult("参数为空");
         }
        try {
            TBuildingLeaseDTO tBuildingLeaseDTO = tBuildingleaseService.getByPrimaryKey(id);
            return BaseResult.initSuccessResult(tBuildingLeaseDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResult.initFailResult("操作失败");
        }
    }

    @ApiOperation(value = "修改厂房信息", notes = "修改厂房信息")
    @PostMapping("/update")
    public BaseResult update(HttpServletRequest request, @Validated TBuildingLeaseAddDTO tBuildingLeaseAddDTO, BindingResult bindingResult) {
        HttpSession httpSession = request.getSession();
        if(null == httpSession.getAttribute("userId")) {
            return BaseResult.initFailResult("无权限");
        }
        if(null == tBuildingLeaseAddDTO.getId()) {
            return BaseResult.initFailResult("id不能为空");
        }
        if(bindingResult.hasErrors()){
            return BaseResult.initFailResult(bindingResult.getFieldError().getDefaultMessage());
        }
        try {
            tBuildingleaseService.updateInfoById(tBuildingLeaseAddDTO);
            return BaseResult.initSuccessResult("修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResult.initFailResult("操作失败");
        }
    }


    private QueryWrapper<TBuildingLeaseDTO> getWrapper(TBuildingQuery query) {
        QueryWrapper<TBuildingLeaseDTO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status", 1);
        if(null != query) {
            if(!StringUtils.isEmpty(query.getAreaId())) {
                queryWrapper.inSql("id", "select leaseId from t_buildingleasestreet where areaId = "+query.getAreaId());
            }
            if(!StringUtils.isEmpty(query.getCreateTime()) && "desc".equals(query.getCreateTime())) {
                queryWrapper.orderByDesc("createTime");
            }
            if(!StringUtils.isEmpty(query.getCreateTime()) && "asc".equals(query.getCreateTime())) {
                queryWrapper.orderByAsc("createTime");
            }
            if(!StringUtils.isEmpty(query.getPrice()) && "desc".equals(query.getPrice())) {
                queryWrapper.orderByDesc("price");
            }
            if(!StringUtils.isEmpty(query.getPrice()) && "asc".equals(query.getPrice())) {
                queryWrapper.orderByAsc("price");
            }
            if(!StringUtils.isEmpty(query.getPriceBetween()) && "negotiable".equals(query.getPriceBetween())) {
                queryWrapper.eq("price", -1);
            }
            if (!StringUtils.isEmpty(query.getPriceBetween()) && query.getPriceBetween().length() >= 2 && query.getPriceBetween().contains("-")) {
                if (query.getPriceBetween().startsWith("-")) {
                    String str1 = query.getPriceBetween().substring(0, query.getPriceBetween().indexOf("-"));
                    queryWrapper.between("price",0,query.getPriceBetween().substring(str1.length()+1));
                }else if (query.getPriceBetween().endsWith("-")) {
                    String str1 = query.getPriceBetween().substring(0, query.getPriceBetween().indexOf("-"));
                    queryWrapper.between("price", str1, 9999999);
                }else {
                    queryWrapper.between("price",((String)query.getPriceBetween()).substring(0, ((String) query.getPriceBetween()).indexOf("-")),((String)query.getPriceBetween()).substring(((String)query.getPriceBetween()).substring(0, ((String) query.getPriceBetween()).indexOf("-")).length()+1));
                }
            }
            if (!StringUtils.isEmpty(query.getBuildingAreaBetween()) && query.getBuildingAreaBetween().length() >= 4 && query.getBuildingAreaBetween().contains("-")) {
                if (query.getBuildingAreaBetween().startsWith("-")) {
                    String str1 = query.getBuildingAreaBetween().substring(0, query.getBuildingAreaBetween().indexOf("-"));
                    queryWrapper.between("buildingArea",0, query.getBuildingAreaBetween().substring(str1.length()+1));
                }else if (query.getBuildingAreaBetween().endsWith("-")) {
                    String str1 = query.getBuildingAreaBetween().substring(0, query.getBuildingAreaBetween().indexOf("-"));
                    queryWrapper.between("buildingArea", str1, 9999999);
                }else {
                    queryWrapper.between("buildingArea",((String)query.getBuildingAreaBetween()).substring(0, ((String) query.getBuildingAreaBetween()).indexOf("-")),((String)query.getBuildingAreaBetween()).substring(((String)query.getBuildingAreaBetween()).substring(0, ((String) query.getBuildingAreaBetween()).indexOf("-")).length()+1));
                }
            }
        }
        return queryWrapper;
    }


}