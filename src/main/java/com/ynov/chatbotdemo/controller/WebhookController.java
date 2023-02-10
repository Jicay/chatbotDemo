package com.ynov.chatbotdemo.controller;

import com.ynov.chatbotdemo.model.request.WebhookRequest;
import com.ynov.chatbotdemo.model.response.WebhookResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class WebhookController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World !";
    }

    @PostMapping("/webhook")
    public WebhookResponse webhook(@RequestBody WebhookRequest request) {
        log.info("{}", request);
        request.getQueryResult().getQueryText();
        var webhookResponse = new WebhookResponse()
                .setFulfillmentText("Test");
        log.info("{}", webhookResponse);
        return webhookResponse;
    }

}
