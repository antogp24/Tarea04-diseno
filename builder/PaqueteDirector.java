package builder;

package builder;

import composite.*;

public class PaqueteDirector {
    private final PaqueteBuilder builder;

    public PaqueteDirector(PaqueteBuilder builder) {
        this.builder = builder;
    }

    public void construirPaqueteBasico(ReservacionHotel hotel, ReservacionPaseo paseo) {
        builder.construirBasico(hotel, paseo);
    }

    public void construirPaquetePremium(ReservacionHotel hotel, ReservacionPaseo paseo) {
        builder.construirPremium(hotel, paseo);
    }
}
