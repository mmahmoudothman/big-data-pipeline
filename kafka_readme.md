# Kafka Producer for Data Generation

This Kafka Producer application reads data from a CSV file, converts it into JSON format, and publishes it to a Kafka topic. It is a part of a larger system for real-time data processing.


![App Screenshot](https://github.com/mmahmoudothman/big-data-pipeline/blob/main/Kafka_Topic.png)

## Prerequisites

Ensure you have the following prerequisites before running the Kafka Producer:

1. **Kafka Setup:**
   - Have a running Kafka cluster with accessible bootstrap servers.
   - Configure Kafka server details in the producer code.

2. **CSV Data:**
   - Prepare a CSV file with data in the expected format.
   - The CSV file should have eight columns corresponding to the fields in the `Product` class.

3. **Java Environment:**
   - Ensure that Java is installed on your machine.

## Configuration

In the `Publisher` class, configure the following properties:

- `bootstrap.servers`: Kafka bootstrap servers.
- `key.serializer`: Serializer for the message keys.
- `value.serializer`: Serializer for the message values.

Adjust these properties based on your Kafka cluster configuration.

## Running the Producer

Follow these steps to run the Kafka Producer:

1. **Run the application:**
   ```bash
   ~/kafka/bin/kafka-server-start.sh ~/kafka/config/server.properties
   ```
   
## Additional Information

### Data Format:

- The producer reads data from a CSV file using the `Product` class to represent each record.
- Ensure that your CSV file adheres to the expected format.

### Serialization:

- The application uses the Jackson library for JSON serialization and deserialization.
- The `CustomObjectMapper` class configures the ObjectMapper with custom settings for handling LocalDateTime objects.

### Kafka Producer:

- The `Publisher` class continuously reads data from a blocking queue populated by the `DataGenerator` class.
- Adjust the Kafka producer configuration as needed for your use case.

## Conclusion

This Kafka Producer plays a crucial role in ingesting and transforming data for real-time processing. Ensure all prerequisites are met and configurations are accurate before running the application.

## Q&A

Feel free to reach out if you have any questions or need further assistance.

---
