import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ReservacionManagerTest {
    private ReservacionManager manager;
    private ReservacionHotel hotel;
    private String correoUsuario;

    @Before
    public void setUp() {
        manager = ReservacionManager.getInstance();
        hotel = new ReservacionHotel("suite", 2, 200.0);
        correoUsuario = "test@example.com";
    }

    /**
     * ID: RM-001
     * Propósito: Verificar que se puede agregar una reservación correctamente
     * Precondiciones: Manager inicializado
     * Entradas: Correo de usuario y reservación
     * Salida esperada: La reservación se agrega correctamente
     */
    @Test
    public void testAgregarReservacion() {
        manager.agregarReservacion(correoUsuario, hotel);
        List<Component> reservaciones = manager.obtenerReservaciones(correoUsuario);
        assertTrue(reservaciones.contains(hotel));
    }

    /**
     * ID: RM-002
     * Propósito: Verificar que falla al agregar reservación con correo null
     * Precondiciones: Manager inicializado
     * Entradas: Correo null y reservación válida
     * Salida esperada: NullPointerException
     */
    @Test(expected = NullPointerException.class)
    public void testAgregarReservacionCorreoNull() {
        manager.agregarReservacion(null, hotel);
    }

    /**
     * ID: RM-003
     * Propósito: Verificar que se obtiene lista vacía para usuario sin reservaciones
     * Precondiciones: Manager inicializado
     * Entradas: Correo de usuario sin reservaciones
     * Salida esperada: Lista vacía
     */
    @Test
    public void testObtenerReservacionesUsuarioInexistente() {
        List<Component> reservaciones = manager.obtenerReservaciones("noexiste@example.com");
        assertTrue(reservaciones.isEmpty());
    }
} 