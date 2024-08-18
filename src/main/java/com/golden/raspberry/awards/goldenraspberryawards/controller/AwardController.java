package com.golden.raspberry.awards.goldenraspberryawards.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.golden.raspberry.awards.goldenraspberryawards.dto.ResponseDto;
import com.golden.raspberry.awards.goldenraspberryawards.services.AwardService;

@RestController
@RequestMapping("/api/awards")
public class AwardController {

    @Autowired
    private AwardService service;

    @GetMapping("/intervals")
    public ResponseDto getIntervals() {
        return service.getAwardIntervals();
    }
}
