package org.github.zsun.java.puruantraining.chapter3jpademo.service;


import org.github.zsun.java.puruantraining.chapter3jpademo.model.Stock;
import org.github.zsun.java.puruantraining.chapter3jpademo.repo.StockPagingAndSortingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockPagingAndSortingService {

    @Autowired
    private StockPagingAndSortingRepo stockPagingAndSortingRepo;

    //实现排序功能
    public List<Stock> sortByName() {
        Sort sort = Sort.by(Sort.Direction.DESC, "name");
        return (List<Stock>) stockPagingAndSortingRepo.findAll(sort);
    }

    //实现分页功能
    public List<Stock> splitPage() {
        //从第0条开始，展示3条数据
        Pageable pageable = PageRequest.of(0, 3);
        Page<Stock> list = stockPagingAndSortingRepo.findAll(pageable);
        return list.getContent();
    }

}