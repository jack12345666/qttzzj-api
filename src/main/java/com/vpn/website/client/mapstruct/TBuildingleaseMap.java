package com.vpn.website.client.mapstruct;

import com.vpn.website.client.dto.TBuildingLeaseDTO;
import com.vpn.website.client.model.TBuildinglease;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TBuildingleaseMap {
    TBuildingLeaseDTO doToDto(TBuildinglease tBuildinglease);
}
