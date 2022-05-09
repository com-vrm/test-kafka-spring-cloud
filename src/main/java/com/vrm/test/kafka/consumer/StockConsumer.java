package com.vrm.test.kafka.consumer;

import com.vrm.test.kafka.dto.Stock;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author taaviv @ 05.05.22
 */
@Component
@Slf4j
public class StockConsumer implements Consumer<Stock> {

    @Override
    @KafkaListener(topics = "${testapp.kafka.topic.stock.name}")
    public void consume(ConsumerRecord<String, Stock> record) {
        log.info("Consumed: {}", record.value());
    }

}
