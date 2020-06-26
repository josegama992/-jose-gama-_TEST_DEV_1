package com.Test.Stocksapi.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Test.Stocksapi.domain.model.Stock;
import com.Test.Stocksapi.domain.model.repository.StockRepository;
import com.Test.Stocksapi.domain.service.StocksService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class StocksController {
	
	@Autowired
	private StocksService stockService; 
	
	@GetMapping("test")
	public List<Stock> gettudo(@RequestParam int hours, @RequestParam(name = "company_name") String companyName){
		return stockService.getStocks(companyName, hours);
	}
	@GetMapping("getAll")
	public List<Stock> getAll(){
		return stockService.listAll();
	}
}
