package com.desafio.picpay.api.domain.user;

import com.desafio.picpay.api.dtos.UserDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity(name="users")
@Table(name="users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String completeName, password;

    @Column(unique = true, nullable = false)
    private String email, document;
    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    public User(UserDTO userDTO) {
        this.completeName = userDTO.completeName();
        this.password = userDTO.password();
        this.email = userDTO.email();
        this.document = userDTO.document();
        this.balance = userDTO.balance();
        this.userType = userDTO.userType();
    }
}
