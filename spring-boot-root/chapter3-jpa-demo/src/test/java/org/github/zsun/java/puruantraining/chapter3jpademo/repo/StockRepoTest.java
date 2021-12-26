package org.github.zsun.java.puruantraining.chapter3jpademo.repo;

import org.github.zsun.java.puruantraining.chapter3jpademo.Chapter3JpaDemoApplication;
import org.github.zsun.java.puruantraining.chapter3jpademo.model.Stock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = Chapter3JpaDemoApplication.class)
@RunWith(value = SpringRunner.class)
public class StockRepoTest {
    @Autowired
    private StockRepo stockRepo;

    @Test
    public void testOk() throws Exception {
        Stock stock = new Stock();

    }
}
