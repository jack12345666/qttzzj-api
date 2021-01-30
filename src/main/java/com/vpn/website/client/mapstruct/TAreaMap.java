package com.vpn.website.client.mapstruct;

import com.vpn.website.client.dto.TAreaDTO;
import com.vpn.website.client.model.TArea;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TAreaMap {
    TAreaDTO doToDto(TArea tArea);
}
