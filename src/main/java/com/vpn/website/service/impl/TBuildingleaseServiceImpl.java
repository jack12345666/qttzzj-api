package com.vpn.website.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vpn.website.client.dto.TBuildingLeaseAddDTO;
import com.vpn.website.client.dto.TBuildingLeaseDTO;
import com.vpn.website.client.mapper.TBuildingleaseMapper;
import com.vpn.website.client.mapper.TBuildingleaseattachmentMapper;
import com.vpn.website.client.mapper.TBuildingleasestreetMapper;
import com.vpn.website.client.mapstruct.TBuildingleaseMap;
import com.vpn.website.client.model.TBuildinglease;
import com.vpn.website.client.model.TBuildingleaseattachment;
import com.vpn.website.client.model.TBuildingleasestreet;
import com.vpn.website.client.util.AppUtil;
import com.vpn.website.client.vo.UserLeaseVo;
import com.vpn.website.service.TBuildingleaseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class TBuildingleaseServiceImpl extends ServiceImpl<TBuildingleaseMapper, TBuildinglease> implements TBuildingleaseService {

    private TBuildingleaseMap leaseMap;
    private TBuildingleaseMapper leaseMapper;
    private TBuildingleaseattachmentMapper attachmentMapper;
    private TBuildingleasestreetMapper tBuildingleasestreetMapper;

    @Autowired
    public TBuildingleaseServiceImpl(TBuildingleaseMapper leaseMapper,TBuildingleaseMap leaseMap,TBuildingleaseattachmentMapper attachmentMapper,TBuildingleasestreetMapper tBuildingleasestreetMapper){
        this.leaseMapper = leaseMapper;
        this.leaseMap = leaseMap;
        this.attachmentMapper = attachmentMapper;
        this.tBuildingleasestreetMapper = tBuildingleasestreetMapper;
    }

    @Override
    public TBuildingLeaseDTO getByPrimaryKey(int id) {
        TBuildingLeaseDTO tBuildingLeaseDTO = new TBuildingLeaseDTO();
        TBuildinglease tBuildinglease = leaseMapper.selectById(id);
        if(null != tBuildinglease){
            // 对象拷贝
            BeanUtils.copyProperties(tBuildinglease,tBuildingLeaseDTO);
            QueryWrapper<TBuildingleaseattachment> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("leaseId",id);
            List<TBuildingleaseattachment> attachmentList = attachmentMapper.selectList(queryWrapper);
            tBuildingLeaseDTO.setAttachmentList(attachmentList);
            QueryWrapper<TBuildingleasestreet> streetWrapper = new QueryWrapper<>();
            streetWrapper.eq("leaseId", id);
            List<TBuildingleasestreet> tBackstreets = tBuildingleasestreetMapper.selectList(streetWrapper);
            tBuildingLeaseDTO.setStreetList(tBackstreets);
            return tBuildingLeaseDTO;
        }else {
            return null;
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer updateInfoById(TBuildingLeaseAddDTO tBuildingLeaseAddDTO) {
        TBuildinglease tBuildinglease = new TBuildinglease();
        BeanUtils.copyProperties(tBuildingLeaseAddDTO, tBuildinglease);
        Integer result = leaseMapper.updateById(tBuildinglease);
        if(1 == result) {
            QueryWrapper<TBuildingleaseattachment> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("leaseId",tBuildingLeaseAddDTO.getId());
            attachmentMapper.delete(queryWrapper);
            if(StringUtils.isNotBlank(tBuildingLeaseAddDTO.getAttachment())){
                String[] paths = tBuildingLeaseAddDTO.getAttachment().split(",");
                for(String path : paths){
                    TBuildingleaseattachment attachment = new TBuildingleaseattachment();
                    attachment.setLeaseId(Long.valueOf(tBuildingLeaseAddDTO.getId()));
                    attachment.setFileName(AppUtil.getFileName(path));
                    attachment.setFilePath(path);
                    attachment.setFileExt(AppUtil.getFileExt(path));
                    attachment.setCreateTime(new Date());
                    attachmentMapper.insert(attachment);
                }
            }
            QueryWrapper<TBuildingleasestreet> streetWrapper = new QueryWrapper<>();
            streetWrapper.eq("leaseId",tBuildingLeaseAddDTO.getId());
            tBuildingleasestreetMapper.delete(streetWrapper);
            if(StringUtils.isNotBlank(tBuildingLeaseAddDTO.getAreaId()) && StringUtils.isNotBlank(tBuildingLeaseAddDTO.getAreaName())) {
                String[] areaIds = tBuildingLeaseAddDTO.getAreaId().split(",");
                String[] areaNames = tBuildingLeaseAddDTO.getAreaName().split(",");
                for (int i = 0; i < areaIds.length; i++) {
                    TBuildingleasestreet tBuildingleasestreet = new TBuildingleasestreet();
                    tBuildingleasestreet.setLeaseId(Long.valueOf(tBuildingLeaseAddDTO.getId()));
                    tBuildingleasestreet.setAreaId(areaIds[i]);
                    tBuildingleasestreet.setAreaName(areaNames[i].trim());
                    tBuildingleasestreetMapper.insert(tBuildingleasestreet);
                }
            }
        }
        return result;
    }

    @Override
    public IPage<UserLeaseVo> selectUserList(Page<TBuildingLeaseDTO> page, QueryWrapper<TBuildingLeaseDTO> wrapper) {
        return leaseMapper.selectLeaseList(page, wrapper);
    }

    @Override
    public IPage<TBuildingLeaseDTO> getLeaseList(Page<TBuildingLeaseDTO> page, QueryWrapper<TBuildingLeaseDTO> wrapper) {
        return leaseMapper.getLeaseList(page, wrapper);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer addBuilding(HttpServletRequest request, TBuildingLeaseAddDTO tBuildingLeaseAddDTO) {
        HttpSession httpSession = request.getSession();
        tBuildingLeaseAddDTO.setNo(UUID.randomUUID().toString().substring(0, 18));
        tBuildingLeaseAddDTO.setEmployeeId(Long.parseLong(httpSession.getAttribute("userId").toString()));
        tBuildingLeaseAddDTO.setEmployeeName((String) httpSession.getAttribute("username"));
        tBuildingLeaseAddDTO.setEditTime(new Date());
        Integer result = leaseMapper.addBuilding(tBuildingLeaseAddDTO);
        if(1 == result){
            if(StringUtils.isNotBlank(tBuildingLeaseAddDTO.getAttachment())){
                String[] paths = tBuildingLeaseAddDTO.getAttachment().split(",");
                for(String path : paths){
                    TBuildingleaseattachment attachment = new TBuildingleaseattachment();
                    attachment.setLeaseId(Long.valueOf(tBuildingLeaseAddDTO.getId()));
                    attachment.setFileName(AppUtil.getFileName(path));
                    attachment.setFilePath(path);
                    attachment.setFileExt(AppUtil.getFileExt(path));
                    attachment.setCreateTime(new Date());
                    attachmentMapper.insert(attachment);
                }
            }
            if(StringUtils.isNotBlank(tBuildingLeaseAddDTO.getAreaId()) && StringUtils.isNotBlank(tBuildingLeaseAddDTO.getAreaName())) {
                String[] areaIds = tBuildingLeaseAddDTO.getAreaId().split(",");
                String[] areaNames = tBuildingLeaseAddDTO.getAreaName().split(",");
                for (int i = 0; i < areaIds.length; i++) {
                    TBuildingleasestreet tBuildingleasestreet = new TBuildingleasestreet();
                    tBuildingleasestreet.setLeaseId(Long.valueOf(tBuildingLeaseAddDTO.getId()));
                    tBuildingleasestreet.setAreaId(areaIds[i]);
                    tBuildingleasestreet.setAreaName(areaNames[i].trim());
                    tBuildingleasestreetMapper.insert(tBuildingleasestreet);
                }
            }
        }
        return result;
    }
}