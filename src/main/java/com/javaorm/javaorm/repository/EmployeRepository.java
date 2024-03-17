package com.javaorm.javaorm.repository;

import com.javaorm.javaorm.entity.EmployeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface EmployeRepository extends JpaRepository<EmployeEntity, Integer> {


}
