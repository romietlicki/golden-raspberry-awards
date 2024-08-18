package com.golden.raspberry.awards.goldenraspberryawards.dto;

import java.util.List;

import lombok.Data;

@Data
public class ResponseDto {
    private List<Interval> min;
    private List<Interval> max;

    public ResponseDto(List<Interval> min, List<Interval> max) {
        this.min = min;
        this.max = max;
    }

}


