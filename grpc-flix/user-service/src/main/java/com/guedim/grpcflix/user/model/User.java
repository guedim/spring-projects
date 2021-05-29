package com.guedim.grpcflix.user.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@ToString
public class User {

    @Id
    private String login;
    private String name;
    private String genre;
}
