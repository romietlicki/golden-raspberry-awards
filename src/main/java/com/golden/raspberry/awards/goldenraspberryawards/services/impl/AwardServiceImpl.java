package com.golden.raspberry.awards.goldenraspberryawards.services.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golden.raspberry.awards.goldenraspberryawards.dto.Interval;
import com.golden.raspberry.awards.goldenraspberryawards.dto.ResponseDto;
import com.golden.raspberry.awards.goldenraspberryawards.entity.Award;
import com.golden.raspberry.awards.goldenraspberryawards.repository.AwardRepository;
import com.golden.raspberry.awards.goldenraspberryawards.services.AwardService;

@Service
public class AwardServiceImpl implements AwardService{

    @Autowired
    private AwardRepository repository;

    public ResponseDto getAwardIntervals() {
        List<Award> awards = repository.findAll();
        Map<String, List<Integer>> producerYearsMap = new HashMap<>();

        // Agrupa os anos dos prêmios por produtor
        for (Award award : awards) {
            String producer = award.getProducersName();
            int year = award.getYear_movie();

            producerYearsMap
                .computeIfAbsent(producer, k -> new ArrayList<>())
                .add(year);
        }

        List<Interval> intervals = new ArrayList<>();

        // Calcula os intervalos para produtores com mais de um prêmio
        for (Map.Entry<String, List<Integer>> entry : producerYearsMap.entrySet()) {
            List<Integer> years = entry.getValue();
            if (years.size() > 1) {
                Collections.sort(years);

                int minInterval = years.get(1) - years.get(0);
                int maxInterval = years.get(years.size() - 1) - years.get(0);

                for (int i = 1; i < years.size(); i++) {
                    int interval = years.get(i) - years.get(i - 1);
                    minInterval = Math.min(minInterval, interval);
                }

                intervals.add(new Interval(entry.getKey(), minInterval, maxInterval, years.get(0), years.get(years.size() - 1)));
            }
        }

        // Ordena os intervalos pelo menor intervalo
        intervals.sort(Comparator.comparingInt(Interval::getInterval));

        // Filtra os menores e maiores intervalos
        int minIntervalValue = intervals.get(0).getInterval();
        int maxIntervalValue = intervals.get(intervals.size() - 1).getInterval();

        List<Interval> minIntervals = new ArrayList<>();
        List<Interval> maxIntervals = new ArrayList<>();

        for (Interval interval : intervals) {
            if (interval.getInterval() == minIntervalValue) {
                minIntervals.add(interval);
            }
            if (interval.getInterval() == maxIntervalValue) {
                maxIntervals.add(interval);
            }
        }

        return new ResponseDto(minIntervals, maxIntervals);
    }
}

