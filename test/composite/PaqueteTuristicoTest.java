import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PaqueteTuristicoTest {
    private PaqueteTuristico paquete;
    private ReservacionHotel hotel;
    private ReservacionPaseo paseo;

    @Before
    public void setUp() {
        paquete = new PaqueteTuristico("Paquete Test");
        hotel = new ReservacionHotel("suite", 2, 200.0);
        paseo = new ReservacionPaseo("cultural", 80.0);
    }

    /**
     * ID: PT-001
     * Propósito: Verificar que se pueden agregar componentes correctamente
     * Precondiciones: Paquete turístico inicializado
     * Entradas: ReservacionHotel y ReservacionPaseo
     * Salida esperada: Los componentes se agregan exitosamente
     */
    @Test
    public void testAgregarComponentes() {
        paquete.agregarComponente(hotel);
        paquete.agregarComponente(paseo);
        assertEquals(280.0, paquete.getPrecio(), 0.01);
    }

    /**
     * ID: PT-002
     * Propósito: Verificar que falla al agregar un componente null
     * Precondiciones: Paquete turístico inicializado
     * Entradas: Componente null
     * Salida esperada: NullPointerException
     */
    @Test(expected = NullPointerException.class)
    public void testAgregarComponenteNull() {
        paquete.agregarComponente(null);
    }

    /**
     * ID: PT-003
     * Propósito: Verificar que falla al quitar un componente que no existe
     * Precondiciones: Paquete turístico inicializado
     * Entradas: Componente no existente
     * Salida esperada: IllegalStateException
     */
    @Test(expected = IllegalStateException.class)
    public void testQuitarComponenteInexistente() {
        ReservacionHotel hotelInexistente = new ReservacionHotel("suite", 2, 200.0);
        paquete.quitarComponente(hotelInexistente);
    }
} 