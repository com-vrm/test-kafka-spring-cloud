package com.vrm.test.kafka.producer;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * @author taaviv @ 09.05.22
 */
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class AbstractProducer<T> implements Producer<T> {

    protected final String topic;
    protected final KafkaTemplate<String, T> template;

    @Override
    public void produce(T t) {
        template.send(topic, t);
    }

}
