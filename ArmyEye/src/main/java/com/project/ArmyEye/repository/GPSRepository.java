package com.project.ArmyEye.repository;

import com.project.ArmyEye.Models.GPS;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GPSRepository extends CrudRepository<GPS, Long> {

}