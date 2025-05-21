package io.github.parkyc.budgetlog.common.response;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@RestControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public CommonRes<?> handleException(Exception e) {
        return new CommonRes<>("INTERNAL_ERROR", "예상치 못한 오류가 발생했습니다.");
    }

}
