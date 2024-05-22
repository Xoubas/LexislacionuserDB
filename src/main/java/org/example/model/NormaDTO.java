package org.example.model;

import java.sql.Clob;
import java.sql.SQLException;
import java.time.LocalDate;

public class NormaDTO {
    private Integer idNorma;
    private String titulo;
    private LocalDate dataNorma;
    private LocalDate dataPublicacion;
    private boolean derogada;

    public NormaDTO() {
    }

    public NormaDTO(Integer idNorma, String titulo, LocalDate dataNorma, LocalDate dataPublicacion, boolean derogada) {
        this.idNorma = idNorma;
        this.titulo = titulo;
        this.dataNorma = dataNorma;
        this.dataPublicacion = dataPublicacion;
        this.derogada = derogada;
    }

//    private String clobToString(Clob clob) {
//        if (clob == null) {
//            return null;
//        }
//        try {
//            return clob.getSubString(1, (int) clob.length());
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }

    public Integer getIdNorma() {
        return idNorma;
    }

    public void setIdNorma(Integer idNorma) {
        this.idNorma = idNorma;
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

    @Override
    public String toString() {
        return "NormaDTO{" +
                "idNorma=" + idNorma +
                ", titulo='" + titulo + '\'' +
                ", dataNorma=" + dataNorma +
                ", dataPublicacion=" + dataPublicacion +
                ", derogada=" + derogada +
                '}';
    }
}
