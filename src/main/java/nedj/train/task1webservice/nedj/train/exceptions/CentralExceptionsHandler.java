package nedj.train.task1webservice.nedj.train.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.persistence.EntityNotFoundException;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
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

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ExceptionResponse> notReadableException(Exception e){

        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setCode(HttpStatus.SERVICE_UNAVAILABLE.value());
        exceptionResponse.setMessage("Please supply the request data");
        exceptionResponse.setDate(FormatDateForExceptions.formatDate(new Date()));

        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.SERVICE_UNAVAILABLE);
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
        exceptionResponse.setMessage("Data not found, please supply a known symbol");
        exceptionResponse.setDate(FormatDateForExceptions.formatDate(new Date()));

        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MalformedURLException.class)
    public ResponseEntity<ExceptionResponse> malformedUrl(Exception e){

        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setCode(HttpStatus.URI_TOO_LONG.value());
        exceptionResponse.setMessage("Invalid url");
        exceptionResponse.setDate(FormatDateForExceptions.formatDate(new Date()));

        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.URI_TOO_LONG);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ExceptionResponse> nullPointer(Exception e){

        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setCode(HttpStatus.BAD_REQUEST.value());
        exceptionResponse.setMessage("Supply valid trading account details!!");
        exceptionResponse.setDate(FormatDateForExceptions.formatDate(new Date()));

        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnknownHostException.class)
    public ResponseEntity<ExceptionResponse> noInternetConnection(Exception e){

        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setCode(HttpStatus.SERVICE_UNAVAILABLE.value());
        exceptionResponse.setMessage("No internet connection");
        exceptionResponse.setDate(FormatDateForExceptions.formatDate(new Date()));

        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.SERVICE_UNAVAILABLE);
    }


}
