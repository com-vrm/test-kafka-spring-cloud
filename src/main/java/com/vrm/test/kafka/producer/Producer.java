package com.vrm.test.kafka.producer;

/**
 * @author taaviv @ 09.05.22
 */
public interface Producer<T> {

    void produce(T t);

}
