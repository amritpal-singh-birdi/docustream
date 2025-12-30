package com.aps.docustream.renderer.type;

import java.util.Set;

import org.springframework.stereotype.Component;

import com.aps.docustream.entities.enums.DocumentType;
import com.aps.docustream.entities.enums.RendererType;
import com.aps.docustream.renderer.DocumentRenderer;
import com.aps.docustream.renderer.DocumentRendererContext;
import com.aps.docustream.renderer.RenderedDocument;
import com.aps.docustream.service.PdfGenerationService;
import com.aps.docustream.validators.PayloadTypeDetector;

@Component
public class HtmlCssDocumentRenderer implements DocumentRenderer{

	private final PdfGenerationService pdfGenerationService;

	public HtmlCssDocumentRenderer(PdfGenerationService pdfGenerationService) {
		super();
		this.pdfGenerationService = pdfGenerationService;
	}

	@Override
	public RendererType getRendererType() {
		return RendererType.HTML_CSS;
	}

	@Override
	public Set<DocumentType> supports() {
		return Set.of(DocumentType.INVOICE);
	}

	@Override
	public RenderedDocument render(DocumentRendererContext context) {
		
		byte[] pdf = pdfGenerationService.generatePDF(context.getPayloadBytes(), context.getDocumentId(), context.getDocumentType(),
				PayloadTypeDetector.checkAndValidatePayloadType(context.getPayloadBytes()));

		return new RenderedDocument(pdf, "HTML-CSS");
	}
	
	
}
