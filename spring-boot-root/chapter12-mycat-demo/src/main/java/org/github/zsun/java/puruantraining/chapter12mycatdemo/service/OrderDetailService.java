package org.github.zsun.java.puruantraining.chapter12mycatdemo.service;

import org.github.zsun.java.puruantraining.chapter12mycatdemo.model.OrderDetail;
import org.github.zsun.java.puruantraining.chapter12mycatdemo.repo.OrderDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailService {
    @Autowired
    private OrderDetailRepo orderDetailRepo;

    public void saveStudent(OrderDetail orderDetail) {
        orderDetailRepo.save(orderDetail);
    }

    public OrderDetail findById(int id) {
        return orderDetailRepo.findOrderdetailById(id);
    }

    public void deleteById(int id) {
        orderDetailRepo.deleteById(id);
    }
}
