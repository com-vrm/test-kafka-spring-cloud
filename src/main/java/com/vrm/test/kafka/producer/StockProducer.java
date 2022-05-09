package com.vrm.test.kafka.producer;

import com.vrm.test.kafka.dto.Stock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @author taaviv @ 05.05.22
 */
@Component
@Slf4j
public class StockProducer extends AbstractProducer<String, Stock> {

    public StockProducer(@Value("${testapp.kafka.topic.stock.name}") String topic,
                         @Autowired KafkaTemplate<String, Stock> template,
                         @Autowired IntToStringKeyFactory keyFactory) {
        super(topic, template, keyFactory);
    }

}
