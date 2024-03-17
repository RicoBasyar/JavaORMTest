package com.javaorm.javaorm.repository;

import com.javaorm.javaorm.entity.EmployeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface EmployeRepository extends JpaRepository<EmployeEntity, Integer> {

    @Query("SELECT n from EmployeEntity n where n.employe_name = :employe_name")
    Optional<EmployeEntity> getEmployeByName(String employe_name);

    //is name exist
    @Query("select count(n.employe_name) > 0 from EmployeEntity n where n.employe_name = :employe_name")
    boolean isNameExist(@Param("employe_name") String employe_name);

    //is email exist
    @Query("select count(n.email) > 0 from EmployeEntity n where n.email = :email")
    boolean isEmailExist(@Param("email") String email);

    //is np_hp exist
    @Query("select count(n.phone) > 0 from EmployeEntity n where n.phone = :phone")
    boolean isPhoneExist(@Param("phone") String phone);
}
