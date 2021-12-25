package org.github.zsun.java.puruantraining.chapter3jpademo.service;

import org.github.zsun.java.puruantraining.chapter3jpademo.model.Stock;
import org.github.zsun.java.puruantraining.chapter3jpademo.repo.StockRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StockForTransService {
    @Autowired
    private StockRepo stockRepo;

    //引入事务修改多条库存信息
    @Transactional(timeout = 20, readOnly = false, isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    public void updateStockOK() {
        Stock stock = stockRepo.getOne(1);
        stock.setNum(25);
        stockRepo.save(stock);
        Stock anotherStock = stockRepo.getOne(1);
        anotherStock.setNum(15);
        stockRepo.save(anotherStock);
    }

    //引入事务修改多条库存信息
    @Transactional(rollbackFor = Exception.class)
    public void updateStockError() {
        Stock stock = stockRepo.getOne(1);
        stock.setNum(35);
        stockRepo.save(stock);
        //故意抛出异常
        String str = null;
        str.toString();
        Stock anotherStock = stockRepo.getOne(1);
        anotherStock.setNum(25);
        stockRepo.save(anotherStock);
    }
}
