package com.javaorm.javaorm.dto.reqbody;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterReqBody {
    private String email;
    private int phoneNumber;
    private String name;
    private String nim;
}
