package com.myapp.emailservice.service;

import com.azure.storage.queue.QueueClient;
import com.azure.storage.queue.models.QueueMessageItem;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AzureQueueService {

    private final QueueClient queueClient;

    public AzureQueueService(QueueClient queueClient) {
        this.queueClient = queueClient;
    }

    public void sendMessage(String message) {
        queueClient.sendMessage(message);
        System.out.println("Message sent: " + message);
    }

    public List<String> receiveMessages() {
        List<String> messages = new ArrayList<>();
        for (QueueMessageItem message : queueClient.receiveMessages(5)) {
            messages.add(message.getBody().toString());
        }
        return messages;
    }

    public void deleteAllMessages() {
        queueClient.clearMessages();
        System.out.println("All messages in the queue have been deleted.");
    }
}
