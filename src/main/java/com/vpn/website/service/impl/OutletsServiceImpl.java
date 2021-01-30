package com.vpn.website.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vpn.website.client.dto.OutletsAddDTO;
import com.vpn.website.client.mapper.OutletsMapper;
import com.vpn.website.client.model.Outlets;
import com.vpn.website.service.OutletsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 *
 * @author xiaotao
 * @since 2020-12-10
 */
@Service
public class OutletsServiceImpl extends ServiceImpl<OutletsMapper, Outlets> implements OutletsService {

    @Autowired
    private OutletsMapper outletsMapper;

    @Override
    public Integer addOutlets(HttpServletRequest request, OutletsAddDTO outletsAddDTO) {
        Outlets outlets = new Outlets();
        BeanUtils.copyProperties(outletsAddDTO, outlets);
        HttpSession httpSession = request.getSession();
        outlets.setUserId((Integer) httpSession.getAttribute("userId"));
        outlets.setUserName((String) httpSession.getAttribute("username"));
        outlets.setUpdateTime(new Date());
        return outletsMapper.insert(outlets);
    }

    @Override
    public IPage<Outlets> selectOutletsList(Page<Outlets> page, QueryWrapper<Outlets> wrapper) {
        return outletsMapper.selectOutletsList(page, wrapper);
    }

    @Override
    public Integer updateOutlets(OutletsAddDTO outletsAddDTO) {
        Outlets outlets = new Outlets();
        BeanUtils.copyProperties(outletsAddDTO, outlets);
        return outletsMapper.updateById(outlets);
    }

    @Override
    public Outlets getByPrimaryKey(Integer id) {
        return outletsMapper.selectById(id);
    }
}
