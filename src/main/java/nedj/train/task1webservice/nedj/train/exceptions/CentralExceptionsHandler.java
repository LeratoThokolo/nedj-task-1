package nedj.train.task1webservice.nedj.train.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.persistence.EntityNotFoundException;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;


@ControllerAdvice
public class CentralExceptionsHandler {


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> generalException(Exception e){

        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        exceptionResponse.setMessage(e.getMessage());
        exceptionResponse.setDate(FormatDateForExceptions.formatDate(new Date()));

        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(HttpMessageNotWritableException.class)
    public ResponseEntity<ExceptionResponse> notWritableException(HttpMessageNotWritableException e){

        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setCode(HttpStatus.NOT_FOUND.value());
        exceptionResponse.setMessage("Trading account doesn't exist");
        exceptionResponse.setDate(FormatDateForExceptions.formatDate(new Date()));

        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ExceptionResponse> methodArgumentTypeMismatch(Exception e){

        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setCode(HttpStatus.BAD_REQUEST.value());
        exceptionResponse.setMessage("Wrong input type, input must be a number");
        exceptionResponse.setDate(FormatDateForExceptions.formatDate(new Date()));

        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }



    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ExceptionResponse> entityNotFound(Exception e){

        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setCode(HttpStatus.BAD_REQUEST.value());
        exceptionResponse.setMessage("Trading account id doesn't exist");
        exceptionResponse.setDate(FormatDateForExceptions.formatDate(new Date()));

        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(JpaObjectRetrievalFailureException.class)
    public ResponseEntity<ExceptionResponse> jpaFailure(Exception e){

        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setCode(HttpStatus.NOT_FOUND.value());
        exceptionResponse.setMessage("Trading account id doesn't exist");
        exceptionResponse.setDate(FormatDateForExceptions.formatDate(new Date()));

        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(FileNotFoundException.class)
    public ResponseEntity<ExceptionResponse> fileNotFound(Exception e){

        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setCode(HttpStatus.NOT_FOUND.value());
        exceptionResponse.setMessage("Data not found, please check your url");
        exceptionResponse.setDate(FormatDateForExceptions.formatDate(new Date()));

        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND);
    }


}
