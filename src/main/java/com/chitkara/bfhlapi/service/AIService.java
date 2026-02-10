package com.chitkara.bfhlapi.service;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class AIService {

    // Simple fallback with common answers
    private static final Map<String, String> FALLBACK_ANSWERS = new HashMap<>();

    static {
        FALLBACK_ANSWERS.put("maharashtra", "Mumbai");
        FALLBACK_ANSWERS.put("india", "Delhi");
        FALLBACK_ANSWERS.put("france", "Paris");
        FALLBACK_ANSWERS.put("japan", "Tokyo");
        FALLBACK_ANSWERS.put("usa", "Washington");
        FALLBACK_ANSWERS.put("uk", "London");
    }

    public String getAIResponse(String question) {
        // Convert to lowercase for matching
        String lowerQuestion = question.toLowerCase();

        // Check for matches in fallback answers
        for (Map.Entry<String, String> entry : FALLBACK_ANSWERS.entrySet()) {
            if (lowerQuestion.contains(entry.getKey())) {
                return entry.getValue();
            }
        }

        // Default answer for unknown questions
        return "Unknown";
    }
}