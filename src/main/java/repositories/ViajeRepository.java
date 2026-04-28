package repositories;

import entities.Viaje;
import jakarta.persistence.EntityManager;
import utils.JpaUtil;

import java.util.List;

public class ViajeRepository extends JpaRepository<Viaje, Long> {

    public ViajeRepository() {
        super(Viaje.class);
    }

    // CONSULTAS PERSONALIZADAS (JPQL)

    /**
     * Busca todos los viajes que tengan incidencia.
     * @return
     */
    public List<Viaje> findWithIncidencia() {
        EntityManager em = JpaUtil.createEntityManager();
        try {
            return em.createQuery("FROM Viaje v WHERE v.incidencia = true", Viaje.class)
                    .getResultList();
        } finally {
            em.close();
        }
    }



}
