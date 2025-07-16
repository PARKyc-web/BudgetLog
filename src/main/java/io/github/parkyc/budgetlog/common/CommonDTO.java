package io.github.parkyc.budgetlog.common;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class CommonDTO {

    @Getter
    @Builder
    public static class Response<T> {
        private final int status;
        private final String message;
        private final T data;
        @Builder.Default
        private final LocalDateTime responseTime = LocalDateTime.now();

        // 기본 성공 응답 (200 OK)
        public static <T> Response<T> success(T data) {
            return Response.<T>builder()
                    .status(HttpStatus.OK.value())
                    .message("Success")
                    .data(data)
                    .build();
        }

        // 성공 응답 (상태 코드 지정)
        public static <T> Response<T> success(int status, T data) {
            return Response.<T>builder()
                    .status(status)
                    .message("Success")
                    .data(data)
                    .build();
        }

        // 실패 응답 (상태 코드, 메시지 지정)
        public static <T> Response<T> fail(int status, String message) {
            return Response.<T>builder()
                    .status(status)
                    .message(message)
                    .build();
        }

        // 기본 실패 응답 (500 Internal Server Error)
        public static <T> Response<T> fail(String message) {
            return Response.<T>builder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .message(message)
                    .build();
        }
    }

    // 공통적으로 사용할 사항 추가
}