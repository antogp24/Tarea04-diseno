package factory;

import composite.Component;

public interface ReservaFactory {
    Component reservarAventura();
    Component reservarEstandar();
    Component reservarFamiliar();
    Component reservarSuite();
    Component reservarCultural();
}
