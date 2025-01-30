package model;

import composite.Reservacion;

public class PaseoFamiliar implements Reservacion {

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
        return 300;
    }
}
