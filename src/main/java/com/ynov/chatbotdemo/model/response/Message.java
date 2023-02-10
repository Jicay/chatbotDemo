package com.ynov.chatbotdemo.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class Message {

    private Platform platform;

    private Suggestions suggestions;

    private SimpleResponses simpleResponses;
}
