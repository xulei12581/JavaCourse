package dao;

public interface CancelLogDao {
    boolean isExist(String tid);

    void addCancel(String tid);
}
