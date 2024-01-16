package com.dheyck.tradecraze.services.impl;

import com.dheyck.tradecraze.domain.dto.PortfolioAssetDto;
import com.dheyck.tradecraze.domain.entities.PortfolioAssetEntity;
import com.dheyck.tradecraze.domain.entities.PortfolioEntity;
import com.dheyck.tradecraze.exceptions.NotFound;
import com.dheyck.tradecraze.mappers.Mapper;
import com.dheyck.tradecraze.services.PortfolioAssetService;
import com.dheyck.tradecraze.services.PortfolioService;
import com.dheyck.tradecraze.repositories.PortfolioRepository;
import com.dheyck.tradecraze.repositories.PortfolioAssetRepository;
import org.springframework.stereotype.Service;

@Service
public class PortfolioAssetServiceImpl implements PortfolioAssetService {

    private PortfolioAssetRepository portfolioAssetRepository;
    private PortfolioRepository portfolioRepository;
    private Mapper<PortfolioAssetEntity, PortfolioAssetDto> portfolioAssetMapper;

    public PortfolioAssetServiceImpl(PortfolioAssetRepository portfolioAssetRepository,
                                     PortfolioRepository portfolioRepository,
                                    Mapper<PortfolioAssetEntity, PortfolioAssetDto> portfolioAssetMapper) {
        this.portfolioAssetRepository = portfolioAssetRepository;
        this.portfolioRepository = portfolioRepository;
        this.portfolioAssetMapper = portfolioAssetMapper;
    }

    @Override
    public PortfolioAssetEntity createPortfolioAsset(PortfolioAssetDto portfolioAssetDto) {

        PortfolioAssetEntity portfolioAssetEntity = portfolioAssetMapper.mapFrom(portfolioAssetDto);

        PortfolioEntity portfolio = portfolioRepository.findById(portfolioAssetDto.getPortfolioId()).orElseThrow(() -> new NotFound("Portfolio not found when trying to store new asset."));

        portfolioAssetEntity.setPortfolio(portfolio);

        return portfolioAssetRepository.save(portfolioAssetEntity);
    }
}
