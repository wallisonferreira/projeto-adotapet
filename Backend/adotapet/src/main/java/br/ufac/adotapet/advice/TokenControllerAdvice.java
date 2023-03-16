package br.ufac.adotapet.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import br.ufac.adotapet.exception.TokenRefreshException;

@RestControllerAdvice
public class TokenControllerAdvice {

    /**
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(value = TokenRefreshException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public String handleTokenRefreshException(TokenRefreshException ex, WebRequest request) {

        return "Error";
    }
}
