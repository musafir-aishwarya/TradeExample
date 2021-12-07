package com.example.trade.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.trade.pojo.URLModel;
import com.example.trade.service.UrlService;


@RestController
@RequestMapping("/url")
public class UrlController {
	
	@Autowired
	UrlService urlService;
	
	private Map<String, URLModel> shortenUrlList = new HashMap<>();


	@RequestMapping(value="/hi", method=RequestMethod.GET)
	public String hiIndex() {
		return "Hi bebe";
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String loadIndex() {
		return "index";
	}
	
	@RequestMapping(value="/shortenurl", method=RequestMethod.POST)
	public ResponseEntity<Object> SaveLongURL(@RequestBody String longUrl) throws MalformedURLException {
		URLModel url = urlService.saveData(longUrl);
		
		return new ResponseEntity<Object>(url.getShort_url(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/longurl/{randomstring}", method=RequestMethod.GET)
	public void getFullUrl(HttpServletResponse response, @PathVariable("randomstring") String randomString) throws IOException {
		
		URLModel url = urlService.fetchData(randomString);
		response.sendRedirect(shortenUrlList.get(randomString).getLong_url());
	}
	
}
