package repositories;

import entities.Viajero;

public class ViajeroRepository extends JpaRepository<Viajero, Long> {
    public ViajeroRepository() {
        super(Viajero.class);
    }
}
