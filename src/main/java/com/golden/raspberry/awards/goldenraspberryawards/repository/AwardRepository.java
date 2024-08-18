package com.golden.raspberry.awards.goldenraspberryawards.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.golden.raspberry.awards.goldenraspberryawards.entity.Award;

public interface AwardRepository extends JpaRepository<Award, Long> {
	List<Award> findByProducersName(String producersName);
}
