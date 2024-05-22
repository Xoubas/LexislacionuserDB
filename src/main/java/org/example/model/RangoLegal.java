package org.example.model;

import jakarta.persistence.*;

@Entity
@Table
public class RangoLegal {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRangoLegal;

    @Column(name = "nome_g", length = 128, unique = true)
    private String nomeG;

    @Column(name = "nome_c", length = 128, unique = true)
    private String nomeC;

    public RangoLegal() {
    }

    public RangoLegal(String nomeG, String nomeC) {
        this.nomeG = nomeG;
        this.nomeC = nomeC;
    }

    public Integer getIdRangoLegal() {
        return idRangoLegal;
    }

    public void setIdRangoLegal(Integer idRangoLegal) {
        this.idRangoLegal = idRangoLegal;
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

    @Override
    public String toString() {
        return "RangoLegal{" +
                "idRangoLegal=" + idRangoLegal +
                ", nomeG='" + nomeG + '\'' +
                ", nomeC='" + nomeC + '\'' +
                '}';
    }
}
