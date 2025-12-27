package com.aps.docustream.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.fop.apps.FOPException;
import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.xmlgraphics.util.MimeConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.aps.docustream.entities.enums.DocumentType;
import com.aps.docustream.entities.enums.PayloadType;
import com.aps.docustream.utils.Utilites;
import com.aps.docustream.wrapper.ContractNoteWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

@Service
public class PdfGenerationService {

	@Value("${file.xsl.path}")
	private String xslPath;

	@Value("${file.xml.path}")
	private String xmlPath;

	@Value("${file.output.path}")
	private String outputPath;

	public PdfGenerationService(@Value("${file.xsl.path}") String xslPath, @Value("${file.xml.path}") String xmlPath,
			@Value("${file.output.path}") String outputPath) {
		super();
		this.xslPath = xslPath;
		this.xmlPath = xmlPath;
		this.outputPath = outputPath;
	}

	public byte[] generatePDF(byte[] payload,String documentId, DocumentType documentType, PayloadType payloadType) {
		
		String xslName = "";
		String xmlName = "";
		String outputName = "";
		Class className = null;
		
		switch (documentType){
		case CONTRACT_NOTE:
			xslName = DocumentType.CONTRACT_NOTE.toString().concat(".xsl");
			xmlName = DocumentType.CONTRACT_NOTE.toString().concat(".xml");
			outputName = DocumentType.CONTRACT_NOTE.toString().concat(".pdf");
			className = ContractNoteWrapper.class;
			break;
		case INVOICE:
			xslName = DocumentType.INVOICE.toString().concat(".xsl");
			xmlName = DocumentType.CONTRACT_NOTE.toString().concat(".xml");
			outputName = DocumentType.CONTRACT_NOTE.toString().concat(".pdf");
			break;
		default:
			xslName = DocumentType.RAW.toString().concat(".xsl");
			xmlName = DocumentType.CONTRACT_NOTE.toString().concat(".xml");
			outputName = DocumentType.CONTRACT_NOTE.toString().concat(".pdf");
		}
		
		
		if(payloadType == PayloadType.JSON) {
			ObjectMapper objectMapper = new ObjectMapper();
			XmlMapper xmlMapper = new XmlMapper();
			try {
				
				Utilites.createXML(xmlMapper.writerWithDefaultPrettyPrinter().withRootName("contractNote").writeValueAsString(objectMapper.readTree(payload)), xmlPath.concat("//").concat(xmlName));
				generate(xmlPath.concat("//").concat(xmlName)
						, xslPath.concat("//").concat(xslName), outputPath.concat("//").concat(outputName));
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		return payload;
	}
	
	public static void generate(String xmlPath, String xslPath, String outputPath) {

		File xsltFile = new File(xslPath);
		StreamSource xmlSource = new StreamSource(new File(xmlPath));
		FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
		FOUserAgent foUserAgent = fopFactory.newFOUserAgent();

		OutputStream output;

		try {
			output = new java.io.FileOutputStream(outputPath);
			Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, output);
			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer(new StreamSource(xsltFile));
			Result result = new SAXResult(fop.getDefaultHandler());

			transformer.transform(xmlSource, result);

		} catch (FileNotFoundException | FOPException | TransformerException e) {

			// DocustreamExceptionHandling exceptionHandling = new
			// DocustreamExceptionHandling();
			// exceptionHandling.documentGenerationException(e);
			e.printStackTrace();
			return;
		}

	}

	
	
	
	
	
	
}
