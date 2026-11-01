package com.aps.docustream.renderer.type;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.aps.docustream.entities.enums.DocumentType;
import com.aps.docustream.renderer.HtmlRenderRequest;

@Component
public class HtmlRenderClient {

	private final WebClient webClient;

	public HtmlRenderClient(WebClient.Builder builder) {
		this.webClient = builder.baseUrl("http://localhost:3000").build();
	}
	
	public byte[] renderPdf(String documentId, byte[] payload, DocumentType documentType) {
		return webClient.post().uri("generate-pdf").bodyValue(new HtmlRenderRequest(documentId, payload, documentType)).retrieve().bodyToMono(byte[].class).block();
	}
	
	
}
