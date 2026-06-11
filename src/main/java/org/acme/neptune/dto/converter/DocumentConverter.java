package org.acme.neptune.dto.converter;

import jakarta.enterprise.context.ApplicationScoped;
import org.acme.neptune.dto.DocumentDTO;
import org.acme.neptune.entity.Document;

@ApplicationScoped
public class DocumentConverter {


    public Document convertToDocument(DocumentDTO documentDTO) {
        return new Document(documentDTO.getId(), documentDTO.getType(), null, null);
    }

    public DocumentDTO convertToDocumentDTO(Document document) {
        return new DocumentDTO(document.getId(), document.getType(), null, null);
    }
}