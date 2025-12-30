package com.aps.docustream.renderer;

import java.util.Set;

import com.aps.docustream.entities.enums.DocumentType;
import com.aps.docustream.entities.enums.RendererType;

public interface DocumentRenderer {

	RendererType getRendererType();
	
	Set<DocumentType> supports();
	
	RenderedDocument render(DocumentRendererContext context);
}
