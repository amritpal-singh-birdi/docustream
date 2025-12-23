package com.aps.docustream.controller;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.aps.docustream.entities.enums.DocumentStatus;
import com.aps.docustream.entities.enums.FileType;
import com.aps.docustream.entities.enums.PayloadType;
import com.aps.docustream.entities.to.Document;
import com.aps.docustream.responses.DocumentResponse;
import com.aps.docustream.service.DocustreamService;
import com.aps.docustream.utils.Utilites;
import com.aps.docustream.validators.FileTypeDetector;
import com.aps.docustream.validators.PayloadTypeDetector;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.constraints.Pattern;

@RestController
public class DocumentController {
	
	@Autowired
	private DocustreamService docustreamService;
	
	
	
	@ApiResponses({@ApiResponse(responseCode = "200", description = "Document created", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = com.aps.docustream.responses.DocumentResponse.class))),@ApiResponse(responseCode = "400", description = "Technical Exception", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = com.aps.docustream.responses.ErrorResponse.class)))})
	@PostMapping(path = "/createDocuments", consumes = {"application/json","application/xml"},produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, headers = {"x-document-type"})
	public ResponseEntity<DocumentResponse> createDocuments(@RequestHeader("x-document-type") @Pattern(regexp = "\\d+", message = "x-document-type must be numeric") String documentType ,@RequestBody byte[] rawDocumentPayload, HttpServletRequest request) {
		
		Document document = new Document();
		DocumentResponse docResp = new DocumentResponse();
		
		PayloadType payloadType = PayloadTypeDetector.checkAndValidatePayloadType(rawDocumentPayload);
		
		if(payloadType == PayloadType.UNKNOWN) {
			return ResponseEntity.badRequest().body(docResp);
		}else if(payloadType == PayloadType.JSON) {
			document = (Document) Utilites.convertToJavaObjects(rawDocumentPayload, PayloadType.JSON).get(PayloadType.JSON);
		}else if(payloadType == PayloadType.XML) {
			document = (Document) Utilites.convertToJavaObjects(rawDocumentPayload, PayloadType.XML).get(PayloadType.XML);
		}else {
			docResp.setMessage("Document couldn't be processed.");
			return ResponseEntity.badRequest().body(docResp);
		}
		
		String documentId = Utilites.generateDocumentId(document, request.getHeader("x-document-type"));
		
		docustreamService.saveDocument(documentId, request.getHeader("x-document-type"), document.getDocumentBody().getContractNote().getClientDetails().getClientCode(), DocumentStatus.ACCEPTED, rawDocumentPayload);
		
		docResp.setDocumentId(documentId + ".pdf");
		docResp.setDocumentType(request.getHeader("x-document-type"));
		docResp.setDocumentGenerationDate(LocalDateTime.now().toString());
		docResp.setMessage("Document with Document ID: "+ documentId + " has been generated successfully!");
		System.out.println(docResp.toString());
		
		
		
		return ResponseEntity.ok(docResp);
	}
	
	@GetMapping("/getDocuments")
	public String getDocuments() {
		
		
		return "Documents";
	}

	@PostMapping(value = "/documents/uploadXML", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<String> uploadXML(@RequestHeader("x-document-type") @Pattern(regexp = "\\d+", message = "x-document-type must be numeric") String documentType, @RequestPart("file") MultipartFile file, HttpServletRequest request){
		
		
		Document document = new Document();
		DocumentResponse docResp = new DocumentResponse();
		FileType fileType = FileTypeDetector.detectFileType(file);
		
		byte[] rawDocumentPayload = null;
		
		try {
			rawDocumentPayload = file.getBytes();

			if (fileType == FileType.XML) {
				document = (Document) Utilites.convertToJavaObjects(rawDocumentPayload, PayloadType.XML)
						.get(PayloadType.XML);
			} else if (fileType == FileType.JSON) {
				document = (Document) Utilites.convertToJavaObjects(rawDocumentPayload, PayloadType.JSON).get(PayloadType.JSON);
			} else {
				docResp.setMessage("Document couldn't be processed.");
				return ResponseEntity.badRequest().body("Document File cannot be processed.");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		String documentId = Utilites.generateDocumentId(document, request.getHeader("x-document-type"));
		
		docustreamService.saveDocument(documentId, request.getHeader("x-document-type"), document.getDocumentBody().getContractNote().getClientDetails().getClientCode(),DocumentStatus.RECEIVED, rawDocumentPayload);
		
		
		
		
		/**
		String xmlContent = "";
		
		
		
		try {
			xmlContent = new String(file.getBytes(),StandardCharsets.UTF_8);
			
			byte[] pdfBytes = Utilites.sendForPDFBytes(xmlContent);
			
			
			
			
			Path pdfPath = Paths.get("src//main//resources//pdfDownload//" + documentId + ".pdf");
			Files.write(pdfPath, pdfBytes);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		**/
		
		
		
		return ResponseEntity.ok("XML Uploaded. Document Generated ID: " + documentId);
	}

	@ApiResponses({@ApiResponse(responseCode = "200", description = "PDF File", content = @Content(mediaType = MediaType.APPLICATION_PDF_VALUE, schema = @Schema(type = "string", format = "binary"))),@ApiResponse(responseCode = "404", description = "PDF not found")})
	@GetMapping(value = "/documents/{id}/download", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<Resource> downloadPdf(@PathVariable String id, @RequestParam(required = false, defaultValue = "generated")  String type){
		
		Path pdfPath = null;
		
		if("sample".equalsIgnoreCase(type)) {
			
			pdfPath = Paths.get("src//main//resources//samples//" + id + ".pdf");
			
		}else {
			pdfPath = Paths.get("src//main//resources//pdfDownload//" + id + ".pdf");
			
		}
		if(!Files.exists(pdfPath)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "PDF not generated or not available with name: " + id + ".pdf. Please check the name and try again.");
		}
		
		
		
		Resource resource = new FileSystemResource(pdfPath);
		
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF).header(HttpHeaders.CONTENT_DISPOSITION, "attachement; filename=\"" + id + ".pdf\"").header(HttpHeaders.CACHE_CONTROL, "no-cache, no-store, must-revalidate").header(HttpHeaders.PRAGMA, "no-cache").header(HttpHeaders.EXPIRES, "0").body(resource);
		
		
	}
	
	

}
