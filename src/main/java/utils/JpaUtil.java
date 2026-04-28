package utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {

    // Nombre debe coincidir con el atributo "name" del persistence-unit
    private static final EntityManagerFactory emf;
    static {
        try {
            emf = Persistence.createEntityManagerFactory("smt-pu");
            System.out.println("✅ JPA iniciado correctamente.");
        } catch (Exception e) {
            System.err.println("❌ Error al iniciar JPA: " + e.getMessage());
            throw new ExceptionInInitializerError(e);
        }
    }
    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }
    public static EntityManager createEntityManager() {
        return emf.createEntityManager();
    }
    public static void shutdown() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }

}
