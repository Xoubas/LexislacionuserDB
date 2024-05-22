package org.example.model;

import jakarta.persistence.*;

import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "Documento")
public class Documento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDocumento")
    private Integer idDocumento;

    @Column(name = "mimeType")
    private String mimeType;

    @Column(name = "extension")
    private String extension;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "documento")
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] documento;

    @Column(name = "tamnho")
    private Integer tamanho;

    @Column(name = "idioma")
    private String idioma;

    //Relations
    @OneToMany(mappedBy = "documento")
    private List<DocumentoNorma> documentoNorma;

    public Documento() {
    }

    public Documento(String mimeType, String extension, String titulo, byte[] documento, Integer tamanho, String idioma, List<DocumentoNorma> documentoNorma) {
        this.mimeType = mimeType;
        this.extension = extension;
        this.titulo = titulo;
        this.documento = documento;
        this.tamanho = tamanho;
        this.idioma = idioma;
        this.documentoNorma = documentoNorma;
    }

    public Integer getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(Integer idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public byte[] getDocumento() {
        return documento;
    }

    public void setDocumento(byte[] documento) {
        this.documento = documento;
    }

    public Integer getTamanho() {
        return tamanho;
    }

    public void setTamanho(Integer tamanho) {
        this.tamanho = tamanho;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public List<DocumentoNorma> getDocumentoNorma() {
        return documentoNorma;
    }

    public void setDocumentoNorma(List<DocumentoNorma> documentoNorma) {
        this.documentoNorma = documentoNorma;
    }

    @Override
    public String toString() {
        return "Documento{" +
                "idDocumento=" + idDocumento +
                ", mimeType='" + mimeType + '\'' +
                ", extension='" + extension + '\'' +
                ", titulo='" + titulo + '\'' +
                ", documento=" + Arrays.toString(documento) +
                ", tamanho=" + tamanho +
                ", idioma='" + idioma + '\'' +
                ", documentoNorma=" + documentoNorma +
                '}';
    }
}
