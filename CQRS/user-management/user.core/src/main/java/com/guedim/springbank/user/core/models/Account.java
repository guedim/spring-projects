package com.guedim.springbank.user.core.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {

    @Size(min = 2, message = "username must have a minimum of 2 characters")
    private String userName;
    @Size(min = 7, message = "password must have a minimum of 7 characters")
    private String password;
    @NotNull(message = "specify at lease 1 user role")
    private List<Role> roles;
}
