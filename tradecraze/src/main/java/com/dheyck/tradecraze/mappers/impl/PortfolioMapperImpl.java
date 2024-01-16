package com.dheyck.tradecraze.mappers.impl;

import com.dheyck.tradecraze.domain.dto.PortfolioDto;
import com.dheyck.tradecraze.domain.entities.PortfolioEntity;
import com.dheyck.tradecraze.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PortfolioMapperImpl implements Mapper<PortfolioEntity, PortfolioDto> {

    private ModelMapper modelMapper;

    public PortfolioMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public PortfolioDto mapTo(PortfolioEntity portfolio) {
        return modelMapper.map(portfolio, PortfolioDto.class);
    }

    @Override
    public PortfolioEntity mapFrom(PortfolioDto portfolioDto) {
        return modelMapper.map(portfolioDto, PortfolioEntity.class);
    }
}
