package com.vpn.website.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vpn.website.client.dto.LandAddDTO;
import com.vpn.website.client.mapper.LandMapper;
import com.vpn.website.client.model.Land;
import com.vpn.website.service.LandService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 *
 * @author tao
 * @since 2020-12-10
 */
@Service
public class LandServiceImpl extends ServiceImpl<LandMapper, Land> implements LandService {

    @Autowired
    private LandMapper landMapper;

    @Override
    public Integer addLand(HttpServletRequest request, LandAddDTO landAddDTO) {
        Land land = new Land();
        BeanUtils.copyProperties(landAddDTO, land);
        HttpSession httpSession = request.getSession();
        land.setUserId((Integer) httpSession.getAttribute("userId"));
        land.setUserName((String) httpSession.getAttribute("username"));
        land.setUpdateTime(new Date());
        return landMapper.insert(land);
    }

    @Override
    public IPage<Land> selectLandList(Page<Land> page, QueryWrapper<Land> wrapper) {
        return landMapper.selectLandList(page, wrapper);
    }

    @Override
    public Integer updateLand(LandAddDTO landAddDTO) {
        Land land = new Land();
        BeanUtils.copyProperties(landAddDTO, land);
        return landMapper.updateById(land);
    }

    @Override
    public Land getByPrimaryKey(Integer id) {
        return landMapper.selectById(id);
    }
}
