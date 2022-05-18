package com.vrm.test.kafka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author taaviv @ 05.05.22
 */
@SpringBootApplication
public class App {

    @Value("${testapp.kafka.topic.stock.name}")
    private String topicName;

    @Value("${testapp.kafka.topic.stock.partitions:1}")
    private int partitions;

    @Value("${testapp.kafka.topic.stock.replication:1}")
    private short replicationFactor;

    /*@Bean
    public NewTopic stockTopic() {
        return new NewTopic(topicName, partitions, replicationFactor);
    }*/

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
