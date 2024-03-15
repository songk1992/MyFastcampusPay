package com.fastcampuspay.common;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * Kafka producer for logging messages to a specified topic.
 */
@Component
public class LoggingProducer {
    private final KafkaProducer<String, String> producer;
    private final String topic;

    /**
     * Constructs a LoggingProducer with the specified Kafka bootstrap servers and topic.
     *
     * @param bootstrapServers The Kafka bootstrap servers.
     * @param topic            The Kafka topic to which messages will be sent.
     */
    public LoggingProducer(
            @Value("${kafka.clusters.bootstrapservers}") String bootstrapServers,
            @Value("${logging.topic}") String topic) {

        // Producer Initialization ';'
        Properties props = new Properties();

        // kafka:29092
        props.put("bootstrap.servers", bootstrapServers);

        // key:value
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        this.producer = new KafkaProducer<>(props);
        this.topic = topic;
    }

    /**
     * Sends a message to the configured Kafka topic.
     *
     * @param key   The key for the Kafka message.
     * @param value The value for the Kafka message.
     */
    public void sendMessage(String key, String value) {
        ProducerRecord<String, String> record = new ProducerRecord<>(topic, key, value);
        producer.send(record, ((recordMetadata, e) -> {
            if (e == null) {
                System.out.println("Message send successfully. Offset : " + recordMetadata.offset());
            } else {
                e.fillInStackTrace();
                System.out.println("Failed to send message: " + e.getMessage());
            }
        }));
    }


}
