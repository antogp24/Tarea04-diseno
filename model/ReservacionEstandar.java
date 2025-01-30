package model;

import composite.ReservacionHotel;

public class ReservacionEstandar extends ReservacionHotel {
    public ReservacionEstandar() {
        super("estandar", 2, 100.0);  // Default values for standard room
    }
}
