package dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BankAccountDao {
    void addAccountBalance(int customerId, int i, int amount);

    boolean subtractAccountBalance(int customerId, int i, int amount);
}
