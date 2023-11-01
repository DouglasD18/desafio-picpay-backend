package com.desafio.picpay.api.domain.user;

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
}
