package io.kimmking.dubbo.demo.api;

import org.dromara.hmily.annotation.Hmily;

public interface UserBService {
    @Hmily
    Boolean transfer(String tid,int customerId,int amount);
}
