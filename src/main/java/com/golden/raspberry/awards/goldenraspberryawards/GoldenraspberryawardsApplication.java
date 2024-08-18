package com.golden.raspberry.awards.goldenraspberryawards;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.golden.raspberry.awards.goldenraspberryawards.services.impl.CsvReaderServiceImpl;

@SpringBootApplication
public class GoldenraspberryawardsApplication  {
	
	@Autowired
	CsvReaderServiceImpl csvReaderService;
	
	public static void main(String[] args) throws IOException {
		 SpringApplication.run(GoldenraspberryawardsApplication.class, args);
		 
	}
	
	
	@Bean
	ApplicationRunner init() throws IOException {
		csvReaderService.readAndLoadCSV();
		
		return args -> {
			System.out.println("INIT");
		};
	}
}
