package com.aps.docustream.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aps.docustream.entities.Document;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

@RestController
public class DocumentController {
	
	
	@PostMapping(path = "/createDocuments", consumes = {"application/json","application/xml"},produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, headers= {"x-document-type"} )
	public Document createDocuments(@RequestBody Document document) {
		

		ObjectMapper objectMapper = new ObjectMapper();
		XmlMapper xmlMapper = new XmlMapper();
		String json = "";
		String jsonPretty = "";
		String xml = "";
		String xmlPretty = "";
		try {
			json = objectMapper.writeValueAsString(document);
			jsonPretty = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(document);
			xml = xmlMapper.writeValueAsString(document);
			xmlPretty = xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(document);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(json);
		System.out.println(jsonPretty);
		System.out.println(xml);
		System.out.println(xmlPretty);
		System.out.println(document);
		
		System.out.println(document.getDocumentBody().getContractNote());
		
		return document;//"Document Received. Thanks." + document.getDocumentBody().getContractNote();
	}
	
	@GetMapping("/getDocuments")
	public String getDocuments() {
		
		
		return "Documents";
	}

}
