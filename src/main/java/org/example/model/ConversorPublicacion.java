package org.example.model;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class ConversorPublicacion implements AttributeConverter<Publicacion, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Publicacion publicacion) {
        if (publicacion == null)
            return null;
        else
            return publicacion.getIdPublicacion();
    }

    @Override
    public Publicacion convertToEntityAttribute(Integer idPublicacion) {
        if (idPublicacion == null) {
            return null;
        }
        for (Publicacion publicacion : Publicacion.values()) {
            if (publicacion.getIdPublicacion() == idPublicacion) {
                return publicacion;
            }
        }
        throw new IllegalArgumentException("Invalid id: " + idPublicacion);
    }
}
