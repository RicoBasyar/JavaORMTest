package com.javaorm.javaorm.service.impl;

import com.javaorm.javaorm.dto.reqbody.RegisterReqBody;
import com.javaorm.javaorm.entity.MhsEntity;
import com.javaorm.javaorm.repository.MhsRepository;
import com.javaorm.javaorm.service.MhsService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MhsServiceImpl implements MhsService {

    @Autowired
    private MhsRepository mhsRepository;

    public MhsEntity getMhsDataByEmail(String name){
        return mhsRepository.findByEmail(name).orElse(null);
    }

    @Override
    public Object Register(RegisterReqBody req) {
        boolean isNimExist = mhsRepository.isNimExist(req.getNim());
        if(isNimExist){
            return "NIM Sudah Digunakan";
        }

        Boolean isEmailExist = mhsRepository.isEmailExist(req.getEmail());
        if(isEmailExist){
            return "Email Sudah Digunakan";
        }

        Boolean isPhoneNumberExist = mhsRepository.isPhoneNumberExist(req.getNo_hp());
        if(isPhoneNumberExist){
            return "Nomor HP Sudah Lebih dari 2";
        }

        try {
            MhsEntity mhsEntity = new MhsEntity();
            mhsEntity.setNim(req.getNim());
            mhsEntity.setNama_mhs(req.getNama_mhs());
            mhsEntity.setEmail(req.getEmail());
            mhsEntity.setNo_hp(req.getNo_hp());

            return mhsRepository.save(mhsEntity);
        }catch (Exception e){
            return e;
        }
    }
}
