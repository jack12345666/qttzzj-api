package com.vpn.website.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.vpn.website.client.dto.TAreaDTO;
import com.vpn.website.client.model.TArea;
import com.vpn.website.client.query.TAreaQuery;
import com.vpn.website.client.vo.TAreaVo;
import com.vpn.website.common.base.PageBean;

import java.util.List;

public interface TAreaService extends IService<TArea> {
    PageBean<TAreaDTO> listPage(TAreaQuery query);
    List<TAreaVo> getName();
}
