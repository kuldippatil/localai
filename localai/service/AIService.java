package com.localai.service;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.ollama.OllamaChatModel;
import org.springframework.stereotype.Service;
import java.time.Duration;

@Service
public class AIService {
    private final ChatLanguageModel model;

    public AIService() {
        this.model = OllamaChatModel.builder()
                .baseUrl("http://localhost:11434")
                .modelName("llama3.1:latest")
                .temperature(0.7)
                .timeout(Duration.ofSeconds(120))
                .build();
    }

    public String processQuery(String userId, String query) {
        try {
            return model.generate(query);
        } catch (Exception e) {
            return "Error processing query: " + e.getMessage();
        }
    }
} 