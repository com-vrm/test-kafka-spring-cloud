package com.vrm.test.kafka.producer;

import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author taaviv @ 09.05.22
 */
@Component
public class IntToStringKeyFactory implements KeyFactory<String> {

    private final AtomicLong counter = new AtomicLong();

    @Override
    public String nextKey() {
        return String.valueOf(counter.getAndIncrement());
    }

}
