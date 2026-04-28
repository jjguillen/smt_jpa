import entities.TipoAbono;
import entities.Viaje;
import entities.Viajero;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import repositories.ViajeRepository;
import repositories.ViajeroRepository;
import utils.JpaUtil;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Main {

    static void main() {

        IO.println("Arrancando app Servicio Municipal de Transportes");

        ViajeroRepository viajeroRepo = new ViajeroRepository();
        ViajeRepository viajeRepo = new ViajeRepository();

        /*
        viajeroRepo.save(new Viajero(null, "58589874A","Manolo Lama",
                56, "Antas", TipoAbono.ANUAL, 150, null));
        viajeroRepo.save(new Viajero(null, "65432147B","Marta Prendes",
                38, "Vera", TipoAbono.MENSUAL, 110, null));


        Viajero v1 = viajeroRepo.findById(1L).orElse(null);
        v1.setSaldoPuntos(200);
        viajeroRepo.update(v1);


        Viajero v1 = viajeroRepo.findById(1L).orElse(null);
        Viajero v2 = viajeroRepo.findById(2L).orElse(null);

        viajeRepo.save(new Viaje(null, "Línea 1", "Antas", "Vera",
                LocalDate.now(), LocalTime.now(), 45, 2.5, false, v1));

        viajeRepo.save(new Viaje(null, "Línea 1", "Vera", "Antas",
                LocalDate.now(), LocalTime.now().plusHours(2), 47, 2.5,
                false, v1));

        viajeRepo.save(new Viaje(null, "Línea 2", "Mojácar", "Garrucha",
                LocalDate.now(), LocalTime.now(), 10, 1.5, false, v2));

        viajeRepo.save(new Viaje(null, "Línea 2", "Garrucha", "Mojácar",
                LocalDate.now(), LocalTime.now().plusHours(1), 13, 1.5,
                true, v2));
        */

        viajeRepo.findAll().stream()
                .collect(Collectors.groupingBy(Viaje::getLineaTransporte, Collectors.counting()))
                .forEach((k,v) -> IO.println(k + " " + v));

        viajeRepo.findWithIncidencia().forEach(System.out::println);

        viajeroRepo.findViajesByViajeroIdAndPrecioGreaterThan(1L, 1.5).forEach(System.out::println);

        IO.println("Gasto total por viajero");
        viajeroRepo.findGastoTotalViajeros().forEach(System.out::println);

        IO.println("Gasto total por viajero v2");
        viajeRepo.findAll().stream()
                .collect(Collectors.groupingBy(Viaje::getViajero, Collectors.summingDouble(Viaje::getPrecio)))
                .forEach((k,v) -> IO.println(k.getNombre() + ": " + v + "€"));

        IO.println("Viajero con más puntos");
        IO.println(viajeroRepo.findTop1ByPuntosDesc());




    }
}
