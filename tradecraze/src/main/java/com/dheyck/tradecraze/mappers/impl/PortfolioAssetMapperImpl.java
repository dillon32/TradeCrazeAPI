package com.dheyck.tradecraze.mappers.impl;

import com.dheyck.tradecraze.domain.dto.PortfolioAssetDto;
import com.dheyck.tradecraze.domain.entities.PortfolioAssetEntity;
import com.dheyck.tradecraze.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PortfolioAssetMapperImpl implements Mapper<PortfolioAssetEntity, PortfolioAssetDto> {

    private ModelMapper modelMapper;

    public PortfolioAssetMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public PortfolioAssetDto mapTo(PortfolioAssetEntity portfolioAsset) {
        return modelMapper.map(portfolioAsset, PortfolioAssetDto.class);
    }

    @Override
    public PortfolioAssetEntity mapFrom(PortfolioAssetDto portfolioAssetDto) {
        return modelMapper.map(portfolioAssetDto, PortfolioAssetEntity.class);
    }
}
