package com.javaorm.javaorm.repository;

import com.javaorm.javaorm.entity.MhsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface MhsRepository extends JpaRepository<MhsEntity, Integer> {
    Optional<MhsEntity> findByEmail(String email);

    // Get Data User
    @Query("SELECT u FROM MhsEntity u where u.email = :email")
    MhsEntity getUserByEmail(@Param("email") String email);

    // Check Email Udah dipakai apa belum
    @Query("SELECT COUNT(u.email) > 0 from MhsEntity where u.email = :email")
    Boolean isEmailExist(@Param("email") String email);
    @Query("SELECT count(e.phoneNumber) <= 2 from  MhsEntity WHERE e.phoneNumber = :phoneNumber")
    Boolean isPhoneNumberExist(@Param("phoneNumber") int phoneNumber);
}
