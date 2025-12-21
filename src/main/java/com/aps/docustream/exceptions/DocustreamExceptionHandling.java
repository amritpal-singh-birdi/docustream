package com.aps.docustream.exceptions;

import java.io.FileNotFoundException;

import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

import org.apache.fop.apps.FOPException;
import org.xml.sax.SAXParseException;

import com.aps.docustream.responses.ErrorResponse;

public class DocustreamExceptionHandling {
	
	public ErrorResponse documentGenerationException(Exception e) {
		
		ErrorResponse errorResponse = new ErrorResponse();
		
		
		if(e instanceof FileNotFoundException) {
			errorResponse.setErrorId("400");
			errorResponse.setErrorException(e.getCause().toString());
			errorResponse.setErrorDetails(e.getMessage());
			System.out.println("FileNotFoundException");
		}else if(e instanceof FOPException) {
			errorResponse.setErrorId("400");
			errorResponse.setErrorException(e.getCause().toString());
			errorResponse.setErrorDetails(e.getMessage());
			System.out.println("FOPException");
		}else if(e instanceof TransformerException) {
			errorResponse.setErrorId("400");
			errorResponse.setErrorException(e.getCause().toString());
			errorResponse.setErrorDetails(e.getMessage());
			System.out.println("TransformerException");
		}else if(e instanceof TransformerConfigurationException) {
			errorResponse.setErrorId("400");
			errorResponse.setErrorException(e.getCause().toString());
			errorResponse.setErrorDetails(e.getMessage());
			System.out.println("TransformerConfigurationException");
		}else if(e instanceof SAXParseException) {
			errorResponse.setErrorId("400");
			errorResponse.setErrorException(e.getCause().toString());
			errorResponse.setErrorDetails(e.getMessage());
			System.out.println("SAXParseException");
		}else {
			errorResponse.setErrorId("400");
			errorResponse.setErrorException(e.getCause().toString());
			errorResponse.setErrorDetails(e.getMessage());
			System.out.println("Exception");
		}
		
		
		return errorResponse;		
	}

}
