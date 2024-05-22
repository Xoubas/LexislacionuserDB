package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.example.connection.JPAUtil;
import org.example.model.Norma;
import org.example.model.NormaDTO;

import java.util.List;

public class AppConsultas {
    public static void main(String[] args) {
//        todasNormasClasificaciones();
//        todasNormasRangoLegal();
//        normasPorIdRango();
        namedQueries();
    }

    static void todasNormasClasificaciones() {
        EntityManager em = JPAUtil.getEntityManager(JPAUtil.LEXISLACIONPOSTGRES);

        //Numero de normas de las clasificaciones
        String select = "SELECT c.nomeG AS clasificacion, COUNT(n.idNorma) " +
                "FROM Clasificacion c " +
                "LEFT JOIN c.normas n " +
                "GROUP BY c.nomeG";

        Query query = em.createQuery(select);
        List<Object[]> resultList = query.getResultList();
        for (Object[] result : resultList) {
            String nombreClasificacion = (String) result[0];
            Long cantidadNormas = (Long) result[1];
            System.out.println(nombreClasificacion + ", Cantidad de Normas: " + cantidadNormas);
        }
        em.close();
    }

    static void todasNormasRangoLegal() {
        EntityManager em = JPAUtil.getEntityManager(JPAUtil.LEXISLACIONPOSTGRES);

        //Número de normas de los rangos legales
        String select = "SELECT rl.idRangoLegal as id, rl.nomeG as rangoLegal, COUNT(n.idNorma) " +
                "FROM RangoLegal rl " +
                "LEFT JOIN Norma n ON rl.idRangoLegal = n.rangoLegal.idRangoLegal " +
                "GROUP BY rl.nomeG, rl.idRangoLegal " +
                "ORDER BY rl.idRangoLegal ASC";

        Query query = em.createQuery(select);
        List<Object[]> resultList = query.getResultList();
        for (Object[] result : resultList) {
            Integer idRangoLegal = (Integer) result[0];
            String nombreRangoLegal = (String) result[1];
            Long cantidadNormas = (Long) result[2];
            System.out.println("ID: " + idRangoLegal + ", Rango Legal: " + nombreRangoLegal + ", Cantidad de Normas: " + cantidadNormas);
        }
        em.close();
    }

    static void normasPorIdRango() {
        EntityManager em = JPAUtil.getEntityManager(JPAUtil.LEXISLACIONPOSTGRES);

        TypedQuery<NormaDTO> q = em.createQuery("SELECT new org.example.model.NormaDTO(n.idNorma, n.titulo, n.dataNorma, n.dataPublicacion, n.derogada) " +
                "FROM Norma n " +
                "WHERE n.rangoLegal.idRangoLegal = :id", NormaDTO.class);

        q.setParameter("id", 5);
        List<NormaDTO> resultList = q.getResultList();

        for (NormaDTO norma : resultList) {
            System.out.println(norma);
        }
        em.close();
    }

    static void namedQueries() {
        EntityManager em = JPAUtil.getEntityManager(JPAUtil.LEXISLACIONPOSTGRES);

        TypedQuery<Norma> qFindByTitulo = em.createNamedQuery("Norma.findByTitulo", Norma.class);
        TypedQuery<Norma> qCountByTitulo = em.createNamedQuery("Norma.countByTitulo", Norma.class);

        qFindByTitulo.setParameter("titulo", "ORDE DO 20 DE XANEIRO DE 2000 POLA QUE SE FIXAN AS NORMAS XERAIS DE PESCA NAS AUGAS CONTINENTAIS DA COMUNIDADE AUTÓNOMA DE GALICIA");
        qCountByTitulo.setParameter("titulo", "ORDE DO 20 DE XANEIRO DE 2000 POLA QUE SE FIXAN AS NORMAS XERAIS DE PESCA NAS AUGAS CONTINENTAIS DA COMUNIDADE AUTÓNOMA DE GALICIA");
        List<Norma> resultList = qFindByTitulo.getResultList();
        System.out.println("Nº de normas: "+qCountByTitulo.getSingleResult());

        for (Norma norma : resultList) {
            System.out.println(norma);
        }
        em.close();
    }
}
