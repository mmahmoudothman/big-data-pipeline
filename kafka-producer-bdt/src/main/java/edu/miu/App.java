package edu.miu;

public class App {
    public static void main( String[] args ) {
        DataGenerator data = new DataGenerator();

        new Thread(() -> {
            data.getDataBuffered("src/main/resources/data/online_retail_II.csv");
        }).start();

        new Thread(() -> {
            Publisher kafkaPublisher = new Publisher(data.getQueue());
            kafkaPublisher.publish("test");
        }).start();

    }
}
