package geektime.spring.data.multidatasourcedemo.commodity.controller;


import geektime.spring.data.multidatasourcedemo.commodity.service.JkOrderService;
import geektime.spring.data.multidatasourcedemo.model.JkOrderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author xulei
 * @name JkOrderServiceImpl
 * @date 2021-11-07
 **/
@RestController
@RequestMapping("/jkOrder")
public class JkOrderController {

    @Autowired
    private JkOrderService jkOrderService;

    @RequestMapping("/list")
    public List<JkOrderInfo> getCommodityInfoList() throws Exception {
        return jkOrderService.getJkOrderList();
    }

    @PostMapping("/insert")
    public Integer insertCommodityInfo(JkOrderInfo jkOrderInfo) throws Exception {
        return jkOrderService.insertJkOrder(jkOrderInfo);
    }


}
