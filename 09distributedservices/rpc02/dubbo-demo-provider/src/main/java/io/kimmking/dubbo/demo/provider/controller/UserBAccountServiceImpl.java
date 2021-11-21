package io.kimmking.dubbo.demo.provider.controller;

import dao.BankAccountDao;
import dao.CancelLogDao;
import dao.ConfirmLogDao;
import dao.TryLogDao;
import entity.BankAccount;
import entity.CancelLog;
import entity.ConfirmLog;
import entity.TryLog;
import io.kimmking.dubbo.demo.api.BankAccountService;
import lombok.extern.slf4j.Slf4j;
import org.dromara.hmily.annotation.HmilyTCC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Slf4j
public class UserBAccountServiceImpl implements BankAccountService {


    @Autowired
    BankAccountDao bankAccountDao;

    @Autowired
    TryLogDao tryLogDao;

    @Autowired
    ConfirmLogDao confirmLogDao;

    @Autowired
    CancelLogDao cancelLogDao;

    @Override
    public void subtractAccountBalance(String tid,int customerId, int amount) {

    }

    @Override
    @HmilyTCC(confirmMethod = "confirm", cancelMethod = "cancel")
    public void addAccountBalance(String tid,int customerId, int amount) {
        log.info("bank2 addAccountBalance try begin ... tid is {} customerId is {} amount is {} ！！！", tid, customerId, amount);
        //幂等校验
        if(!tryLogDao.isExist(tid)) {
            tryLogDao.addTry(tid);
        }
        log.info("bank2 addAccountBalance try end ... tid is {} customerId is {} amount is {} ！！！", tid, customerId, amount);

    }


    @Transactional(rollbackFor = Exception.class)
    public boolean confirm(String tid,int customerId, int amount) {
        log.info("bank2 confirm begin ... tid is {} customerId is {} amount is {} ！！！", tid, customerId, amount);
        //幂等校验 且try执行完成
        if(!confirmLogDao.isExist(tid)){
            if(tryLogDao.isExist(tid)) {
                bankAccountDao.addAccountBalance(customerId, 1, amount);
                log.info("账户 {} 收款金额 {} 成功！！！", customerId, amount);
                confirmLogDao.addConfirm(tid);
            }
        }
        log.info("bank2 confirm end ... tid is {} customerId is {} amount is {} ！！！", tid, customerId, amount);
        return Boolean.TRUE;
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean cancel(String tid,int customerId, int amount) {
        log.info("bank2 cancel begin ... tid is {} customerId is {} amount is {} ！！！", tid, customerId, amount);
        //幂等校验 且try执行完毕
        if(!cancelLogDao.isExist(tid)){
            if(tryLogDao.isExist(tid)) {
                bankAccountDao.subtractAccountBalance(customerId, 1, amount);
                cancelLogDao.addCancel(tid);
            }
        }

        log.info("bank2 cancel end ... tid is {} customerId is {} amount is {} ！！！", tid, customerId, amount);
        return Boolean.TRUE;
    }

}
