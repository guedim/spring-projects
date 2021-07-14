package com.guedim.springbank.user.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class BaseResponse {

    private String message;
}
