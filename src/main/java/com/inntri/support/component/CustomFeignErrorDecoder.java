package com.inntri.support.component;

import feign.FeignException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.stereotype.Component;

@Component
public class CustomFeignErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        if (response.status() == HttpStatus.FORBIDDEN.value()) {
            return new CredentialsExpiredException("Expired JWT credentials");
        }
        return FeignException.errorStatus(methodKey, response);
    }
}