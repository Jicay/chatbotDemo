package com.ynov.chatbotdemo.service;

import com.ynov.chatbotdemo.model.request.WebhookRequest;
import com.ynov.chatbotdemo.model.response.Message;
import com.ynov.chatbotdemo.model.response.Platform;
import com.ynov.chatbotdemo.model.response.SimpleResponse;
import com.ynov.chatbotdemo.model.response.SimpleResponses;
import com.ynov.chatbotdemo.model.response.Suggestion;
import com.ynov.chatbotdemo.model.response.Suggestions;
import com.ynov.chatbotdemo.model.response.WebhookResponse;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class WebhookService {
    public WebhookResponse computeResponse(WebhookRequest request) {
        var webhookResponse = new WebhookResponse();
        if (StringUtils.hasText((String) request.getQueryResult().getParameters().get("genre"))) {
            webhookResponse.setFulfillmentText("Voici les résultats");
        } else {
            webhookResponse.setFulfillmentText("Quel genre veux-tu voir ?");
            webhookResponse.setFulfillmentMessages(List.of(
                    new Message()
                            .setPlatform(Platform.ACTIONS_ON_GOOGLE)
                            .setSimpleResponses(new SimpleResponses().setSimpleResponses(List.of(
                                    new SimpleResponse().setTextToSpeech("Quel genre veux-tu voir ?")
                            ))),
                    new Message()
                            .setPlatform(Platform.ACTIONS_ON_GOOGLE)
                            .setSuggestions(new Suggestions().setSuggestions(
                                    List.of(
                                            new Suggestion().setTitle("Action"),
                                            new Suggestion().setTitle("Science-fiction"),
                                            new Suggestion().setTitle("Aventure"),
                                            new Suggestion().setTitle("Romance"),
                                            new Suggestion().setTitle("Comédie")
                                    )
                            ))
            ));
        }
        return webhookResponse;
    }
}
