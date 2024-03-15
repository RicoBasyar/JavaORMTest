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
        Boolean isEmailExist = mhsRepository.isEmailExist(req.getEmail());
        if(isEmailExist){
            return "Email Sudah Digunakan";
        }

        Boolean isPhoneNumberExist = mhsRepository.isPhoneNumberExist(req.getPhoneNumber());
        if(isPhoneNumberExist){
            return "Penggunakan Nomor HP Sudah Lebih dari 2";
        }

        try {
            MhsEntity mhsEntity = new MhsEntity();
            mhsEntity.setNim(req.getNim());
            mhsEntity.setName(req.getName());
            mhsEntity.setEmail(req.getEmail());

            return mhsRepository.save(mhsEntity);
        }catch (Exception e){
            return e;
        }
    }
}
