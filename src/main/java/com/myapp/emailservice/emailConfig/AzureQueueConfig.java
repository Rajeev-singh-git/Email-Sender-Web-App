package com.myapp.emailservice.emailConfig;

import com.azure.storage.queue.QueueClient;
import com.azure.storage.queue.QueueClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AzureQueueConfig {

    @Value("${azure.storage.connection-string}")
    private String connectStr;

    @Value("${azure.storage.queue-name}")
    private String queueName;

    @Bean
    public QueueClient queueClient() {
        System.out.println("Queue Client Initialized for Queue: " + queueName);
        return new QueueClientBuilder()
                .connectionString(connectStr)
                .queueName(queueName)
                .buildClient();
    }
}
