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

    // Check NIM Udah dipakai apa belum
    @Query("SELECT COUNT(f.nim) > 0 from MhsEntity f where f.nim = :nim")
    Boolean isNimExist(@Param("nim") String nim);
    // Check Email Udah dipakai apa belum
    @Query("SELECT COUNT(u.email) > 0 from MhsEntity u where u.email = :email")
    Boolean isEmailExist(@Param("email") String email);
    // Check Hp Udah dipakai apa belum
    @Query("SELECT count(e.no_hp) >= 2 from MhsEntity e WHERE  e.no_hp = :no_hp")
    Boolean isPhoneNumberExist(@Param("no_hp") int no_hp);
}
