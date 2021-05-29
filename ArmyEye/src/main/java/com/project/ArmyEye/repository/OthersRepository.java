package com.project.ArmyEye.repository;

import com.project.ArmyEye.Models.VitalJacket_others;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OthersRepository extends CrudRepository<VitalJacket_others, Long> {

}