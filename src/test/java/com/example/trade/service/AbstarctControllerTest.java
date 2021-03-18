package com.example.trade.service;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.trade.SpringTradeExampleApplication;
import com.example.trade.controller.Tradecontroller;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { SpringTradeExampleApplication.class })
public abstract class AbstarctControllerTest {

	protected MockMvc mockMvc;

	protected ObjectMapper mapper;
	@Autowired
	protected WebApplicationContext webApplicationContext;
	protected Tradecontroller tradecontroller;

	@Before
	public void setup() throws Exception {
		this.mapper = new ObjectMapper();
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
	}

	public MvcResult executePostAPI(String uri, String requestBodyContent) throws Exception {
		return this.mockMvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(requestBodyContent)).andReturn();
	}
}
