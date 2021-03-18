package com.example.trade.service;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.trade.DTO.TradeDTO;
import com.example.trade.controller.Tradecontroller;
import com.example.trade.repository.TradeRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@AutoConfigureMockMvc(addFilters = false)
public class TradeControllerTests extends AbstarctControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private Tradecontroller tradecontroller;

	@MockBean
	private TradeServiceImpl tradeServiceImpl;

	@BeforeEach
	public void setup() {
		tradecontroller = new Tradecontroller();
		mockMvc = MockMvcBuilders.standaloneSetup(tradecontroller).build();
	}

	@Test
	public void testSave() throws Exception {
		TradeDTO trade = new TradeDTO();
		trade.setBook_id("abc");
		trade.setCounter_party_id("counter_party_id");
		trade.setExpired(false);
		trade.setTrade_id("T1");
		trade.setMaturity_date(new Date());
		trade.setVersion(1);
		trade.setCreation_date(new Date());
		String str = mapToJson(trade);

		this.mockMvc.perform(post("/saveTrades").contentType(MediaType.APPLICATION_JSON).content(str)).andDo(print())
				.andExpect(status().is2xxSuccessful()).andReturn();
	}

	protected String mapToJson(Object obj) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(obj);
	}

}
