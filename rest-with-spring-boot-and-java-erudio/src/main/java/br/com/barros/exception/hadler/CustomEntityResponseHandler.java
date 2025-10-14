package br.com.barros.exception.hadler;

import br.com.barros.exception.ExceptionResponse;
import br.com.barros.exception.UnsupportedMathOperationException;
import com.fasterxml.jackson.annotation.JsonAlias;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestController
@ControllerAdvice
public class CustomEntityResponseHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handlerAllExceptions(Exception ex, WebRequest request){
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        ExceptionResponse response = new ExceptionResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(false),
                httpStatus.value()
        );
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(UnsupportedMathOperationException.class)
    public ResponseEntity<ExceptionResponse> handlerBadRequest(Exception ex, WebRequest request){
        HttpStatus httpstatus = HttpStatus.BAD_REQUEST;
        ExceptionResponse response = new ExceptionResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(false),
                httpstatus.value()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
