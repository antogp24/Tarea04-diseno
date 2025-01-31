package builder;

import composite.*;

public interface PaqueteBuilder {
    void reset();
    void agregarHotel(ReservacionHotel hotel);
    void agregarPaseo(ReservacionPaseo paseo);
    void agregarDescuento(double porcentaje);
    void agregarServicioAdicional(ServicioAdicional servicio);
    PaqueteTuristico build();
} 
