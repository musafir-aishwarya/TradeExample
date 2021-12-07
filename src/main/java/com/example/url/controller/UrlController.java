package com.example.url.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.trade.pojo.URLModel;

@RestController
@RequestMapping("/url")
public class UrlController {
	
	private Map<String, URLModel> shortenUrlList = new HashMap<>();

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String loadIndex() {
		return "index";
	}
	
	@RequestMapping(value="/hi", method=RequestMethod.GET)
	public String hiIndex() {
		return "Hi bebe";
	}
	
	@RequestMapping(value="/shortenurl", method=RequestMethod.POST)
	public ResponseEntity<Object> getShortenUrl(@RequestBody URLModel shortenUrl) throws MalformedURLException {
		String randomChar = getRandomChars();
		setShortUrl(randomChar, shortenUrl);
		return new ResponseEntity<Object>(shortenUrl, HttpStatus.OK);
	}
	
	@RequestMapping(value="/s/{randomstring}", method=RequestMethod.GET)
	public void getFullUrl(HttpServletResponse response, @PathVariable("randomstring") String randomString) throws IOException {
		response.sendRedirect(shortenUrlList.get(randomString).getLong_url());
	}

	private void setShortUrl(String randomChar, URLModel shortenUrl) throws MalformedURLException {
		 shortenUrl.setShort_url("http://localhost:8080/s/"+randomChar);
		 shortenUrlList.put(randomChar, shortenUrl);
	}

	private String getRandomChars() {
		String randomStr = "";
		String possibleChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		for (int i = 0; i < 5; i++)
			randomStr += possibleChars.charAt((int) Math.floor(Math.random() * possibleChars.length()));
		return randomStr;
	}

}
