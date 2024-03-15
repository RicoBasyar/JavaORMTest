package com.javaorm.javaorm.dto.resbody;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MetaResponse {
    private int code;
    private String status;
    private String message;
}
