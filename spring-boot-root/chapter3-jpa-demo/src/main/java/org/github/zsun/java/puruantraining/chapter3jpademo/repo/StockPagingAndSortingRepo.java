package org.github.zsun.java.puruantraining.chapter3jpademo.repo;

import org.github.zsun.java.puruantraining.chapter3jpademo.model.Stock;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

@Component
public interface StockPagingAndSortingRepo extends PagingAndSortingRepository<Stock, Integer> {

}
