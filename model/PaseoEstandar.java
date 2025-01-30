package model;

import composite.Component;

public class PaseoEstandar implements Component {

    @Override
    public void cancelar() {
        // ...
    }

    @Override
    public void confirmar() {
        // ...
    }

    public double getPrecio() {
        return 150;
    }
}
