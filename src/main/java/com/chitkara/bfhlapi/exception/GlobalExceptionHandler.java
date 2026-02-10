package com.chitkara.bfhlapi.exception;

import com.chitkara.bfhlapi.model.BfhlResponse;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final String OFFICIAL_EMAIL = "anshul1781.be23@chitkara.edu.in";

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BfhlResponse> handleAllExceptions(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                new BfhlResponse(false, OFFICIAL_EMAIL, null, ex.getMessage())
        );
    }
}