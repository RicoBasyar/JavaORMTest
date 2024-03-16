package com.javaorm.javaorm.service;

import com.javaorm.javaorm.dto.reqbody.RegisterReqBody;
import com.javaorm.javaorm.entity.MhsEntity;

public interface MhsService {

    Object Register(RegisterReqBody req);
    Object Delete(String nim);
    MhsEntity getMhsDataByEmail(String email);
}
