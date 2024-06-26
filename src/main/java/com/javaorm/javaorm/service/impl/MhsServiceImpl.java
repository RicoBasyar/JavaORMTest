package com.javaorm.javaorm.service.impl;

import com.javaorm.javaorm.dto.reqbody.mhs.RegisterBulkReqBody;
import com.javaorm.javaorm.dto.reqbody.mhs.RegisterReqBody;
import com.javaorm.javaorm.dto.reqbody.mhs.UpdateReqBody;
import com.javaorm.javaorm.entity.MhsEntity;
import com.javaorm.javaorm.repository.MhsRepository;
import com.javaorm.javaorm.service.MhsService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public Object getUsers(int pageNo, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
        return mhsRepository.findAll(pageRequest);
    }

    @Override
    public List<MhsEntity> getUsersNameOnly(int pageNo, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
        Page<MhsEntity> pagingMhs = mhsRepository.findUsersNameOnly(pageRequest);
        return pagingMhs.getContent();
    }

    @Override
    public List<MhsEntity> getAllEmailsOnly(int pageNo, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
        Page <MhsEntity> pagingEmail = mhsRepository.findDataEmailsOnly(pageRequest);
        return pagingEmail.getContent();
    }

    @Override
    public Object RegisterBulk(RegisterBulkReqBody req) {
        List<MhsEntity> listMhsEntity = new ArrayList<>();
        for (int i = 0; i < req.getList().size(); i++) {
            boolean isNimExist = mhsRepository.isNimExist(req.getList().get(i).getNim());
            if(isNimExist){
                return "NIM Sudah Digunakan";
            }

            Boolean isEmailExist = mhsRepository.isEmailExist(req.getList().get(i).getEmail());
            if(isEmailExist){
                return "Email Sudah Digunakan";
            }

            Boolean isPhoneNumberExist = mhsRepository.isPhoneNumberExist(req.getList().get(i).getNo_hp());
            if(isPhoneNumberExist){
                return "Nomor HP Sudah Lebih dari 2";
            }
            MhsEntity mhsEntity = new MhsEntity();

            mhsEntity.setNim(req.getList().get(i).getNim());
            mhsEntity.setNama_mhs(req.getList().get(i).getNama_mhs());
            mhsEntity.setEmail(req.getList().get(i).getEmail());
            mhsEntity.setNo_hp(req.getList().get(i).getNo_hp());

            listMhsEntity.add(mhsEntity);
        }

        try {
            return mhsRepository.saveAll(listMhsEntity);
        }catch (Exception e){
            return e;
        }
    }

    @Override
    public Object Delete(String nim){
        return mhsRepository.deleteByNim(nim);
    }

    // Keknya bisa disederhanain
    @Override
    public Object update(String nim, UpdateReqBody req){
        MhsEntity mhsEntity = mhsRepository.getNim(nim);

        if(mhsEntity == null){
            return "Data Tidak ada";
        }
        if(mhsEntity.getEmail().equals(req.getEmail())){
            return "Email sudah digunakan";
        }
        if(mhsEntity.getNama_mhs().equals(req.getNama_mhs())){
            return "Nama sudah digunakan";
        }

        if(req.getNama_mhs() == null){
            mhsEntity.setNama_mhs(mhsEntity.getNama_mhs());
            mhsEntity.setEmail(req.getEmail());
        }

        if(req.getEmail() == null){
            mhsEntity.setEmail(mhsEntity.getEmail());
            mhsEntity.setNama_mhs(req.getNama_mhs());
        }

        return mhsRepository.save(mhsEntity);
    }
}
