package com.javaorm.javaorm.dto.reqbody.Employe;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterReqBody {
    private String employe_name;
    private String email;
    private String phone;
}
