package com.guedim.springbank.bankacc.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class BankAccount {

    @Id
    private String id;
    private String accountHolderId;
    private Date creationDate;
    private AccountType accountType;
    private double balance;

}
