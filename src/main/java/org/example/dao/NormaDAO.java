package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.example.connection.JPAUtil;
import org.example.model.Norma;
import org.example.model.NormaDTO;

import java.util.List;

public class NormaDAO implements DAO<Norma, Integer> {
    private final EntityManager em;

    public NormaDAO(String persistenceUnit) {
        this.em = JPAUtil.getEntityManager(persistenceUnit);
    }

    @Override
    public void save(Norma norma) {
        try {
            em.getTransaction().begin();
            em.persist(norma);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e.getCause());
        }
    }

    @Override
    public void delete(Norma norma) {
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
    public Norma get(Integer key) {
        Norma norma = em.find(Norma.class, key);
        if (norma != null) {
            return norma;
        }
        return null;
    }

    @Override
    public void update(Norma norma) {
        em.getTransaction().begin();
        Norma n = em.find(Norma.class, norma.getIdNorma());
        if (norma != null) {
            em.merge(norma);
        }
        em.getTransaction().commit();
    }

    @Override
    public List<Norma> getAll() {
        TypedQuery<Norma> q = em.createQuery("SELECT new org.example.model.NormaDTO(n.idNorma, n.titulo, n.dataNorma, n.dataPublicacion, n.derogada) " +
                "FROM Norma n", Norma.class);

        return q.getResultList();
    }

    @Override
    public List<Norma> findByTituloContaining(String titulo, int offset, int limit) {
        TypedQuery<Norma> query = em.createQuery("SELECT n " +
                "FROM Norma n " +
                "WHERE n.titulo LIKE :titulo", Norma.class);
        query.setParameter("titulo", "%" + titulo + "%");
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.getResultList();
    }

    @Override
    public List<Norma> findByTituloContaining(String titulo) {
        TypedQuery<Norma> query = em.createQuery("SELECT n " +
                "FROM Norma n WHERE n.titulo LIKE :titulo", Norma.class);

        query.setParameter("titulo", "%" + titulo + "%");
        return query.getResultList();
    }

    @Override
    public int countAll() {
        TypedQuery<Long> query = em.createQuery("SELECT COUNT(n) FROM Norma n", Long.class);
        return query.getSingleResult().intValue();
    }

    @Override
    public int countByTitulo(String titulo) {
        TypedQuery<Integer> q = em.createQuery("SELECT COUNT(n) " +
                "FROM Norma n " +
                "WHERE n.titulo LIKE :titulo", Integer.class);

        q.setParameter("titulo", "%" + titulo + "%");
        return q.getSingleResult();
    }

    public List<Object[]> todasNormasClasificaciones() {
        EntityManager em = JPAUtil.getEntityManager(JPAUtil.LEXISLACIONPOSTGRES);

        //Numero de normas de las clasificaciones
        String select = "SELECT c.nomeG AS clasificacion, COUNT(n.idNorma) " +
                "FROM Clasificacion c " +
                "LEFT JOIN c.normas n " +
                "GROUP BY c.nomeG";

        TypedQuery<Object[]> query = em.createQuery(select, Object[].class);
        return query.getResultList();
    }

//    public List todasNormasRangoLegal() {
//        EntityManager em = JPAUtil.getEntityManager(JPAUtil.LEXISLACIONPOSTGRES);
//
//        //Número de normas de los rangos legales
//        String select = "SELECT rl.idRangoLegal as id, rl.nomeG as rangoLegal, COUNT(n.idNorma) " +
//                "FROM RangoLegal rl " +
//                "LEFT JOIN Norma n ON rl.idRangoLegal = n.rangoLegal.idRangoLegal " +
//                "GROUP BY rl.nomeG, rl.idRangoLegal " +
//                "ORDER BY rl.idRangoLegal ASC";
//
//        Query query = em.createQuery(select);
//        return query.getResultList();
//    }

    public List<NormaDTO> normasPorIdRango() {
        EntityManager em = JPAUtil.getEntityManager(JPAUtil.LEXISLACIONPOSTGRES);

        TypedQuery<NormaDTO> q = em.createQuery("SELECT new org.example.model.NormaDTO(n.idNorma, n.titulo, n.dataNorma, n.dataPublicacion, n.derogada) " +
                "FROM Norma n " +
                "WHERE n.rangoLegal.idRangoLegal = :id", NormaDTO.class);

        q.setParameter("id", 5);
        return q.getResultList();
    }

    public void close() {
        em.close();
    }

//    public void namedQueries() {
//        EntityManager em = JPAUtil.getEntityManager(JPAUtil.LEXISLACIONPOSTGRES);
//
//        TypedQuery<Norma> qFindByTitulo = em.createNamedQuery("Norma.findByTitulo", Norma.class);
//        TypedQuery<Norma> qCountByTitulo = em.createNamedQuery("Norma.countByTitulo", Norma.class);
//
//        qFindByTitulo.setParameter("titulo", "ORDE DO 20 DE XANEIRO DE 2000 POLA QUE SE FIXAN AS NORMAS XERAIS DE PESCA NAS AUGAS CONTINENTAIS DA COMUNIDADE AUTÓNOMA DE GALICIA");
//        qCountByTitulo.setParameter("titulo", "ORDE DO 20 DE XANEIRO DE 2000 POLA QUE SE FIXAN AS NORMAS XERAIS DE PESCA NAS AUGAS CONTINENTAIS DA COMUNIDADE AUTÓNOMA DE GALICIA");
//        List<Norma> resultList = qFindByTitulo.getResultList();
//        System.out.println("Nº de normas: " + qCountByTitulo.getSingleResult());
//
//        for (Norma norma : resultList) {
//            System.out.println(norma);
//        }
//        em.close();
//    }
}
