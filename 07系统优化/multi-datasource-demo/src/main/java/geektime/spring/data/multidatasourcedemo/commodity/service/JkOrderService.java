package geektime.spring.data.multidatasourcedemo.commodity.service;

import com.baomidou.mybatisplus.extension.service.IService;
import geektime.spring.data.multidatasourcedemo.model.JkOrderInfo;

import java.util.List;
/**
 * @author xulei
 * @name JkOrderService
 * @date 2021-11-07
 **/
public interface JkOrderService extends IService<JkOrderInfo> {

    /**
     * 查询所有订单
     *
     * @return List<JkOrderInfo>
     */
    List<JkOrderInfo> getJkOrderList() throws Exception;

    /**
     * 新增订单
     *
     * @param jkOrderInfo  订单
     * @return boolean
     */
    Integer insertJkOrder(JkOrderInfo jkOrderInfo) throws Exception;

}
