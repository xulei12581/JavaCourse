package geektime.spring.data.multidatasourcedemo.commodity.service.impl;


import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import geektime.spring.data.multidatasourcedemo.commodity.mapper.JkOrderMapper;
import geektime.spring.data.multidatasourcedemo.commodity.service.JkOrderService;
import geektime.spring.data.multidatasourcedemo.model.JkOrderInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xulei
 * @name JkOrderServiceImpl
 * @date 2021-11-07
 **/
@Service("jkOrderServiceImpl")
public class JkOrderServiceImpl extends ServiceImpl<JkOrderMapper, JkOrderInfo> implements JkOrderService {

    @Resource(name = "jkOrderMapper")
    private JkOrderMapper jkOrderMapper;

    @DS("slave0")
    @Override
    public List<JkOrderInfo> getJkOrderList() throws Exception {
        return jkOrderMapper.selectList(null);
    }

    @DS("master")
    @Override
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.REPEATABLE_READ)
    public Integer insertJkOrder(JkOrderInfo tbCommodityInfo) throws Exception {
        return jkOrderMapper.insert(tbCommodityInfo);
    }

}
