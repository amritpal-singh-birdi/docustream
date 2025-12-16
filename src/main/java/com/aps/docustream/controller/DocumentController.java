package com.aps.docustream.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aps.docustream.entities.Document;

@RestController
public class DocumentController {
	
	
	@PostMapping(path = "/createDocuments", consumes = {"application/json","application/xml"}, headers= {"x-document-id"} )
	public String createDocuments(@RequestBody Document document) {
		
		
		
		System.out.println(document.getDocumentBody().getContractNote());
		
		return "Document Received. Thanks." + document.getDocumentBody().getContractNote().toString();
	}
	
	@GetMapping("/getDocuments")
	public String getDocuments() {
		
		
		return "Documents";
	}

}
