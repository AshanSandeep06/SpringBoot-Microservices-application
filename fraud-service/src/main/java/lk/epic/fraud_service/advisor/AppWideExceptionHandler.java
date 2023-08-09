package lk.epic.fraud_service.advisor;

import lk.epic.fraud_service.util.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@CrossOrigin
public class AppWideExceptionHandler {
    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<ResponseUtil> handleRuntimeExceptions(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseUtil("06", e.getMessage(), null));
    }

    /*@ExceptionHandler({AccessDeniedException.class})
    public ResponseEntity<ResponseUtil> handleAccessDeniedExceptions(AccessDeniedException e) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ResponseUtil("06", e.getMessage(), null));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseUtil> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return ResponseEntity.status(HttpStatus.NON_AUTHORITATIVE_INFORMATION).body(new ResponseUtil("06", "Validation Failed", errors));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ResponseUtil> handleConstraintViolationExceptions(ConstraintViolationException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getConstraintViolations().forEach((error) -> {
            String fieldName = error.getPropertyPath().toString().split("\\.")[1];
            String errorMessage = error.getMessage();
            errors.put(fieldName, errorMessage);
        });

        return ResponseEntity.status(HttpStatus.NON_AUTHORITATIVE_INFORMATION).body(new ResponseUtil("06", "Validation Failed", errors));
    }

    @ExceptionHandler({BadCredentialsException.class})
    public ResponseEntity<ResponseUtil> handleBadCredentialsExceptions(BadCredentialsException e) {
        System.out.println("403");
        return ResponseEntity.status(HttpStatus.NON_AUTHORITATIVE_INFORMATION).body(new ResponseUtil("03", "Invalid Credentials", null));
    }*/
}
