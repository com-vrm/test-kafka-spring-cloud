package com.vrm.test.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;

/**
 * @author taaviv @ 09.05.22
 */
public interface Consumer<T> {

    void consume(ConsumerRecord<String, T> record);

}
