package org.github.zsun.java.puruantraining.chapter12mycatdemo.repo;

import org.github.zsun.java.puruantraining.chapter12mycatdemo.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepo extends JpaRepository<OrderDetail, Integer> {

    public OrderDetail findOrderdetailById(int id);
}

