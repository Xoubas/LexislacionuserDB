package org.example.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table
@NamedQueries({
        @NamedQuery(name = "Norma.findByTitulo", query = "SELECT n FROM Norma n WHERE n.titulo = :titulo"),
        @NamedQuery(name = "Norma.countByTitulo", query = "SELECT COUNT(n) FROM Norma n WHERE n.titulo = :titulo")
})
public class Norma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idNorma")
    private Integer idNorma;

    @Column(name = "numeroPublicacion")
    private Integer numeroPublicacion;

    @Convert(converter = ConversorPublicacion.class)
    @Column(name = "idPublicacion")
    private Publicacion publicacion;

    @Column(name = "numeroPaxina")
    private Integer numeroPaxina;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "dataNorma")
    private LocalDate dataNorma;

    @Column(name = "dataPublicacion")
    private LocalDate dataPublicacion;

    @Column(name = "derogada")
    private boolean derogada;

    //Relations
    @ManyToMany(mappedBy = "normas", cascade = CascadeType.ALL)
    @Basic(fetch = FetchType.LAZY)
    private List<Clasificacion> clasificaciones;

    @OneToMany(mappedBy = "norma")
    private List<DocumentoNorma> documentoNorma;

    @ManyToOne
    @JoinColumn(name = "idOrganismo", nullable = false)
    private Organismo organismo;

    @ManyToOne
    @JoinColumn(name = "idRangoLegal", nullable = false)
    private RangoLegal rangoLegal;

    public Norma() {
    }

    public Norma(Integer numeroPublicacion, Publicacion publicacion, Integer numeroPaxina, String titulo, LocalDate dataNorma, LocalDate dataPublicacion, boolean derogada, List<Clasificacion> clasificaciones, List<DocumentoNorma> documentoNorma, Organismo organismo, RangoLegal rangoLegal) {
        this.numeroPublicacion = numeroPublicacion;
        this.publicacion = publicacion;
        this.numeroPaxina = numeroPaxina;
        this.titulo = titulo;
        this.dataNorma = dataNorma;
        this.dataPublicacion = dataPublicacion;
        this.derogada = derogada;
        this.clasificaciones = clasificaciones;
        this.documentoNorma = documentoNorma;
        this.organismo = organismo;
        this.rangoLegal = rangoLegal;
    }

    public Norma(Integer idNorma, String titulo, LocalDate dataNorma, LocalDate dataPublicacion, boolean derogada) {
        this.idNorma = idNorma;
        this.titulo = titulo;
        this.dataNorma = dataNorma;
        this.dataPublicacion = dataPublicacion;
        this.derogada = derogada;
    }

    public Integer getIdNorma() {
        return idNorma;
    }

    public void setIdNorma(Integer idNorma) {
        this.idNorma = idNorma;
    }

    public Integer getNumeroPublicacion() {
        return numeroPublicacion;
    }

    public void setNumeroPublicacion(Integer numeroPublicacion) {
        this.numeroPublicacion = numeroPublicacion;
    }

    public Publicacion getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }

    public Integer getNumeroPaxina() {
        return numeroPaxina;
    }

    public void setNumeroPaxina(Integer numeroPaxina) {
        this.numeroPaxina = numeroPaxina;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getDataNorma() {
        return dataNorma;
    }

    public void setDataNorma(LocalDate dataNorma) {
        this.dataNorma = dataNorma;
    }

    public LocalDate getDataPublicacion() {
        return dataPublicacion;
    }

    public void setDataPublicacion(LocalDate dataPublicacion) {
        this.dataPublicacion = dataPublicacion;
    }

    public boolean isDerogada() {
        return derogada;
    }

    public void setDerogada(boolean derogada) {
        this.derogada = derogada;
    }

    public List<Clasificacion> getClasificaciones() {
        return clasificaciones;
    }

    public void setClasificaciones(List<Clasificacion> clasificaciones) {
        this.clasificaciones = clasificaciones;
    }

    public List<DocumentoNorma> getDocumentoNorma() {
        return documentoNorma;
    }

    public void setDocumentoNorma(List<DocumentoNorma> documentoNorma) {
        this.documentoNorma = documentoNorma;
    }

    public Organismo getOrganismo() {
        return organismo;
    }

    public void setOrganismo(Organismo organismo) {
        this.organismo = organismo;
    }

    public RangoLegal getRangoLegal() {
        return rangoLegal;
    }

    public void setRangoLegal(RangoLegal rangoLegal) {
        this.rangoLegal = rangoLegal;
    }

    @Override
    public String toString() {
        return "Norma{" +
                "idNorma=" + idNorma +
                ", numeroPublicacion=" + numeroPublicacion +
                ", numeroPaxina=" + numeroPaxina +
                ", titulo=" + titulo +
                ", dataNorma=" + dataNorma +
                ", dataPublicacion=" + dataPublicacion +
                ", derogada=" + derogada +
                ", organismo=" + organismo.getNome() +
                '}';
    }
}
