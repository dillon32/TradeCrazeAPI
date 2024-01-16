package com.dheyck.tradecraze.services;

import com.dheyck.tradecraze.domain.dto.PortfolioAssetDto;
import com.dheyck.tradecraze.domain.entities.PortfolioAssetEntity;

public interface PortfolioAssetService {

    PortfolioAssetEntity createPortfolioAsset(PortfolioAssetDto portfolioAssetDto);

}
