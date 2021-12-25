package org.github.zsun.java.puruantraining.chapter3jpademo.service;

import org.github.zsun.java.puruantraining.chapter3jpademo.model.Stock;
import org.github.zsun.java.puruantraining.chapter3jpademo.repo.StockRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    @Autowired
    private StockRepo stockRepo;

    public List<Stock> findByName(String name) {
        return stockRepo.findByName(name);
    }

    public List<Stock> getAllStock() {
        return stockRepo.findAll();
    }

    //删除库存信息
    public void delete() {
        Stock delStock = stockRepo.getOne(10);
        stockRepo.delete(delStock);
    }

    //根据ID删除库存信息
    public void deleteStockByID(int id) {
        stockRepo.deleteById(id);
    }

    //插入库存信息
    public Stock insertStock() {
        Stock stock = new Stock();
        stock.setID(10);
        stock.setName("machine");
        stock.setNum(5);
        stock.setDescription("Good");
        return stockRepo.save(stock);
    }

    //修改库存信息
    public Stock updateStock() {
        Stock stock = stockRepo.getOne(10);
        stock.setNum(50);
        return stockRepo.save(stock);
    }

    public List<Stock> getStockByDesc(String desc) {
        return stockRepo.getStockByDesc(desc);
    }
}