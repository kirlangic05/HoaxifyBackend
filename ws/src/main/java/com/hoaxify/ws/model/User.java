package com.hoaxify.ws.model;

import com.hoaxify.ws.unique.UniqueUsername;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private long Id;

    @NotNull(message = "{hoaxify.constraint.username.NotNull.message}")
    @Size(min = 4, max = 255)
    @UniqueUsername
    private String username;
    @NotNull(message = "{hoaxify.constraint.password.NotNull.message}")
    @Size(min = 4, max = 255)
    private String displayName;
    @NotNull
    @Size(min = 8, max = 255)
    @Pattern(regexp="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message = "{hoaxify.constraint.password.Pattern.message}")
    private String password;
}
