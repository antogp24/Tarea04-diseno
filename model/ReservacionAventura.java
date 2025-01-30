package model;

import composite.ReservacionPaseo;

public class ReservacionAventura extends ReservacionPaseo {
    public ReservacionAventura() {
        super("aventura", 120.0);  // Default values for adventure tour
    }

    @Override
    public void cancelar() {
        // ...
    }

    @Override
    public void confirmar() {
        // ...
    }
}
