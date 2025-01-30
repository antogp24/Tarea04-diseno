package factory;

import composite.Reservacion;

public interface ReservaFactory {
    Reservacion reservarAventura();
    Reservacion reservarEstandar();
    Reservacion reservarFamiliar();
    Reservacion reservarSuite();
    Reservacion reservarCultural();
}
