package com.javaorm.javaorm.service.impl;

import com.javaorm.javaorm.dto.reqbody.Employe.RegisterReqBody;
import com.javaorm.javaorm.entity.EmployeEntity;
import com.javaorm.javaorm.repository.EmployeRepository;
import com.javaorm.javaorm.service.EmployeService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EmployeServiceImpl implements EmployeService {

    @Autowired
    private EmployeRepository repository;

    @Override
    public EmployeEntity getEmployeByName(String employe_name){
        return repository.getEmployeByName(employe_name).orElse(null);
    }

    @Override
    public Object register(RegisterReqBody req){
        boolean isNameExist = repository.isNameExist(req.getEmploye_name());

        if(isNameExist){
            return "Nama Sudah Digunakan";
        }

        boolean isEmailExist = repository.isEmailExist(req.getEmail());

        if(isEmailExist){
            return "Email Sudah Digunakan";
        }

        boolean isPhoneExist = repository.isPhoneExist(req.getPhone());

        if(isPhoneExist){
            return "No.Telp Sudah Digunakan";
        }

        try{
            EmployeEntity employe = new EmployeEntity();
            employe.setEmploye_name(req.getEmploye_name());
            employe.setEmail(req.getEmail());
            employe.setPhone(req.getPhone());
            return  repository.save(employe);
        }catch (Exception e){
            return e;
        }
    }


}
