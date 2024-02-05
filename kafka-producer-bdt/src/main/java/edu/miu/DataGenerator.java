package edu.miu;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import lombok.Getter;

import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

@Getter
public class DataGenerator {

    private final BlockingQueue<String> queue = new LinkedBlockingDeque<>(10000);
    private final ObjectMapper objectMapper = CustomObjectMapper.getMapper();


    public void getDataBuffered(String file) {
        try {
            FileReader filereader = new FileReader(file);
            CSVReader csvReader = new CSVReader(filereader);
            String[] nextRecord;
            Product parsed;
            while ((nextRecord = csvReader.readNext()) != null) {
                List<String> tokens = Arrays.asList(nextRecord);
                if (tokens.size() != 8) continue;

                parsed = new Product.Builder()
                        .invoiceId(tokens.get(0))
                        .productId(tokens.get(1))
                        .productName(tokens.get(2))
                        .quantity(tokens.get(3))
                        .date(tokens.get(4))
                        .price(tokens.get(5))
                        .customerId(tokens.get(6))
                        .country(tokens.get(7))
                        .build();

                boolean added = queue.offer(objectMapper.writeValueAsString(parsed), 10, TimeUnit.SECONDS);
                if (!added) {
                    System.out.println("Queue is full. Retrying in 10 seconds...");
                    Thread.sleep(10000); // Wait for 10 seconds before retrying
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
