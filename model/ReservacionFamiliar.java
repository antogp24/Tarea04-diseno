package model;

import composite.ReservacionHotel;

public class ReservacionFamiliar extends ReservacionHotel {
    public ReservacionFamiliar() {
        super("familiar", 4, 150.0);  // Default values for family room: 4 beds, $150
    }
}
