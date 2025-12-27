package com.aps.docustream.validators;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.http.MediaType;
import org.xml.sax.SAXException;

import com.aps.docustream.entities.enums.PayloadType;
import com.aps.docustream.utils.Utilites;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;

public class PayloadTypeDetector {

	public static PayloadType checkAndValidatePayloadType(byte[] payload) {
		if(payload == null || payload.length == 0) {
			return PayloadType.UNKNOWN;
		}
		
		String body = new String(payload, StandardCharsets.UTF_8);
		if(body.isEmpty()) {
			return PayloadType.UNKNOWN;
		}
		
		if(body.startsWith("{") || body.startsWith("[")) {
			return isValidJson(payload) ? PayloadType.JSON : PayloadType.UNKNOWN;
		}
		
		if(body.startsWith("<")) {
			return isValidXml(payload) ? PayloadType.XML : PayloadType.UNKNOWN;
		}
		
		return PayloadType.UNKNOWN;
	}
	
	public static boolean isValidJson(byte[] payload) {
		
		try {
			new ObjectMapper().readTree(payload);
			return true;
		} catch (IOException e) {
			return false;
		}
	}
	
	public static boolean isValidXml(byte[] payload) {
		
		try {
			DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(payload));
			return true;
		} catch (SAXException | IOException | ParserConfigurationException e) {
			return false;
		}
	}
	
	public static PayloadType checkPayloadType(HttpServletRequest request) {
		
		switch (request.getContentType()) {
		case MediaType.APPLICATION_XML_VALUE:
			return PayloadType.XML;
		case MediaType.APPLICATION_JSON_VALUE:
			return PayloadType.JSON;
		default:
			return PayloadType.UNKNOWN;
		}
		
		
	}
}
