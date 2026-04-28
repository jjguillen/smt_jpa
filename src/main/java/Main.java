import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import utils.JpaUtil;

public class Main {

    static void main() {

        IO.println("Arrancando app Servicio Municipal de Transportes");
        EntityManager em = JpaUtil.createEntityManager();




    }
}
