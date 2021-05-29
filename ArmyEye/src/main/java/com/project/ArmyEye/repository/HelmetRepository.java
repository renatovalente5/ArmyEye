package com.project.ArmyEye.repository;

import com.project.ArmyEye.Models.Helmet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HelmetRepository extends CrudRepository<Helmet, Long> {

}