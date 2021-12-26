package org.github.zsun.java.puruantraining.chapter3jpademo.controller;

import org.github.zsun.java.puruantraining.chapter3jpademo.Chapter3JpaDemoApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Locale;

import static org.junit.Assert.assertTrue;

@SpringBootTest(classes = Chapter3JpaDemoApplication.class)
@RunWith(value = SpringRunner.class)
@AutoConfigureMockMvc
public class StockControllerTest {
    @Autowired
    private MockMvc mvc;

    @Before
    public void init() {
        System.out.println("Before testing");
    }

    @Test
    public void testControllerOK() throws Exception {
        System.out.println("Test controller");
        mvc.perform(MockMvcRequestBuilders.get("/chapter3/getAllStocks"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
    }

    @Test
    public void testControllerParamError() throws Exception {
        System.out.println("Test Controller with Param Error");
        try {
            mvc.perform(MockMvcRequestBuilders.get("/chapter3/getStockByName/error"))
                    .andExpect(MockMvcResultMatchers.status().is5xxServerError())
                    .andReturn();
        } catch (Exception e) {
            assertTrue(e.getMessage().toLowerCase().contains("param is error"));
        }
    }

    @Test
    public void testControllerResultError() throws Exception {
        System.out.println("Test Controller with Result Error");
        try {
            mvc.perform(MockMvcRequestBuilders.get("/chapter3/getStockByName/empty"))
                    .andExpect(MockMvcResultMatchers.status().is5xxServerError())
                    .andReturn();
        }catch (Exception e){
            assertTrue(e.getMessage().toLowerCase().contains("no stock"));
        }
    }
}
