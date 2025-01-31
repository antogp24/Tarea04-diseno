import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PaqueteDirectorTest {
    private PaqueteDirector director;
    private PaqueteTuristicoBuilder builder;
    private ReservacionHotel hotel;
    private ReservacionPaseo paseo;

    @Before
    public void setUp() {
        builder = new PaqueteTuristicoBuilder();
        director = new PaqueteDirector(builder);
        hotel = new ReservacionHotel("suite", 2, 200.0);
        paseo = new ReservacionPaseo("cultural", 80.0);
    }

    /**
     * ID: PD-001
     * Propósito: Verificar construcción de paquete básico
     * Precondiciones: Director inicializado
     * Entradas: Hotel y paseo válidos
     * Salida esperada: Paquete básico construido correctamente
     */
    @Test
    public void testConstruirPaqueteBasico() {
        director.construirPaqueteBasico(hotel, paseo);
        PaqueteTuristico paquete = builder.build();
        assertNotNull(paquete);
    }

    /**
     * ID: PD-002
     * Propósito: Verificar construcción de paquete premium
     * Precondiciones: Director inicializado
     * Entradas: Hotel y paseo válidos
     * Salida esperada: Paquete premium construido correctamente
     */
    @Test
    public void testConstruirPaquetePremium() {
        director.construirPaquetePremium(hotel, paseo);
        PaqueteTuristico paquete = builder.build();
        assertNotNull(paquete);
    }

    /**
     * ID: PD-003
     * Propósito: Verificar que falla al construir con componentes null
     * Precondiciones: Director inicializado
     * Entradas: Hotel null, paseo null
     * Salida esperada: NullPointerException
     */
    @Test(expected = NullPointerException.class)
    public void testConstruirConComponentesNull() {
        director.construirPaqueteBasico(null, null);
    }
} 