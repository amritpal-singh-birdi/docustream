package com.aps.docustream.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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

import com.aps.docustream.entities.enums.PayloadType;
import com.aps.docustream.entities.to.Document;
import com.aps.docustream.entities.to.DocumentPayload;
import com.aps.docustream.entities.to.contractnote.ContractNote;
import com.aps.docustream.entities.to.invoice.Invoice;
import com.aps.docustream.exceptions.PayloadSerializationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class Utilites {

	public static Map<PayloadType, Object> convertToJavaObjects(byte[] rawDocumentPayload, PayloadType payloadType) {

		Map<PayloadType, Object> pojoMap = new HashMap<PayloadType, Object>();
		Document document = new Document();
		try {

			if (payloadType == PayloadType.JSON) {
				ObjectMapper objectMapper = new ObjectMapper();
				document = objectMapper.readValue(rawDocumentPayload, Document.class);
				pojoMap.put(PayloadType.JSON, document);
			} else if (payloadType == PayloadType.XML) {
				XmlMapper xmlMapper = new XmlMapper();
				document = xmlMapper.readValue(rawDocumentPayload, Document.class);
				pojoMap.put(PayloadType.XML, document);
			} else {
				pojoMap.put(PayloadType.UNKNOWN, document);
			}

		} catch (IOException e) {

		}

		return pojoMap;
	}

	public static void sendForPDF(String xml) {

		File xsltFile = new File("src//main//resources//xsls//contractNote.xsl");
		StreamSource xmlSource = new StreamSource(new File("src//main//resources//xml//contractNote.xml"));
		FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
		FOUserAgent foUserAgent = fopFactory.newFOUserAgent();

		OutputStream output;

		try {
			output = new java.io.FileOutputStream("src//main//resources//output//contractNote.pdf");
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

	public static void createXML(String xml, String xmlPath) {

		try {
			FileWriter fileWriter = new FileWriter(xmlPath);
			fileWriter.write(xml);
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static byte[] sendForPDFBytes(String xml) {

		File xsltFile = new File("src//main//resources//xsls//contractNote.xsl");
		StreamSource xmlSource = new StreamSource(new File("src//main//resources//xml//contractNote.xml"));
		FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
		FOUserAgent foUserAgent = fopFactory.newFOUserAgent();

		ByteArrayOutputStream output = new ByteArrayOutputStream();

		try {
			// output = new
			// java.io.FileOutputStream("src//main//resources//output//contractNote.pdf");
			Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, output);
			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer(new StreamSource(xsltFile));
			Result result = new SAXResult(fop.getDefaultHandler());

			transformer.transform(xmlSource, result);

		} catch (FOPException | TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return output.toByteArray();

	}

	public static String generateDocumentId(DocumentPayload document) {

		String datePart = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE);

		String uuidPart = UUID.randomUUID().toString().substring(0, 8).toUpperCase();

		return String.format("DOC_%s_%s_%s", document.getDocumentType(), datePart, uuidPart);

	}

	public static byte[] serializePayload(PayloadType type, DocumentPayload payload) {

		if (type == null) {
			throw new PayloadSerializationException("PayloadType cannot be null");
		}

		if (payload == null) {
			throw new PayloadSerializationException("PayloadType cannot be null");
		}

		try {
			switch (type) {
			case JSON:
				return new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsBytes(payload);
			case XML:
				return new XmlMapper().writerWithDefaultPrettyPrinter().writeValueAsBytes(payload);
			default:
				throw new PayloadSerializationException("Unsupported payload type: " + type);
			}
		} catch (JsonProcessingException e) {
			throw new PayloadSerializationException("Failed to serialize payload", e);
		}

	}

	public static byte[] serializePayload(PayloadType type, ContractNote payload) {

		if (type == null) {
			throw new PayloadSerializationException("PayloadType cannot be null");
		}

		if (payload == null) {
			throw new PayloadSerializationException("PayloadType cannot be null");
		}

		try {
			switch (type) {
			case JSON:
				return new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsBytes(payload);
			case XML:
				return new XmlMapper().writerWithDefaultPrettyPrinter().writeValueAsBytes(payload);
			default:
				throw new PayloadSerializationException("Unsupported payload type: " + type);
			}
		} catch (JsonProcessingException e) {
			throw new PayloadSerializationException("Failed to serialize payload", e);
		}

	}
	
	public static byte[] serializePayload(PayloadType type, Invoice payload) {

		if (type == null) {
			throw new PayloadSerializationException("PayloadType cannot be null");
		}

		if (payload == null) {
			throw new PayloadSerializationException("PayloadType cannot be null");
		}

		try {
			switch (type) {
			case JSON:
				return new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsBytes(payload);
			case XML:
				return new XmlMapper().writerWithDefaultPrettyPrinter().writeValueAsBytes(payload);
			default:
				throw new PayloadSerializationException("Unsupported payload type: " + type);
			}
		} catch (JsonProcessingException e) {
			throw new PayloadSerializationException("Failed to serialize payload", e);
		}

	}

}
