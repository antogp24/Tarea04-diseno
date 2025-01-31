import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ReservacionHotelTest {
    private ReservacionHotel reservacion;

    @Before
    public void setUp() {
        reservacion = new ReservacionHotel("suite", 2, 200.0);
    }

    /**
     * ID: RH-001
     * Propósito: Verificar que la confirmación cambia el estado correctamente
     * Precondiciones: Reservación inicializada
     * Entradas: Ninguna
     * Salida esperada: Estado cambia a "reservada"
     */
    @Test
    public void testConfirmarReservacion() {
        reservacion.confirmar();
        assertEquals("reservada", reservacion.getEstado());
    }

    /**
     * ID: RH-002
     * Propósito: Verificar que no se puede confirmar una reservación ya confirmada
     * Precondiciones: Reservación ya confirmada
     * Entradas: Ninguna
     * Salida esperada: El estado no cambia
     */
    @Test
    public void testConfirmarReservacionYaConfirmada() {
        reservacion.confirmar();
        reservacion.confirmar();
        assertEquals("reservada", reservacion.getEstado());
    }

    /**
     * ID: RH-003
     * Propósito: Verificar que se puede cancelar una reservación confirmada
     * Precondiciones: Reservación confirmada
     * Entradas: Ninguna
     * Salida esperada: Estado cambia a "disponible"
     */
    @Test
    public void testCancelarReservacion() {
        reservacion.confirmar();
        reservacion.cancelar();
        assertEquals("disponible", reservacion.getEstado());
    }
} 