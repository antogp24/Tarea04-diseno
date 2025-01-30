package builder;

import composite.*;

public class PaqueteTuristicoBuilder implements PaqueteBuilder {
    private PaqueteTuristico paquete;

    public void reset() {
        paquete = new PaqueteTuristico("Nuevo Paquete");
    }

    public void agregarHotel(ReservacionHotel hotel) {
        paquete.agregarComponente(hotel);
    }

    public void agregarPaseo(ReservacionPaseo paseo) {
        paquete.agregarComponente(paseo);
    }

    public void agregarDescuento(double porcentaje) {
        Descuento descuento = new Descuento(porcentaje);
        paquete.agregarAdicional(descuento);
    }

    public void agregarServicioAdicional(ServicioAdicional servicio) {
        paquete.agregarAdicional(servicio);
    }

    public PaqueteTuristico build() {
        PaqueteTuristico resultado = paquete;
        reset();
        return resultado;
    }
} 