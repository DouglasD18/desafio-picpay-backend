package com.desafio.picpay.api.services;

import com.desafio.picpay.api.domain.transaction.Transaction;
import com.desafio.picpay.api.domain.user.User;
import com.desafio.picpay.api.dtos.TransactionDTO;
import com.desafio.picpay.api.models.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserServices userServices;

    public Transaction createTransaction(TransactionDTO transaction) throws Exception {
        User sender = this.userServices.findUserById(transaction.senderId());
        User receiver = this.userServices.findUserById(transaction.receiverId());

        this.userServices.validateTransaction(sender, transaction.amount());

        Transaction newTransaction = new Transaction();
        newTransaction.setAmount(transaction.amount());
        newTransaction.setSender(sender);
        newTransaction.setReceiver(receiver);
        newTransaction.setTimeStamp(LocalDateTime.now());

        updateReceiver(receiver, transaction.amount());
        updateSender(sender, transaction.amount());

        return this.transactionRepository.save(newTransaction);
    }

    public void updateSender(User sender, BigDecimal amount) {
        sender.setBalance(sender.getBalance().subtract(amount));

        this.userServices.saveUser(sender);
    }

    public void updateReceiver(User receiver, BigDecimal amount) {
        receiver.setBalance(receiver.getBalance().add(amount));

        this.userServices.saveUser(receiver);
    }

}
