package cl.ignis.bcn.api.parser.handler;

import cl.ignis.bcn.api.parser.exception.InvalidQueryParamException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidQueryParamException.class)
    public ResponseEntity<String> handleInvalidQueryParam(InvalidQueryParamException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
