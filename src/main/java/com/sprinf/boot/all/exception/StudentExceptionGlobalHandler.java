package com.sprinf.boot.all.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sprinf.boot.all.bean.ErrorInfo;

@RestControllerAdvice
public class StudentExceptionGlobalHandler {
	
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<ErrorInfo> catchStudentNotFoun(StudentNotFoundException ex){
		ErrorInfo errorInfo = generateErrorInfo(ex.getErrorCode(),ex.getErrorMessage());
		errorInfo.setStatusCode(HttpStatus.BAD_REQUEST.toString());
		return new ResponseEntity<ErrorInfo>(errorInfo,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorInfo> catchStudentNotFoun(Exception ex){
		ErrorInfo errorInfo = generateErrorInfo("Unhandle Error",ex.getMessage());
		return new ResponseEntity<ErrorInfo>(errorInfo,HttpStatus.BAD_REQUEST);
	}


	private ErrorInfo generateErrorInfo(String errorCode,String errorMessage) {
		ErrorInfo errorInfo = new ErrorInfo();
		
		errorInfo.setErrorCode(errorCode);
		errorInfo.setErrorMessage(errorMessage);
		return errorInfo;
	}

}
