package com.project.ArmyEye.repository;

import com.project.ArmyEye.Models.Unit_Battery;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatteryRepository extends CrudRepository<Unit_Battery, Long> {

}