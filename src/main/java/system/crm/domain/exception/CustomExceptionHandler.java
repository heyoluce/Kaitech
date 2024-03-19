package system.crm.domain.exception;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ExceptionBody handleResourceNotFoundException(ResourceNotFoundException e){
        return new ExceptionBody(e.getMessage());
    }

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<Map<String, String>> handleInvalidArgument(MethodArgumentNotValidException exception){
//        Map<String, String> errorMap = new HashMap<>();
//        exception.getBindingResult().getFieldErrors().forEach(error -> {
//            errorMap.put(error.getField(), error.getDefaultMessage());
//        });
//        return ResponseEntity.badRequest().body(errorMap);
//    }
//
//    @ExceptionHandler({AccessDeniedException.class,
//            org.springframework.security.access.AccessDeniedException.class})
//    @ResponseStatus(HttpStatus.FORBIDDEN)
//    public ExceptionBody handleAccessDenied(Exception e) {
//        System.out.println(e);
//        e.printStackTrace();
//        return new ExceptionBody("Access denied");
//    }
}
