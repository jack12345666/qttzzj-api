package com.vpn.website.client.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vpn.website.client.model.TArea;
import com.vpn.website.client.vo.TAreaVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TAreaMapper extends BaseMapper<TArea> {
    List<TAreaVo> getName();
}
