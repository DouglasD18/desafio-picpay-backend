package com.desafio.picpay.api.dtos;

import com.desafio.picpay.api.domain.user.UserType;

import java.math.BigDecimal;

public record UserDTO(String completeName, String password, String email, String document, BigDecimal balance, UserType userType) {
}
