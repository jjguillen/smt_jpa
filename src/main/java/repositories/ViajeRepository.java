package repositories;

import entities.Viaje;

public class ViajeRepository extends JpaRepository<Viaje, Long> {
    public ViajeRepository() {
        super(Viaje.class);
    }
}
