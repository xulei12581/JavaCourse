package geektime.spring.data.multidatasourcedemo.commodity.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import geektime.spring.data.multidatasourcedemo.model.JkOrderInfo;
import org.springframework.stereotype.Repository;

/**
 * @author xulei
 * @name JkOrderMapper
 * @date 2021-11-07
 **/
@Repository("jkOrderMapper")
public interface JkOrderMapper extends BaseMapper<JkOrderInfo> {

}
