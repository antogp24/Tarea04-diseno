import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ReservacionPaseoTest {
    private ReservacionPaseo reservacion;

    @Before
    public void setUp() {
        reservacion = new ReservacionPaseo("cultural", 80.0);
    }

    /**
     * ID: RP-001
     * Propósito: Verificar confirmación de paseo
     * Precondiciones: Reservación inicializada
     * Entradas: Ninguna
     * Salida esperada: Estado cambia a "reservada"
     */
    @Test
    public void testConfirmarPaseo() {
        reservacion.confirmar();
        assertEquals("reservada", reservacion.getEstado());
    }

    /**
     * ID: RP-002
     * Propósito: Verificar cancelación de paseo
     * Precondiciones: Reservación confirmada
     * Entradas: Ninguna
     * Salida esperada: Estado cambia a "disponible"
     */
    @Test
    public void testCancelarPaseo() {
        reservacion.confirmar();
        reservacion.cancelar();
        assertEquals("disponible", reservacion.getEstado());
    }

    /**
     * ID: RP-003
     * Propósito: Verificar que no se puede cancelar un paseo no confirmado
     * Precondiciones: Reservación en estado inicial
     * Entradas: Ninguna
     * Salida esperada: Estado no cambia
     */
    @Test
    public void testCancelarPaseoNoConfirmado() {
        reservacion.cancelar();
        assertEquals("disponible", reservacion.getEstado());
    }
} 