package builder;

import composite.*;

public class PaqueteTuristicoBuilder implements PaqueteBuilder {
    private PaqueteTuristico paquete;

    private PaqueteAdicionales paqueteAdicionales;

    public void reset() {
        paquete = new PaqueteTuristico("Nuevo Paquete");
        paqueteAdicionales = new PaqueteAdicionales(); // Nueva instancia de PaqueteAdicionales
    }

    public void agregarHotel(ReservacionHotel hotel) {
        paquete.agregarComponente(hotel);
    }

    public void agregarPaseo(ReservacionPaseo paseo) {
        paquete.agregarComponente(paseo);
    }

    public void agregarDescuento(double porcentaje) {
        paqueteAdicionales.agregarDescuento(porcentaje); // Usamos PaqueteAdicionales
    }

    public void agregarServicioAdicional(ServicioAdicional servicio) {
        paqueteAdicionales.agregarServicioAdicional(servicio); // Usamos PaqueteAdicionales
    }

    public PaqueteTuristico build() {
        // Agregamos los adicionales al paquete turístico
        for (Adicional adicional : paqueteAdicionales.getAdicionales()) {
            paquete.agregarAdicional(adicional);
        }
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


