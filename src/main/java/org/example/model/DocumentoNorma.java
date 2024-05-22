package org.example.model;

import jakarta.persistence.*;

@Entity
@Table
public class DocumentoNorma {
    @EmbeddedId
    private ClaveDocumentoNorma documentoNormaId;

    @MapsId("idNorma")
    @ManyToOne
    @JoinColumn(name = "idNorma")
    private Norma norma;

    @MapsId("idDocumento")
    @ManyToOne
    @JoinColumn(name = "idDocumento")
    private Documento documento;

    public DocumentoNorma() {
    }

    public DocumentoNorma(ClaveDocumentoNorma documentoNormaId, Norma norma, Documento documento) {
        this.documentoNormaId = documentoNormaId;
        this.norma = norma;
        this.documento = documento;
    }

    public ClaveDocumentoNorma getDocumentoNormaId() {
        return documentoNormaId;
    }

    public void setDocumentoNormaId(ClaveDocumentoNorma documentoNormaId) {
        this.documentoNormaId = documentoNormaId;
    }

    public Norma getNorma() {
        return norma;
    }

    public void setNorma(Norma norma) {
        this.norma = norma;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }
}
