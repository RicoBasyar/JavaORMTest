package com.javaorm.javaorm.service;

import com.javaorm.javaorm.dto.reqbody.mhs.RegisterBulkReqBody;
import com.javaorm.javaorm.dto.reqbody.mhs.RegisterReqBody;
import com.javaorm.javaorm.dto.reqbody.mhs.UpdateReqBody;
import com.javaorm.javaorm.entity.MhsEntity;

public interface MhsService {

    Object Register(RegisterReqBody req);
    Object getUsers();

    Object RegisterBulk(RegisterBulkReqBody req);
    Object Delete(String nim);
    MhsEntity getMhsDataByEmail(String email);

    Object update(String nim, UpdateReqBody req);
}
