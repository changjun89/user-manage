package me.anpan.usermanage.member;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@Entity
@NoArgsConstructor
public class Member {

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
    public Member(@NotNull String userId, @NotNull String password, @NotNull String name, @NotNull String email) {
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.email = email;
    }
}
