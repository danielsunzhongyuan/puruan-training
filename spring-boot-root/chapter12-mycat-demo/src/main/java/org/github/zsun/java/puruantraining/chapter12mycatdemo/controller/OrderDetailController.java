package org.github.zsun.java.puruantraining.chapter12mycatdemo.controller;

import org.github.zsun.java.puruantraining.chapter12mycatdemo.model.OrderDetail;
import org.github.zsun.java.puruantraining.chapter12mycatdemo.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chapter12")
public class OrderDetailController {
    @Autowired
    OrderDetailService orderDetailService;

    @RequestMapping("/save")
    public void save(@RequestParam(name = "id") long id,
                     @RequestParam(name = "name") String name) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setId(id);
        orderDetail.setName(name);
        orderDetailService.saveStudent(orderDetail);
    }

    @RequestMapping("/findById/{id}")
    public OrderDetail findById(@PathVariable long id) {
        return orderDetailService.findById(id);
    }

    @RequestMapping("/deleteById/{id}")
    public void deleteById(@PathVariable long id) {
        orderDetailService.deleteById(id);
    }
}
