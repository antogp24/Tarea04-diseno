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
    public void construirBasico(ReservacionHotel hotel, ReservacionPaseo paseo) {
        reset();
        agregarHotel(hotel);
        agregarPaseo(paseo);
        agregarDescuento(0.1); // 10% de descuento
    }

    
    public void construirPremium(ReservacionHotel hotel, ReservacionPaseo paseo) {
        reset();
        agregarHotel(hotel);
        agregarPaseo(paseo);
        agregarDescuento(0.2); // 20% de descuento
        agregarServicioAdicional(new ServicioAdicional("Traslado", "Premium"));
        agregarServicioAdicional(new ServicioAdicional("Spa", "Premium"));
    }   
} 
