package factory;

import composite.Reservacion;
import model.*;

public class ReservaPaseoFactory implements ReservaFactory {

    @Override
    public Reservacion reservarAventura() {
        return new PaseoAventura();
    }

    @Override
    public Reservacion reservarEstandar() {
        return new PaseoEstandar();
    }

    @Override
    public Reservacion reservarFamiliar() {
        return new PaseoFamiliar();
    }

    @Override
    public Reservacion reservarSuite() {
        return new PaseoSuite();
    }

    @Override
    public Reservacion reservarCultural() {
        return new PaseoCultural();
    }
}
