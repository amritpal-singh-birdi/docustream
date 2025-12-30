package com.aps.docustream.renderer;

public class RenderedDocument {

	private final byte[] pdfBytes;
	
	private final String mimeType;
	
	private final String renderer;

	public RenderedDocument(byte[] pdfBytes, String renderer) {
		super();
		this.pdfBytes = pdfBytes;
		this.mimeType = "application/pdf";
		this.renderer = renderer;
	}

	public byte[] getPdfBytes() {
		return pdfBytes;
	}

	public String getMimeType() {
		return mimeType;
	}

	public String getRenderer() {
		return renderer;
	}
	
	
	
}
