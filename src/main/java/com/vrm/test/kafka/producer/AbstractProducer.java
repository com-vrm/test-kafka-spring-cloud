package com.vrm.test.kafka.producer;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;

/**
 * @author taaviv @ 09.05.22
 */
@Slf4j
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class AbstractProducer<K, V> implements Producer<V> {

    protected final String topic;
    protected final KafkaTemplate<K, V> template;
    protected final KeyFactory<K> keyFactory;

    @Override

    public void produce(V v) {
        ListenableFuture<SendResult<K, V>> future = template.send(topic, keyFactory.nextKey(), v);
        future.addCallback(
                result -> log.info("Message was consumed: {}", result),
                ex -> log.error("Message wes not consumed", ex));
    }

}
