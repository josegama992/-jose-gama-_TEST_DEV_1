package com.Test.Stocksapi;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.Test.Stocksapi.domain.model.Company;
import com.Test.Stocksapi.domain.model.Stock;
import com.Test.Stocksapi.domain.model.repository.CompanyRepository;
import com.Test.Stocksapi.domain.model.repository.StockRepository;

@SpringBootApplication
public class TestApplication {

	public static void main(String[] args) {
		//SpringApplication.run(TestApplication.class, args);				
		ApplicationContext applicationContext = new SpringApplicationBuilder(TestApplication.class)
				.web(WebApplicationType.SERVLET).run(args);
		
//Populate Table
		Date end = new Date();
		StockRepository stockRepository = applicationContext.getBean(StockRepository.class);
		CompanyRepository companyRepository = applicationContext.getBean(CompanyRepository.class);
		
		Calendar dStart = Calendar.getInstance(); 
		dStart.add(Calendar.DAY_OF_YEAR, -30);
		Calendar cEnd = Calendar.getInstance(); 
					
		for(int i=1; i<=3;i++) {
			Long companyId = Long.parseLong(String.valueOf(i));
			while (dStart.get(Calendar.DAY_OF_YEAR)<= cEnd.get(Calendar.DAY_OF_YEAR)) {
				if(dStart.get(Calendar.HOUR_OF_DAY)>=10 & dStart.get(Calendar.HOUR_OF_DAY)<18) {
					Stock currentstock = new Stock();
					currentstock.setPriceDate(dStart);
					currentstock.setPrice(new BigDecimal(10));
					currentstock.setCompany(companyRepository.findById(companyId).get());
					System.out.println("Time: " + currentstock.getPriceDate().getTime() + "price:" + currentstock.getPrice());
					stockRepository.save(currentstock);
					
					System.out.println(dStart.getTime());
			}
				dStart.add(Calendar.MINUTE, 1);
			}
		dStart.add(Calendar.DAY_OF_YEAR, -30);
	
		
		}

}
}



