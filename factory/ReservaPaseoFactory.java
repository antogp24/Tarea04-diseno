package factory;

import composite.Component;
import model.*;

public class ReservaPaseoFactory implements ReservaFactory {

    @Override
    public Component reservarAventura() {
        return new PaseoAventura();
    }

    @Override
    public Component reservarEstandar() {
        return new PaseoEstandar();
    }

    @Override
    public Component reservarFamiliar() {
        return new PaseoFamiliar();
    }

    @Override
    public Component reservarSuite() {
        return new PaseoSuite();
    }

    @Override
    public Component reservarCultural() {
        return new PaseoCultural();
    }
}
