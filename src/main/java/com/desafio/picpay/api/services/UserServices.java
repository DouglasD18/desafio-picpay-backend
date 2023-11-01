package com.desafio.picpay.api.services;

import com.desafio.picpay.api.domain.user.User;
import com.desafio.picpay.api.domain.user.UserType;
import com.desafio.picpay.api.dtos.UserDTO;
import com.desafio.picpay.api.models.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    public void validateTransaction(User sender, BigDecimal amount) throws Exception {
        if (sender.getUserType() == UserType.MERCHANT) {
            throw new Exception("Usuário  do tipo lojista não está autorizado a realizar transações.");
        }

        if (sender.getBalance().compareTo(amount) < 0) {
            throw  new Exception("Saldo insuficiente.");
        }
    }

    public User findUserById(Long id) throws Exception {
        return this.userRepository.findUserById(id).orElseThrow(() -> new Exception("Usuário não encontrado."));
    }

    public void saveUser(User user) {
        this.userRepository.save(user);
    }

    public User createUser(UserDTO userDTO) {
        User user = new User(userDTO);
        this.saveUser(user);
        return user;
    }

    public List<User> findAll() {
        return this.userRepository.findAll();
    }

}
