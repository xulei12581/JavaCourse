package io.kimmking.dubbo.demo.consumer.controller;

import io.kimmking.dubbo.demo.api.BankAccountService;
import io.kimmking.dubbo.demo.api.UserAService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserAServiceImpl implements UserAService {

    @Autowired
    BankAccountService bankAccountService;

    @Override
    public Boolean transfer(String tid,int customerId, int amount) {
        this.bankAccountService.subtractAccountBalance(tid,customerId,amount);
        return true;
    }
}
