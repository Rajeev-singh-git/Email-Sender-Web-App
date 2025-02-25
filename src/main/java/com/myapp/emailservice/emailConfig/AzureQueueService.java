//package com.myapp.emailservice.emailConfig;
//
///**
// * Azure Queue Storage client library quickstart
// */
//import com.azure.storage.queue.*;
//import com.azure.storage.queue.models.*;
//import jakarta.annotation.PostConstruct;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AzureQueueService
//{
//
//    @Value("${azure.storage.connection-string}")
//    private String connectStr;
//
//    @Value("${azure.storage.queue-name}")
//    private String queueName;
//
//    private QueueClient queueClient;
//
//
//    @PostConstruct
//    public void initializeQueueClient() {
//        this.queueClient = new QueueClientBuilder()
//                .connectionString(connectStr)
//                .queueName(queueName)
//                .buildClient();
//        System.out.println("Queue Client Initialized for Queue: " + queueName);
//    }
//
//    public void processQueue() {
//        System.out.println("Processing Queue: Sending & Receiving Messages");
//        sendMessage("Hello from processQueue()!");
//        sendMessage("Hello from SpringBoot");
//        receiveMessages();
//        System.out.println("Queue Processing Completed.");
//    }
//
//
//    public void sendMessage(String message) {
//        queueClient.sendMessage(message);
//        System.out.println("Message sent: " + message);
//    }
//
//
//    public void receiveMessages() {
//        for (QueueMessageItem message : queueClient.receiveMessages(5)) {
//            System.out.println("Received message: " + message.getMessageText());
//
//            queueClient.deleteMessage(message.getMessageId(), message.getPopReceipt());
//            System.out.println("Message deleted.");
//        }
//    }
//
//
//}