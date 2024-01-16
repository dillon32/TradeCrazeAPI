package com.dheyck.tradecraze.controllers;

import com.dheyck.tradecraze.domain.dto.PortfolioDto;
import com.dheyck.tradecraze.domain.entities.PortfolioEntity;
import com.dheyck.tradecraze.domain.entities.UserEntity;
import com.dheyck.tradecraze.mappers.Mapper;
import com.dheyck.tradecraze.services.PortfolioService;
import com.dheyck.tradecraze.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class PortfolioController {

    private Mapper<PortfolioEntity, PortfolioDto> portfolioMapper;

    private PortfolioService portfolioService;
    private UserService userService;

    public PortfolioController(Mapper<PortfolioEntity, PortfolioDto> portfolioMapper,
                               PortfolioService portfolioService, UserService userService) {
        this.portfolioMapper = portfolioMapper;
        this.portfolioService = portfolioService;
        this.userService = userService;
    }

    @PostMapping("/portfolios")
    public ResponseEntity<PortfolioDto> createPortfolio(@RequestBody PortfolioDto portfolioDto) {
        Optional<UserEntity> userEntity = userService.getUserById(portfolioDto.getUser_id()); // Modify this based on your logic
        if (userEntity.isPresent()) {
            //User exists, proceed to create Portfolio
            PortfolioEntity portfolioEntity = portfolioMapper.mapFrom(portfolioDto);
            PortfolioEntity savedPortfolioEntity = portfolioService.createPortfolio(portfolioEntity);
            PortfolioDto savedPortfolioDto = portfolioMapper.mapTo(savedPortfolioEntity);
            return new ResponseEntity<>(savedPortfolioDto, HttpStatusCode.valueOf(200));
        } else {
            // User is missing or invalid
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
