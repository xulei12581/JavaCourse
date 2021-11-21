package dao;

public interface TryLogDao {
    boolean isExist(String tid);

    void addTry(String tid);
}
