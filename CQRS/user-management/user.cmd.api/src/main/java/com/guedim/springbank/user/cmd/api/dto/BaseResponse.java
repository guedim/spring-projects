package com.guedim.springbank.user.cmd.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class BaseResponse {

    private String message;
}
