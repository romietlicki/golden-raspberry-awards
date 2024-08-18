package com.golden.raspberry.awards.goldenraspberryawards.services.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golden.raspberry.awards.goldenraspberryawards.entity.Award;
import com.golden.raspberry.awards.goldenraspberryawards.repository.AwardRepository;
import com.golden.raspberry.awards.goldenraspberryawards.services.CsvReaderService;

@Service
public class CsvReaderServiceImpl implements CsvReaderService {
	
    @Autowired
    private AwardRepository repository;
	
	public void readAndLoadCSV() throws IOException {
		
		List<String> lines = Files.readAllLines(Paths.get("../goldenraspberryawards/src/main/resources/csv/movielist.csv"));
		for (String line : lines) {
			if(line.contains("year")) {
				continue;
			}
			String[] parts = line.split(";");
			Award award = new Award();
			award.setYear_movie(Integer.parseInt(parts[0].trim()));
			award.setTitle_movie(parts[1].trim());
			award.setStudios(parts[2].trim());
			award.setProducersName(parts[3].trim());
			if(parts.length==5) {
				award.setWinner_movie(parts[4].trim());
			}
			repository.save(award);
		}
	}

}
