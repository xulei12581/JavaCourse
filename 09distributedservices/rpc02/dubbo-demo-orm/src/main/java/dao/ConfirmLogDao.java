package dao;

public interface ConfirmLogDao {
    boolean isExist(String tid);

    void addConfirm(String tid);
}
