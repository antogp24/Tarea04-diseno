package factory;

import composite.Component;
import model.ReservacionCultural;
import model.ReservacionEstandar;
import model.ReservacionFamiliar;
import model.ReservacionSuite;

public class ReservaHotelFactory implements ReservaFactory {

    @Override
    public Component reservarAventura() {
        return new ReservacionEstandar();
    }

    @Override
    public Component reservarEstandar() {
        return new ReservacionEstandar();
    }

    @Override
    public Component reservarFamiliar() {
        return new ReservacionFamiliar();
    }

    @Override
    public Component reservarSuite() {
        return new ReservacionSuite();
    }

    @Override
    public Component reservarCultural() {
        return new ReservacionCultural();
    }
}
