package com.aps.docustream.renderer;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.aps.docustream.entities.enums.RendererType;

@Component
public class DocumentRendererFactory {

    private final Map<RendererType, DocumentRenderer> rendererMap;

    public DocumentRendererFactory(List<DocumentRenderer> renderers) {
        this.rendererMap = renderers.stream()
                .collect(Collectors.toMap(
                        DocumentRenderer::getRendererType,
                        Function.identity()
                ));
    }

    public DocumentRenderer getRenderer(RendererType type) {
        DocumentRenderer renderer = rendererMap.get(type);
        if (renderer == null) {
            throw new IllegalArgumentException("No renderer found for " + type);
        }
        return renderer;
    }
}