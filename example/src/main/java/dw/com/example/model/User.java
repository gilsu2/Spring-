package dw.com.example.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="사용자")
public class User {

    @Id
    @Column(name="user_name",nullable = false, unique = true)
    private String userName;

    @Column(name="password" ,nullable = false)
    private String password;

    @Column(name="email", nullable = false, unique = true)
    private String email;

    @ManyToOne
    @JoinColumn(name = "user_authority")
    private Authority authority;

}