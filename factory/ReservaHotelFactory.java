package factory;

import composite.Reservacion;
import model.ReservacionCultural;
import model.ReservacionEstandar;
import model.ReservacionFamiliar;
import model.ReservacionSuite;

public class ReservaHotelFactory implements ReservaFactory {

    @Override
    public Reservacion reservarAventura() {
        return new ReservacionEstandar();
    }

    @Override
    public Reservacion reservarEstandar() {
        return new ReservacionEstandar();
    }

    @Override
    public Reservacion reservarFamiliar() {
        return new ReservacionFamiliar();
    }

    @Override
    public Reservacion reservarSuite() {
        return new ReservacionSuite();
    }

    @Override
    public Reservacion reservarCultural() {
        return new ReservacionCultural();
    }
}
