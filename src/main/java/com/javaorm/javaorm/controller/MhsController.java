package com.javaorm.javaorm.controller;

import com.javaorm.javaorm.dto.reqbody.mhs.RegisterReqBody;
import com.javaorm.javaorm.dto.reqbody.mhs.UpdateReqBody;
import com.javaorm.javaorm.dto.resbody.BaseResponse;
import com.javaorm.javaorm.service.MhsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

@RestController
public class MhsController {

    @Autowired
    private MhsService service;

    @PostMapping("/register")
    public @ResponseBody ResponseEntity<BaseResponse<?>> register (@Validated @RequestBody RegisterReqBody req){
        try{
            Object mhs = service.Register(req);
            return ResponseEntity.ok(new BaseResponse<>(null, mhs));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new BaseResponse<>(null, "Registration failed: " + e.getMessage()));
        }
    }
//
    @GetMapping("user/{email}")
    public @ResponseBody ResponseEntity<BaseResponse<?>> getData(@PathVariable String email){
        Object getData = service.getMhsDataByEmail(email);
        return ResponseEntity.ok(new BaseResponse<>(null, getData));
    }

    @DeleteMapping("user/delete/{nim}")
    public @ResponseBody ResponseEntity<BaseResponse<?>> deleteData(@PathVariable @RequestBody String nim){
        try{
            Object deleteData = service.Delete(nim);
            return ResponseEntity.ok(new BaseResponse<>(null, deleteData));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new BaseResponse<>(null, "Delete data error" + e.getMessage()));
        }
    }

    @PutMapping("user/update/{nim}")
    public @ResponseBody ResponseEntity<BaseResponse<?>> updateData(@Validated @PathVariable String nim, @RequestBody UpdateReqBody req){
        try{
            Object updateData = service.update(nim, req);
            return ResponseEntity.ok(new BaseResponse<>(null,updateData));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new BaseResponse<>(null, e.getMessage()));
        }
    }
}
