package org.example.dao;

import jakarta.persistence.EntityManager;
import org.example.connection.JPAUtil;
import org.example.model.Norma;
import org.example.model.NormaDTO;

import java.util.List;

public class NormaDAO implements DAO<NormaDTO, Integer> {
    private final EntityManager em;

    public NormaDAO(String persistenceUnit) {
        this.em = JPAUtil.getEntityManager(persistenceUnit);
    }

    @Override
    public void save(NormaDTO normaDto) {
        try {
            em.getTransaction().begin();
            em.persist(new Norma(normaDto.getIdNorma(), normaDto.getTitulo(), normaDto.getDataNorma(), normaDto.getDataPublicacion(), normaDto.isDerogada()));
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e.getCause());
        }
    }

    @Override
    public void delete(NormaDTO norma) {
        try {
            em.getTransaction().begin();
            if (em.find(Norma.class, norma.getIdNorma()) != null) {
                em.remove(norma);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e.getCause());
        }
    }

    @Override
    public NormaDTO get(Integer key) {
        Norma norma = em.find(Norma.class, key);
        if (norma != null) {
            return new NormaDTO(norma.getIdNorma(), norma.getTitulo(), norma.getDataNorma(), norma.getDataPublicacion(), norma.isDerogada());
        }
        return null;
    }

    @Override
    public void update(NormaDTO normaDto) {
        em.getTransaction().begin();
        Norma norma = em.find(Norma.class, normaDto.getIdNorma());
        if (norma != null) {
            norma.setIdNorma(normaDto.getIdNorma());
            norma.setTitulo(normaDto.getTitulo());
            norma.setDataNorma(normaDto.getDataNorma());
            norma.setDataPublicacion(normaDto.getDataPublicacion());
            norma.setDerogada(normaDto.isDerogada());
            em.merge(norma);
        }
        em.getTransaction().commit();
    }

    @Override
    public List<NormaDTO> getAll() {
        return null;
    }

    @Override
    public List<NormaDTO> findByTituloContaining(String titulo, int offset, int limit) {
        return null;
    }

    @Override
    public List<NormaDTO> findByTituloContaining(String titulo) {
        return null;
    }

    @Override
    public int countAll() {
        return 0;
    }

    @Override
    public int countByTitulo(String titulo) {
        return 0;
    }
}
