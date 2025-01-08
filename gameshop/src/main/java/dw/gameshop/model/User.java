package dw.gameshop.model;

import dw.gameshop.dto.UserDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Entity
@Table(name="user")
public class User {
    @Id
    @Column(name="user_name")
    private String userName;
    @Column(name="password", nullable = false)
    private String password;
    @Column(name="email", nullable = false, unique = true)
    private String email;
    @Column(name = "real_name", nullable = false)
    private String realName;
    @ManyToOne
    @JoinColumn(name = "user_authority")
    private Authority authority;
    @Column(name="created_at", updatable = false)
    private LocalDateTime createdAt;

    public UserDTO toDto() {
        return new UserDTO(
                this.userName,
                null,
                this.email,
                this.realName,
                authority.getAuthorityName()
        );
    }
}
<<<<<<< HEAD
=======

>>>>>>> ca9ad7b6587b6d52c32c4ece4b7f22cc7f5258a5
