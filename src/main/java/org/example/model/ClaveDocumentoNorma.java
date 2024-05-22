package org.example.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ClaveDocumentoNorma implements Serializable {
    private final Integer idDocumento;
    private final Integer idNorma;

    public ClaveDocumentoNorma(Integer idDocumento, Integer idNorma) {
        this.idDocumento = idDocumento;
        this.idNorma = idNorma;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClaveDocumentoNorma that = (ClaveDocumentoNorma) o;
        return Objects.equals(idDocumento, that.idDocumento) && Objects.equals(idNorma, that.idNorma);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDocumento, idNorma);
    }
}
