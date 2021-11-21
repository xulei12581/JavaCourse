package dao;

public interface BankFreezeDao {
    void subtractFreezeAmount(int customerId, int i, int amount);
}
