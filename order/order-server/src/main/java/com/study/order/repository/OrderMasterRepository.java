package com.study.order.repository;

import com.study.order.dataobject.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: SpringCloudStudy
 * @author: XuYang
 * @create: 2019-07-05 21:28
 **/
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {
}
