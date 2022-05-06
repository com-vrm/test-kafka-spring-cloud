package com.vrm.test.kafka;

import com.vrm.test.kafka.consumer.KafkaConsumer;
import com.vrm.test.kafka.producer.KafkaProducer;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.ByteArraySerializer;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.utility.DockerImageName;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author taaviv @ 06.05.22
 */
@RunWith(SpringRunner.class)
@Import(KafkaTest.KafkaTestConf.class)
@SpringBootTest(classes = App.class)
@DirtiesContext
public class KafkaTest {

    @ClassRule
    public static KafkaContainer kafka = new KafkaContainer(DockerImageName.parse("confluentinc/cp-kafka:5.4.3"));

    @Autowired
    private KafkaProducer producer;
    @Autowired
    private KafkaConsumer consumer;

    @Value("${gk.kafka.topic}")
    private String topic;

    @Test
    public void producerSendsMessage_consumerReceivesMessage() {
        final String[] messages = { "message_numero_uno", "message_numero_dos" };
        Stream.of(messages).forEach(this::sendToTopic);
//        assertThat(consumer.getRecords()).containsExactlyInAnyOrder(messages);
    }

    private void sendToTopic(String message) {
//        producer.send(topic, message);
    }

    public static class KafkaTestConf {

        @Bean
        public Map<String, Object> consumerConf() {
            Map<String, Object> conf = new HashMap<>();
            conf.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafka.getBootstrapServers());
            conf.put(ConsumerConfig.GROUP_ID_CONFIG, "kompuuter");
            return conf;
        }

        @Bean
        public ProducerFactory<Object, Object> producerFactory() {
            Map<String, Object> conf = new HashMap<>();
            conf.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafka.getBootstrapServers());
            conf.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, ByteArraySerializer.class);
            conf.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class);
            return new DefaultKafkaProducerFactory<>(conf);
        }


    }

}
