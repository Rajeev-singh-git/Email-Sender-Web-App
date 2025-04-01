package com.myapp.emailservice.controller;

import com.myapp.emailservice.service.AzureQueueService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/queue")
public class AzureQueueController {

    private final AzureQueueService queueService;

    public AzureQueueController(AzureQueueService queueService) {
        this.queueService = queueService;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestParam String message) {
        queueService.sendMessage(message);
        return "Message sent successfully: " + message;
    }

    @GetMapping("/receive")
    public List<String> receiveMessages() {
        return queueService.receiveMessages();
    }

    @DeleteMapping("/deleteAll")
    public String deleteAllMessages() {
        queueService.deleteAllMessages();
        return "All messages have been deleted.";
    }


    /* Comment added



    .....
     */
}
