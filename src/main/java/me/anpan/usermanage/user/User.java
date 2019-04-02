package me.anpan.usermanage.user;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String userId;
    @NotNull
    private String password;
    @NotNull
    private String name;
    @NotNull
    private String email;

    @Builder
    public User(@NotNull String userId, @NotNull String password, @NotNull String name, @NotNull String email) {
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.email = email;
    }
}
