package com.javaorm.javaorm.repository;

import com.javaorm.javaorm.entity.MhsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//test
@Repository
@EnableJpaRepositories
public interface MhsRepository extends JpaRepository<MhsEntity, Integer> {
    //get user by email
    Optional<MhsEntity> findByEmail(String email);
    //delete user by nim
    Optional<MhsEntity> deleteByNim(String nim);


    //get mhs name
    @Query("SELECT u.nama_mhs from MhsEntity u")
    Page findUsersNameOnly(PageRequest page);

    @Query("SELECT u.email from MhsEntity u")
    Page findDataEmailsOnly(PageRequest page);

    //Get Nim
    @Query("select n from MhsEntity n where n.nim = :nim")
    MhsEntity getNim(@Param("nim") String nim);

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
