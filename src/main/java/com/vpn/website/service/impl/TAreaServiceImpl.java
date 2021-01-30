package com.vpn.website.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vpn.website.client.dto.TAreaDTO;
import com.vpn.website.client.mapper.TAreaMapper;
import com.vpn.website.client.mapstruct.TAreaMap;
import com.vpn.website.client.model.TArea;
import com.vpn.website.client.query.TAreaQuery;
import com.vpn.website.client.vo.TAreaVo;
import com.vpn.website.common.base.PageBean;
import com.vpn.website.service.TAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TAreaServiceImpl extends ServiceImpl<TAreaMapper, TArea> implements TAreaService {

    private TAreaMap tAreaMap;
    private TAreaMapper tAreaMapper;

    @Autowired
    public TAreaServiceImpl(TAreaMap tAreaMap, TAreaMapper tAreaMapper) {
        this.tAreaMap = tAreaMap;
        this.tAreaMapper = tAreaMapper;
    }

    @Override
    public PageBean<TAreaDTO> listPage(TAreaQuery query) {
        Page<TArea> page = tAreaMapper.selectPage(query.buildPage(), query.buildQuery());
        PageBean<TAreaDTO> bean = new PageBean(page, page.getRecords().stream().map(DO -> tAreaMap.doToDto(DO)).collect(Collectors.toList()));
        return bean;
    }

    @Override
    public List<TAreaVo> getName() {
        return tAreaMapper.getName();
    }
}
