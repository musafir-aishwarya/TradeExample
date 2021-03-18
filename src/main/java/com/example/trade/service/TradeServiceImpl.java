package com.example.trade.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.trade.DTO.TradeDTO;
import com.example.trade.exception.HigherVersionAvailableExeption;
import com.example.trade.exception.InvalidMaturityDateException;
import com.example.trade.pojo.Trade;
import com.example.trade.repository.TradeRepository;

@Service
public class TradeServiceImpl {

	@Autowired
	TradeRepository tradeRepository;

	public List<Trade> getAllTrade() {
		List<Trade> TradeList = tradeRepository.findAll();

		if (TradeList.size() > 0) {
			return TradeList;
		} else {
			return new ArrayList<Trade>();
		}
	}

	public void saveTrade(TradeDTO trade) {
		Trade tradeEntity = new Trade();
		if (tradeRepository.findAll().size() > 1) {
			for (Trade singletrade : tradeRepository.findAll()) {
				if (singletrade.getTrade_id().equals(trade.getTrade_id())
						&& singletrade.getVersion() > trade.getVersion()) {
					throw new HigherVersionAvailableExeption("Higher version for this trade already exist in database");
				} else if (singletrade.getTrade_id().equals(trade.getTrade_id())
						&& singletrade.getVersion() < trade.getVersion()) {

					if (!checkMaturityDate(trade.getMaturity_date())) {
						tradeEntity.setExpired(false);
						tradeEntity.setCreation_date(new Date());
						tradeEntity.setBook_id(trade.getBook_id());
						tradeEntity.setCounter_party_id(trade.getCounter_party_id());
						tradeEntity.setMaturity_date(trade.getMaturity_date());
						tradeEntity.setTrade_id(trade.getTrade_id());
						tradeRepository.save(tradeEntity);
					}
				}
			}
		} else {

			if (!checkMaturityDate(trade.getMaturity_date())) {
				tradeEntity.setExpired(false);
				tradeEntity.setCreation_date(new Date());
				tradeEntity.setBook_id(trade.getBook_id());
				tradeEntity.setCounter_party_id(trade.getCounter_party_id());
				tradeEntity.setMaturity_date(trade.getMaturity_date());
				tradeEntity.setTrade_id(trade.getTrade_id());
				tradeRepository.save(tradeEntity);
			}

		}

	}

	public boolean checkMaturityDate(Date maturityDate) {

		if (maturityDate.before(new Date())) {

			throw new InvalidMaturityDateException("Higher version for this trade already exist in database");

		}
		return false;
	}
}
