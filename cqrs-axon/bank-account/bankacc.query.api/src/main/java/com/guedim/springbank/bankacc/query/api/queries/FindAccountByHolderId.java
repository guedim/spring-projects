package com.guedim.springbank.bankacc.query.api.queries;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FindAccountByHolderId {

    private String accountHolderId;
}
