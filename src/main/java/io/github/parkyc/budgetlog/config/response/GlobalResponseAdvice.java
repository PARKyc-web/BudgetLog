package io.github.parkyc.budgetlog.config.response;

import io.github.parkyc.budgetlog.common.CommonDTO;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice(basePackages = "io.github.parkyc.budgetlog")
public class GlobalResponseAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        // 모든 응답에 대해 이 Advice를 적용합니다.
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request, ServerHttpResponse response) {
        
        if (body instanceof CommonDTO.Response) {
            CommonDTO.Response<?> commonResponse = (CommonDTO.Response<?>) body;
            response.setStatusCode(HttpStatus.valueOf(commonResponse.getStatus()));
        }
        
        return body;
    }
}
