package com.example.trade.service;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.trade.DTO.TradeDTO;
import com.example.trade.repository.TradeRepository;

@RunWith(MockitoJUnitRunner.class)
public class TradeServiceImplTest {

	@InjectMocks
	private TradeServiceImpl tradeServiceImpl;
	
	@Mock
	private TradeRepository tradeRepository;
	
	@Test
	public void savetradeTest()
	{
		TradeDTO trade = new TradeDTO();
		trade.setBook_id("abc");
		trade.setCounter_party_id("counter_party_id");
		trade.setExpired(false);
		trade.setTrade_id("T1");
		trade.setMaturity_date(new Date());
		trade.setVersion(1);
		trade.setCreation_date(new Date());
		
	}
}
