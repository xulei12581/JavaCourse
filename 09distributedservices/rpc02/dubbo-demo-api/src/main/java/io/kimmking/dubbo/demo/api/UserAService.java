package io.kimmking.dubbo.demo.api;

import org.dromara.hmily.annotation.Hmily;

public interface UserAService {
    @Hmily
    Boolean transfer(String tid,int customerId,int amount);
}
