package org.example.dao;

import java.util.List;

public interface DAO<O, K> {
    void save(O object);

    void delete(O object);

    O get(K key);

    void update(O object);

    List<O> getAll();

    List<O> findByTituloContaining(String titulo, int offset, int limit);

    List<O> findByTituloContaining(String titulo);

    int countAll();

    int countByTitulo(String titulo);
}
