package com.example.trade.service;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.trade.pojo.URLModel;
import com.example.trade.repository.UrlRepository;

@Service
public class UrlService {

	@Autowired
	UrlRepository urlRepository;

	private Map<String, URLModel> shortenUrlList = new HashMap<>();

	public URLModel saveData(String longUrl) throws MalformedURLException {
		String randomChar = getRandomChars();
		URLModel dataModel = new URLModel();
		dataModel.setCount(0);
		dataModel.setLong_url(longUrl);
		URLModel s = setShortUrl(randomChar, longUrl);
		dataModel.setShort_url(s.getShort_url());
		
		return urlRepository.save(dataModel);
	}

	public URLModel setShortUrl(String randomChar, String shortenUrl) throws MalformedURLException {
		URLModel dataModel = new URLModel();
		dataModel.setShort_url("http://localhost:8080/s/" + randomChar);
		return dataModel;
	}

	public String getRandomChars() {
		String randomStr = "";
		String possibleChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		for (int i = 0; i < 5; i++)
			randomStr += possibleChars.charAt((int) Math.floor(Math.random() * possibleChars.length()));
		return randomStr;
	}
	
	
	public URLModel fetchData(String randomString)
	{

		List<URLModel> dataModels = new ArrayList<URLModel>();
		dataModels = urlRepository.findAll();
		URLModel finalDataModel = new URLModel();
		for(URLModel dataModel : dataModels) {
			String st = dataModel.getLong_url();			
			if(st.equals(randomString)) {
				finalDataModel = dataModel;
				finalDataModel.setCount(dataModel.getCount()+1);
			}
		}
		urlRepository.save(finalDataModel);
		return finalDataModel;
	}
}
