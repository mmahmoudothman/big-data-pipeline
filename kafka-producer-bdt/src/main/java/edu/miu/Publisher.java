package edu.miu;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import java.util.Properties;
import java.util.concurrent.BlockingQueue;

public class Publisher {

    private final BlockingQueue<String> queue;
    private final KafkaProducer<String, String> producer;

    public Publisher(BlockingQueue<String> queue) {
        this.queue = queue;
        this.producer = createKafkaProducer();
    }

    private KafkaProducer<String, String> createKafkaProducer() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:29092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        return new KafkaProducer<>(props);
    }

    public void publish(String topic) {
        try {
            int i = 0;
            while (true) {
                if (i % 1000 == 0) Thread.sleep(3000);
                String message = queue.take();
                producer.send(new ProducerRecord<>(topic, message));
                i++;
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            producer.close();
        }
    }
}
