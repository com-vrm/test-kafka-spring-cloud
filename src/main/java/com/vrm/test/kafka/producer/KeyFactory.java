package com.vrm.test.kafka.producer;

/**
 * @author taaviv @ 09.05.22
 */
public interface KeyFactory<T> {

    T nextKey();

}
