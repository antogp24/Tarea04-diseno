import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class IncidenteManagerTest {
    private IncidenteManager manager;
    private Incidente incidente;

    @Before
    public void setUp() {
        manager = IncidenteManager.getInstance();
        incidente = new Incidente("hotel", "Problema con la habitación", "test@example.com");
    }

    /**
     * ID: IM-001
     * Propósito: Verificar que se puede reportar un incidente correctamente
     * Precondiciones: Manager inicializado
     * Entradas: Incidente válido
     * Salida esperada: Incidente procesado sin errores
     */
    @Test
    public void testReportarIncidente() {
        manager.reportarIncidente(incidente);
        // Verificar que no se lanzan excepciones
    }

    /**
     * ID: IM-002
     * Propósito: Verificar que falla al reportar un incidente null
     * Precondiciones: Manager inicializado
     * Entradas: Incidente null
     * Salida esperada: NullPointerException
     */
    @Test(expected = NullPointerException.class)
    public void testReportarIncidenteNull() {
        manager.reportarIncidente(null);
    }

    /**
     * ID: IM-003
     * Propósito: Verificar que falla al reportar un incidente con tipo inválido
     * Precondiciones: Manager inicializado
     * Entradas: Incidente con tipo inválido
     * Salida esperada: IllegalArgumentException
     */
    @Test(expected = IllegalArgumentException.class)
    public void testReportarIncidenteTipoInvalido() {
        Incidente incidenteInvalido = new Incidente("tipo_invalido", "descripcion", "test@example.com");
        manager.reportarIncidente(incidenteInvalido);
    }
} 