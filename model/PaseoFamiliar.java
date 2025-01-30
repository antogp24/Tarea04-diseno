package model;

import composite.Component;

public class PaseoFamiliar implements Component {

    @Override
    public void cancelar() {
        // ...
    }

    @Override
    public void confirmar() {
        // ...
    }

    public double getPrecio() {
        return 300;
    }
}
