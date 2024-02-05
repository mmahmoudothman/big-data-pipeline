package edu.miu;


import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
@Getter
public class Product {

    private String invoiceId;
    private String productId;
    private String productName;
    private int quantity;
    private LocalDate date;
    private double price;
    private String customerId;
    private String country;

    private Product(Builder builder) {
        try {
            this.invoiceId = builder.invoiceId;
            this.productId = builder.productId;
            this.productName = builder.productName;
            this.quantity = Integer.parseInt(builder.quantity);
            this.date = LocalDate.parse(builder.date, DateTimeFormatter.ofPattern("M/d/yyyy"));
            this.price = Double.parseDouble(builder.price);
            this.customerId = builder.customerId;
            this.country = builder.country;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static class Builder {
        private String invoiceId;
        private String productId;
        private String productName;
        private String quantity;
        private String date;
        private String price;
        private String customerId;
        private String country;

        public Builder invoiceId(String id) {
            if (id.isEmpty()) throw new RuntimeException("Couldn't parse invoice id");
            this.invoiceId = id;
            return this;
        }

        public Builder productId(String productId) {
            if (productId.isEmpty()) throw new RuntimeException("Couldn't parse productId");
            this.productId = productId;
            return this;
        }

        public Builder productName(String productName) {
            this.productName = productName;
            return this;
        }

        public Builder quantity(String quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder date(String date) {
            String regex = "(\\d{1,2}/\\d{1,2}/\\d{4})";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(date);

            if (matcher.find()) {
                this.date = matcher.group(1);
            }

            return this;
        }

        public Builder price(String price) {
            this.price = price;
            return this;
        }

        public Builder customerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder country(String country) {
            this.country = country;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }
}
