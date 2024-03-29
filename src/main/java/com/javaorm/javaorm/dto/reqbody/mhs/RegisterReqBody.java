package com.javaorm.javaorm.dto.reqbody.mhs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterReqBody {
    private String email;
    private int no_hp;
    private String nama_mhs;
    private String nim;
}
