package org.github.zsun.java.puruantraining.chapter3jpademo.controller;

import org.github.zsun.java.puruantraining.chapter3jpademo.model.Stock;
import org.github.zsun.java.puruantraining.chapter3jpademo.service.StockForTransService;
import org.github.zsun.java.puruantraining.chapter3jpademo.service.StockPagingAndSortingService;
import org.github.zsun.java.puruantraining.chapter3jpademo.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/chapter3")
public class StockController {
    @Autowired
    StockService stockService;
    @Autowired
    private StockPagingAndSortingService stockPagingAndSortingService;
    @Autowired
    StockForTransService stockForTransService;

    @RequestMapping("/getStockByName/{name}")
    public List<Stock> getStockByName(@PathVariable String name) throws Exception{
        if ("null".equals(name) || "error".equals(name)) {
            throw new Exception("Param is error");
        }
        List<Stock> stocks = stockService.findByName(name);
        if (stocks.size() == 0) {
            throw new Exception("No stock");
        }
        return stocks;
    }

    @RequestMapping("/getAllStocks")
    public List<Stock> getAllStocks() {
        return stockService.getAllStock();
    }

    @RequestMapping("/deleteStock")
    public void deleteStock() {
        stockService.delete();
    }

    @RequestMapping("/deleteStockByID/{ID}")
    public void deleteStockByID(@PathVariable String ID) {
        stockService.deleteStockByID(Integer.valueOf(ID));
    }

    @RequestMapping("/insertStock")
    public Stock insertStock() {
        return stockService.insertStock();
    }

    //修改库存信息
    @RequestMapping("/updateStock")
    Stock updateStock() {
        return stockService.updateStock();
    }

    @RequestMapping("/sortByName")
    List<Stock> sortByName() {
        return stockPagingAndSortingService.sortByName();
    }

    @RequestMapping("/splitPage")
    List<Stock> splitPage() {
        return stockPagingAndSortingService.splitPage();
    }

    @RequestMapping("/getStockByDesc/{desc}")
    List<Stock> getStockByDesc(@PathVariable String desc) {
        return stockService.getStockByDesc(desc);
    }

    @RequestMapping("/transOK")
    void transOK() {
        stockForTransService.updateStockOK();
    }

    @RequestMapping("/transError")
    void transError() {
        stockForTransService.updateStockError();
    }
}
