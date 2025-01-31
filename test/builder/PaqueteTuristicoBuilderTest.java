import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PaqueteTuristicoBuilderTest {
    private PaqueteTuristicoBuilder builder;
    private ReservacionHotel hotel;
    private ReservacionPaseo paseo;

    @Before
    public void setUp() {
        builder = new PaqueteTuristicoBuilder();
        hotel = new ReservacionHotel("suite", 2, 200.0);
        paseo = new ReservacionPaseo("cultural", 80.0);
    }

    /**
     * ID: PTB-001
     * Propósito: Verificar construcción de paquete básico
     * Precondiciones: Builder inicializado
     * Entradas: Hotel y paseo válidos
     * Salida esperada: Paquete construido correctamente
     */
    @Test
    public void testConstruirPaqueteBasico() {
        builder.reset();
        builder.agregarHotel(hotel);
        builder.agregarPaseo(paseo);
        PaqueteTuristico paquete = builder.build();
        assertNotNull(paquete);
    }

    /**
     * ID: PTB-002
     * Propósito: Verificar que falla al construir sin hotel
     * Precondiciones: Builder inicializado
     * Entradas: Solo paseo
     * Salida esperada: IllegalStateException
     */
    @Test(expected = IllegalStateException.class)
    public void testConstruirSinHotel() {
        builder.reset();
        builder.agregarPaseo(paseo);
        builder.build();
    }

    /**
     * ID: PTB-003
     * Propósito: Verificar reset del builder
     * Precondiciones: Builder con componentes agregados
     * Entradas: Ninguna
     * Salida esperada: Builder limpio
     */
    @Test
    public void testReset() {
        builder.agregarHotel(hotel);
        builder.reset();
        PaqueteTuristico paquete = builder.build();
        assertEquals(0.0, paquete.getPrecio(), 0.01);
    }
} 