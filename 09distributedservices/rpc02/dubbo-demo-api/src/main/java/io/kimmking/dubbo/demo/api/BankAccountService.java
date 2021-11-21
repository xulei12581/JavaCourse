package io.kimmking.dubbo.demo.api;

public interface BankAccountService {
    public void addAccountBalance(String tid,int customerId, int amount);

    public void subtractAccountBalance(String tid, int customerId, int amount);
}
