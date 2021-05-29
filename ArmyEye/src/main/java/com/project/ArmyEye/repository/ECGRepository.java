package com.project.ArmyEye.repository;

import com.project.ArmyEye.Models.VitalJacket_ECG;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ECGRepository extends CrudRepository<VitalJacket_ECG, Long> {

}