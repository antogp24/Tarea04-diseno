package model;

import composite.Reservacion;

public class PaseoEstandar implements Reservacion {

    @Override
    public void cancelar() {
        // ...
    }

    @Override
    public void confirmar() {
        // ...
    }

    @Override
    public double getPrecio() {
        return 150;
    }
}
