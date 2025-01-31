package builder;

import composite.*;

public class PaqueteTuristicoBuilder implements PaqueteBuilder {
    private PaqueteTuristico paquete;
    private PaqueteAdicionales adicionales;

    public PaqueteTuristicoBuilder() {
        this.adicionales = new PaqueteAdicionales();
    }

    public void reset() {
        paquete = new PaqueteTuristico("Nuevo Paquete");
        adicionales.reset();
    }

    public void agregarHotel(ReservacionHotel hotel) {
        paquete.agregarComponente(hotel);
    }

    public void agregarPaseo(ReservacionPaseo paseo) {
        paquete.agregarComponente(paseo);
    }

    public PaqueteTuristico build() {
        PaqueteTuristico resultado = paquete;
        paquete.agregarAdicionales(adicionales.getAdicionales());
        reset();
        return resultado;
    }

    public void construirBasico(ReservacionHotel hotel, ReservacionPaseo paseo) {
        reset();
        agregarHotel(hotel);
        agregarPaseo(paseo);
        adicionales.agregarDescuento(0.1); // 10% de descuento
    }

    public void construirPremium(ReservacionHotel hotel, ReservacionPaseo paseo) {
        reset();
        agregarHotel(hotel);
        agregarPaseo(paseo);
        adicionales.agregarDescuento(0.2); // 20% de descuento
        adicionales.agregarServicioAdicional(new ServicioAdicional("Traslado", "Premium"));
        adicionales.agregarServicioAdicional(new ServicioAdicional("Spa", "Premium"));
    }
}

