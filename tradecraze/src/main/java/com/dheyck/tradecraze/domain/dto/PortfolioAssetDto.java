package com.dheyck.tradecraze.domain.dto;

import com.dheyck.tradecraze.domain.entities.PortfolioEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PortfolioAssetDto {

    private Long id;

    private Long portfolio_id;

    private String stock_ticker;

    private Long share_count;

    public Long getPortfolioId() { return portfolio_id; }

}
