package com.ynov.chatbotdemo.controller;

import com.ynov.chatbotdemo.model.request.WebhookRequest;
import com.ynov.chatbotdemo.model.response.WebhookResponse;
import com.ynov.chatbotdemo.service.WebhookService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@Slf4j
public class WebhookController {

    private final WebhookService webhookService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello World !";
    }

    @PostMapping("/webhook")
    public WebhookResponse webhook(@RequestBody WebhookRequest request) {
        log.info("{}", request);
        var webhookResponse = webhookService.computeResponse(request);
        log.info("{}", webhookResponse);
        return webhookResponse;
    }

}
