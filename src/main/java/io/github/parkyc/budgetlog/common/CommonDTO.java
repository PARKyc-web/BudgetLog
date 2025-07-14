package io.github.parkyc.budgetlog.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

public class CommonDTO {

    @Getter
    @Builder
    @AllArgsConstructor
    public static class Response<T> {
        private int status;
        private LocalDateTime responseTime;
        private String message;
        private T data;

        public Response(T data) {
            Response.<T>builder()
                    .responseTime(LocalDateTime.now())
                    .message("Success")
                    .data(data)
                    .build();
        }

        public Response(String message, T data) {
            Response.<T>builder()
                    .responseTime(LocalDateTime.now())
                    .message(message)
                    .data(data)
                    .build();
        }
    }

    // 공통적으로 사용할 사항 추가
}