package io.kimmking.dubbo.demo.provider.controller;

import io.kimmking.dubbo.demo.api.BankAccountService;
import io.kimmking.dubbo.demo.api.UserBService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserBServiceImpl implements UserBService {
    @Autowired
    BankAccountService bankAccountService;

    @Override
    public Boolean transfer(String tid,int customerId, int amount) {
        this.bankAccountService.addAccountBalance(tid,customerId,amount);
        return true;
    }
}
