package org.wintaye.org.payroll.models.datamodels;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wintaye.org.payroll.models.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {


}
