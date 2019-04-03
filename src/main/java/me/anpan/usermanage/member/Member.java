package me.anpan.usermanage.member;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(of = "userId")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String userId;
    @NotNull
    private String password;
    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    @Email
    private String email;

    @CreationTimestamp
    private LocalDateTime regdate;

    @UpdateTimestamp
    private LocalDateTime updatedate;

    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="userId")
    private List<MemberRole> roles;

    @Builder
    public Member(@NotNull String userId, @NotNull String password, @NotNull String name, @NotNull String email) {
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.email = email;
    }
}
