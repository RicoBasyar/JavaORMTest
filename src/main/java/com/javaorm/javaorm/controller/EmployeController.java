package com.javaorm.javaorm.controller;

import com.javaorm.javaorm.dto.reqbody.Employe.RegisterReqBody;
import com.javaorm.javaorm.dto.resbody.BaseResponse;
import com.javaorm.javaorm.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeController {
    @Autowired
    private EmployeService employeService;

    @PostMapping("/employe/register")
    public @ResponseBody ResponseEntity<BaseResponse<?>> register(@Validated @RequestBody RegisterReqBody req){
        try{
            Object registerEmploye = employeService.register(req);
            return ResponseEntity.ok(new BaseResponse<>(null, registerEmploye));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new BaseResponse<>(null, "registration failed" + e.getMessage()));
        }
    }

    @GetMapping("/employe/{name}")
    public @ResponseBody ResponseEntity<BaseResponse<?>> getbyName(@PathVariable String name){
        try {
            Object getByName = employeService.getEmployeByName(name);
            return ResponseEntity.ok(new BaseResponse<>(null, getByName));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new BaseResponse<>(null, e.getMessage()));
        }
    }
}
