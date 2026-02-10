package com.chitkara.bfhlapi.controller;

import com.chitkara.bfhlapi.model.*;
import com.chitkara.bfhlapi.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class BfhlController {

    private static final String OFFICIAL_EMAIL = "anshul1781.be23@chitkara.edu.in";

    @Autowired
    private MathService mathService;

    @Autowired
    private AIService aiService;

    @PostMapping("/bfhl")
    public ResponseEntity<BfhlResponse> handleBfhl(@RequestBody BfhlRequest request) {
        try {
            // Validate exactly one key is present
            int keyCount = 0;
            if (request.getFibonacci() != null) keyCount++;
            if (request.getPrime() != null) keyCount++;
            if (request.getLcm() != null) keyCount++;
            if (request.getHcf() != null) keyCount++;
            if (request.getAI() != null && !request.getAI().isEmpty()) keyCount++;

            if (keyCount != 1) {
                return ResponseEntity.badRequest().body(
                        new BfhlResponse(false, OFFICIAL_EMAIL, null,
                                "Request must contain exactly one key")
                );
            }

            Object data = null;

            // Process based on key
            if (request.getFibonacci() != null) {
                data = mathService.generateFibonacci(request.getFibonacci());
            } else if (request.getPrime() != null) {
                data = mathService.filterPrimes(request.getPrime());
            } else if (request.getLcm() != null) {
                data = mathService.calculateLCM(request.getLcm());
            } else if (request.getHcf() != null) {
                data = mathService.calculateHCF(request.getHcf());
            } else if (request.getAI() != null && !request.getAI().isEmpty()) {
                data = aiService.getAIResponse(request.getAI());
            }

            return ResponseEntity.ok(new BfhlResponse(true, OFFICIAL_EMAIL, data));

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(
                    new BfhlResponse(false, OFFICIAL_EMAIL, null, e.getMessage())
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new BfhlResponse(false, OFFICIAL_EMAIL, null,
                            "Internal server error: " + e.getMessage())
            );
        }
    }

    @GetMapping("/health")
    public ResponseEntity<BfhlResponse> health() {
        return ResponseEntity.ok(new BfhlResponse(true, OFFICIAL_EMAIL, null));
    }
}