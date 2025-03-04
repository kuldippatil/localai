package com.localai.controller;

import com.localai.service.AIService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
public class AIController {
    private final AIService aiService;

    public AIController(AIService aiService) {
        this.aiService = aiService;
    }

    @PostMapping("/{userId}")
    public String chat(@PathVariable String userId, @RequestBody String message) {
        return aiService.processQuery(userId, message);
    }
} 