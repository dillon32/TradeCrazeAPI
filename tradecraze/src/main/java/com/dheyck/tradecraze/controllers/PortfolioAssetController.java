package com.dheyck.tradecraze.controllers;

import com.dheyck.tradecraze.domain.dto.PortfolioAssetDto;
import com.dheyck.tradecraze.domain.dto.PortfolioDto;
import com.dheyck.tradecraze.domain.dto.UserDto;
import com.dheyck.tradecraze.domain.entities.PortfolioAssetEntity;
import com.dheyck.tradecraze.domain.entities.UserEntity;
import com.dheyck.tradecraze.mappers.Mapper;
import com.dheyck.tradecraze.services.PortfolioAssetService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PortfolioAssetController {

    private Mapper<PortfolioAssetEntity, PortfolioAssetDto> portfolioAssetMapper;

    private PortfolioAssetService portfolioAssetService;

    public PortfolioAssetController(Mapper<PortfolioAssetEntity, PortfolioAssetDto> portfolioAssetMapper,
                                    PortfolioAssetService portfolioAssetService) {
        this.portfolioAssetMapper = portfolioAssetMapper;
        this.portfolioAssetService = portfolioAssetService;
    }

    @PostMapping(path = "/portfolio_assets")
    public ResponseEntity<PortfolioAssetDto> createPortfolioAsset(@RequestBody PortfolioAssetDto portfolioAssetDto) {
        PortfolioAssetEntity savedPortfolioAssetEntity = portfolioAssetService.createPortfolioAsset(portfolioAssetDto);
        PortfolioAssetDto savedPortfolioAssetDto = portfolioAssetMapper.mapTo(savedPortfolioAssetEntity);
        return new ResponseEntity<>(savedPortfolioAssetDto, HttpStatusCode.valueOf(200));
    }
}
