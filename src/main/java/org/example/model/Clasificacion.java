package org.example.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Clasificacion")
public class Clasificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idClasificacion")
    private Integer idClasificacion;
    @Column(name = "nome_g", unique = true)
    private String nomeG;
    @Column(name = "nome_c", unique = true)
    private String nomeC;
    //    @Lob
    @Column(name = "descripcion")
    private String descricion;

    // Relations
    @ManyToMany(cascade = CascadeType.ALL)
    @Basic(fetch = FetchType.LAZY)
    @JoinTable(
            name = "ClasificacionNorma",
            joinColumns = @JoinColumn(name = "idClasificacion"),
            inverseJoinColumns = @JoinColumn(name = "idNorma")
    )
    private List<Norma> normas;

    public Clasificacion() {
    }

    public Clasificacion(String nomeG, String nomeC, String descricion, List<Norma> normas) {
        this.nomeG = nomeG;
        this.nomeC = nomeC;
        this.descricion = descricion;
        this.normas = normas;
    }

    public Integer getIdClasificacion() {
        return idClasificacion;
    }

    public void setIdClasificacion(Integer idClasificacion) {
        this.idClasificacion = idClasificacion;
    }

    public String getNomeG() {
        return nomeG;
    }

    public void setNomeG(String nomeG) {
        this.nomeG = nomeG;
    }

    public String getNomeC() {
        return nomeC;
    }

    public void setNomeC(String nomeC) {
        this.nomeC = nomeC;
    }

    public String getDescricion() {
        return descricion;
    }

    public void setDescricion(String descricion) {
        this.descricion = descricion;
    }

    public List<Norma> getNormas() {
        return normas;
    }

    public void setNormas(List<Norma> normas) {
        this.normas = normas;
    }

    @Override
    public String toString() {
        return "Clasificacion{" +
                "idClasificacion=" + idClasificacion +
                ", nomeG='" + nomeG + '\'' +
                ", nomeC='" + nomeC + '\'' +
                ", descricion='" + descricion + '\'' +
                ", normas=" + normas +
                '}';
    }
}
