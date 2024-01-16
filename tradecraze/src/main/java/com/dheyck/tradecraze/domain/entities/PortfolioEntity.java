package com.dheyck.tradecraze.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "portfolios")
public class PortfolioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "portfolio_id_seq")
    private Long id;

    private Long user_id;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<PortfolioAssetEntity> portfolio_assets = new ArrayList<PortfolioAssetEntity>();

}
