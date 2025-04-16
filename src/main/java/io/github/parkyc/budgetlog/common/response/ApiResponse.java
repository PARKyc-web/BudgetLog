package io.github.parkyc.budgetlog.common.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ApiResponse {
    
    public static <T> ResponseEntity<T> ok(T data) {
        return ResponseEntity.ok(data);
    }

    public static <T> ResponseEntity<T> created(T data) {
        return ResponseEntity.status(HttpStatus.CREATED).body(data);
    }

    public static <T> ResponseEntity<T> noContent() {
        return ResponseEntity.noContent().build();
    }

    public static <T> ResponseEntity<T> badRequest(T data) {
        return ResponseEntity.badRequest().body(data);
    }

    public static <T> ResponseEntity<T> notFound(T data) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(data);
    }

    public static <T> ResponseEntity<T> internalServerError(T data) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(data);
    }
} 