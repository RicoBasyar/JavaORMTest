package com.javaorm.javaorm.dto.reqbody.mhs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateReqBody {
    private String email;
    private String nama_mhs;
}
