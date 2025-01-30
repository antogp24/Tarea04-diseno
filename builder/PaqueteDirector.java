package builder;

import composite.*;

public class PaqueteDirector {
    private PaqueteBuilder builder;

    public PaqueteDirector(PaqueteBuilder builder) {
        this.builder = builder;
    }

    public void construirPaqueteBasico(ReservacionHotel hotel, ReservacionPaseo paseo) {
        builder.reset();
        builder.agregarHotel(hotel);
        builder.agregarPaseo(paseo);
        builder.agregarDescuento(0.1); // 10% de descuento base
    }

    public void construirPaquetePremium(ReservacionHotel hotel, ReservacionPaseo paseo) {
        builder.reset();
        builder.agregarHotel(hotel);
        builder.agregarPaseo(paseo);
        builder.agregarDescuento(0.2); // 20% de descuento
        builder.agregarServicioAdicional(new ServicioAdicional("Traslado", "Premium"));
        builder.agregarServicioAdicional(new ServicioAdicional("Spa", "Premium"));
    }
} 