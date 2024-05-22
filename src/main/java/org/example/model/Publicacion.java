package org.example.model;

public enum Publicacion {
    DOG(1, "Diario Oficial de Galicia"),
    BOE(2, "Boletín Ofical del Estado"),
    DOCE(3, "Diario Ofical de la Unión Europea");

    private final int idPublicacion;
    private final String descripcion;

    private Publicacion(int i, String s) {
        this.idPublicacion = i;
        this.descripcion = s;
    }

    public int getIdPublicacion() {
        return idPublicacion;
    }

    public String getdescripcion() {
        return descripcion;
    }
}
