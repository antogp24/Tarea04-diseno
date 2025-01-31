import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AgregadorServicioManagerTest {
    private AgregadorServicioManager manager;
    private Servicio servicio;

    @Before
    public void setUp() {
        manager = AgregadorServicioManager.getInstance();
        servicio = new Servicio("Traslado", "Premium", 50.0);
    }

    /**
     * ID: ASM-001
     * Propósito: Verificar que se puede agregar un nuevo servicio
     * Precondiciones: Manager inicializado
     * Entradas: Servicio válido
     * Salida esperada: Servicio agregado correctamente
     */
    @Test
    public void testAgregarNuevoServicio() {
        manager.agregarNuevoServicio(servicio);
        assertTrue(manager.getServiciosDisponibles().contains(servicio));
    }

    /**
     * ID: ASM-002
     * Propósito: Verificar que falla al agregar servicio null
     * Precondiciones: Manager inicializado
     * Entradas: Servicio null
     * Salida esperada: NullPointerException
     */
    @Test(expected = NullPointerException.class)
    public void testAgregarServicioNull() {
        manager.agregarNuevoServicio(null);
    }

    /**
     * ID: ASM-003
     * Propósito: Verificar que se puede quitar un servicio existente
     * Precondiciones: Servicio agregado al manager
     * Entradas: Servicio a quitar
     * Salida esperada: Servicio eliminado correctamente
     */
    @Test
    public void testQuitarServicio() {
        manager.agregarNuevoServicio(servicio);
        manager.quitarServicio(servicio);
        assertFalse(manager.getServiciosDisponibles().contains(servicio));
    }
} 