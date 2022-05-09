package com.vrm.test.kafka.producer;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * @author taaviv @ 09.05.22
 */
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class AbstractProducer<K, V> implements Producer<V> {

    protected final String topic;
    protected final KafkaTemplate<K, V> template;
    protected final KeyFactory<K> keyFactory;

    @Override

    public void produce(V v) {
        template.send(topic, keyFactory.nextKey(), v);
    }

}
