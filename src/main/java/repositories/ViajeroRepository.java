package repositories;

import entities.Viaje;
import entities.Viajero;
import jakarta.persistence.EntityManager;
import utils.JpaUtil;

import java.util.List;

public class ViajeroRepository extends JpaRepository<Viajero, Long> {
    public ViajeroRepository() {
        super(Viajero.class);
    }

    //CONSULTAS PERSONALIZADAS (JPQL)

    //Viajes del viajero 1 con más de 1 euro de gasto
    public List<Viaje> findViajesByViajeroIdAndPrecioGreaterThan(Long id, Double precio) {
        EntityManager em = JpaUtil.createEntityManager();
        try {
            return em.createQuery("SELECT v FROM Viaje v JOIN v.viajero vj " +
                            "WHERE vj.id = :id AND v.precio > :precio", Viaje.class)
                    .setParameter("id", id)
                    .setParameter("precio", precio)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    //Gasto total por viajero
    public List<String> findGastoTotalViajeros() {
        EntityManager em = JpaUtil.createEntityManager();
        try {
            List<Object[]> lista = em.createQuery("SELECT vj.nombre, SUM(v.precio)" +
                    "FROM Viaje v JOIN v.viajero vj GROUP BY vj.nombre", Object[].class).getResultList();

            return lista.stream()
                    .map(obj -> obj[0] + ": " + obj[1] + "€")
                    .toList();

        } finally {
            em.close();
        }
    }

}
