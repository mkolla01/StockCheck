package com.abab.stocks.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.abab.stocks.dao.StocksDao;
import com.abab.stocks.domain.Stocks;

@RestController
public class StockController {

	@Autowired 
	StocksDao stocksdao;
	
	@RequestMapping(value = "/stocks/", method = RequestMethod.GET)
	public ResponseEntity<List<Stocks>> listStocks() {
		List<Stocks> list = new ArrayList <Stocks>();
		try {
			list = stocksdao.listStocks();
			if ( list.isEmpty()){
				return new ResponseEntity<List<Stocks>>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return new ResponseEntity<List<Stocks>>( HttpStatus.UNAUTHORIZED);
			
		}
		//fwfff
		//second test
		//Thrird test
		return new ResponseEntity<List<Stocks>>(list, HttpStatus.OK);
	}
	
	
	
}
