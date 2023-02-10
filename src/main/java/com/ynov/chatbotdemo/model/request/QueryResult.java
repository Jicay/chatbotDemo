package com.ynov.chatbotdemo.model.request;

import java.util.Map;
import lombok.Data;

@Data
public class QueryResult {
    private String queryText;
    private String action;
    private Map<String, Object> parameters;
}
