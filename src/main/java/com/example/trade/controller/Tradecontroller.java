package com.example.trade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.trade.DTO.TradeDTO;
import com.example.trade.pojo.Trade;
import com.example.trade.service.TradeServiceImpl;

@RestController
public class Tradecontroller {

	@Autowired
	private TradeServiceImpl tradeServiceImpl;

	@GetMapping("/getTrades")
	public ResponseEntity<List<Trade>> getAllProduct() {
		return ResponseEntity.ok().body(tradeServiceImpl.getAllTrade());
	}
	
	@PostMapping("/saveTrades")
	public void saveTrade(@RequestBody TradeDTO trade)
	{
		tradeServiceImpl.saveTrade(trade);
	}
	
}
