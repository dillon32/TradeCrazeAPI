package com.dheyck.tradecraze.services.impl;

import com.dheyck.tradecraze.domain.entities.PortfolioEntity;
import com.dheyck.tradecraze.services.PortfolioService;
import com.dheyck.tradecraze.repositories.PortfolioRepository;
import org.springframework.stereotype.Service;

@Service
public class PortfolioServicesImpl implements PortfolioService {

    private PortfolioRepository portfolioRepository;

    public PortfolioServicesImpl(PortfolioRepository portfolioRepository) {
        this.portfolioRepository = portfolioRepository;
    }

    @Override
    public PortfolioEntity createPortfolio(PortfolioEntity portfolio) {
        return portfolioRepository.save(portfolio);
    }
}
