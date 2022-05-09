package com.vrm.test.kafka.controller;

import com.vrm.test.kafka.dto.Stock;
import com.vrm.test.kafka.producer.StockProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author taaviv @ 09.05.22
 */
@RestController
@RequiredArgsConstructor
public class StockController {

    private final StockProducer stockProducer;

    @RequestMapping("stock/add/{symbol}/{price}")
    public void addStock(@PathVariable String symbol, @PathVariable double price) {
        Stock stock = new Stock(symbol, price);
        stockProducer.produce(stock);
    }

}
