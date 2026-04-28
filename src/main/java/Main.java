import entities.TipoAbono;
import entities.Viaje;
import entities.Viajero;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import repositories.ViajeroRepository;
import utils.JpaUtil;

import java.util.ArrayList;

public class Main {

    static void main() {

        IO.println("Arrancando app Servicio Municipal de Transportes");

        ViajeroRepository viajeroRepo = new ViajeroRepository();

        /*
        viajeroRepo.save(new Viajero(null, "58589874A","Manolo Lama",
                56, "Antas", TipoAbono.ANUAL, 150, null));
        viajeroRepo.save(new Viajero(null, "65432147B","Marta Prendes",
                38, "Vera", TipoAbono.MENSUAL, 110, null));


        Viajero v1 = viajeroRepo.findById(1L).orElse(null);
        v1.setSaldoPuntos(200);
        viajeroRepo.update(v1);
         */



    }
}
