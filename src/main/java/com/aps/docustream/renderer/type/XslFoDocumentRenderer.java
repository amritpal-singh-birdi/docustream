package com.aps.docustream.renderer.type;

import java.util.Set;

import org.springframework.stereotype.Component;

import com.aps.docustream.entities.enums.DocumentType;
import com.aps.docustream.entities.enums.PayloadType;
import com.aps.docustream.entities.enums.RendererType;
import com.aps.docustream.renderer.DocumentRenderer;
import com.aps.docustream.renderer.DocumentRendererContext;
import com.aps.docustream.renderer.RenderedDocument;
import com.aps.docustream.service.PdfGenerationService;
import com.aps.docustream.validators.PayloadTypeDetector;

@Component
public class XslFoDocumentRenderer implements DocumentRenderer {

	private final PdfGenerationService pdfGenerationService;

	public XslFoDocumentRenderer(PdfGenerationService pdfGenerationService) {
		super();
		this.pdfGenerationService = pdfGenerationService;
	}

	@Override
	public RendererType getRendererType() {
		return RendererType.XSL_FO;
	}

	@Override
	public Set<DocumentType> supports() {
		return Set.of(DocumentType.INVOICE, DocumentType.CONTRACT_NOTE, DocumentType.RESUME, DocumentType.RAW);
	}

	@Override
	public RenderedDocument render(DocumentRendererContext context) {

		///byte[] pdf = pdfGenerationService.generatePDF(context.getPayloadBytes(), context.getDocumentId(),
		//		context.getPayload().getDocumentType(),
		///		PayloadTypeDetector.checkAndValidatePayloadType(context.getPayloadBytes()));

		return null;// new RenderedDocument(pdf, "XSL-FO");
	}

}
