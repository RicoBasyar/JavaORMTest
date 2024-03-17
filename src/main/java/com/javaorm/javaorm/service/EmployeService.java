package com.javaorm.javaorm.service;

import com.javaorm.javaorm.dto.reqbody.Employe.RegisterReqBody;
import com.javaorm.javaorm.entity.EmployeEntity;

public interface EmployeService {
    EmployeEntity getEmployeByName(String employe_name);

    Object register(RegisterReqBody req);
}
