package com.example.trade.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.trade.pojo.Trade;
import com.example.trade.repository.TradeRepository;

@Component
public class MaturityDateScheduler {

	@Autowired
	TradeRepository tradeRepository;

	@Scheduled(cron = "0 0 * * * ?")
	public void cronJobSch() {

		for (Trade singletrade : tradeRepository.findAll()) {
			if (singletrade.getMaturity_date().before(new Date())) {
				singletrade.setExpired(true);
				tradeRepository.save(singletrade);
			}
		}
	}
}
