package geektime.spring.data.multidatasourcedemo.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

/**
 * @author xulei
 * @name TbCommodityInfo
 * @date 2021-11-07
 **/
@Data
@TableName("jike_order")
public class JkOrderInfo implements Serializable {

    private static final long serialVersionUID = -395630902236009334L;

    @TableId("order_id")
    private Long orderId;

    @Column(name = "bundle_name")
    private String commodityName;

    @Column(name = "product_count")
    private Integer productCount;

    @Column(name = "order_status")
    private Integer orderStatus;

    @Column(name = "del_flag")
    private Integer delFlag;

    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "supplier_id")
    private Long supplierId;

    @Column(name = "create_user_id")
    private Long createUserId;

    @Column(name = "modify_user_id")
    private Long modifyUserId;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

}
