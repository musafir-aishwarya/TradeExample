package com.example.trade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.trade.pojo.Trade;

@Repository
public interface TradeRepository extends JpaRepository<Trade, String>{


}
