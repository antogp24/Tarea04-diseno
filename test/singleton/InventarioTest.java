import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class InventarioTest {
    private Inventario inventario;

    @Before
    public void setUp() {
        inventario = Inventario.getInstance();
    }

    /**
     * ID: INV-001
     * Propósito: Verificar disponibilidad de habitación existente
     * Precondiciones: Inventario inicializado
     * Entradas: Tipo "suite", categoría "hotel"
     * Salida esperada: true
     */
    @Test
    public void testVerificarDisponibilidadHabitacionExistente() {
        assertTrue(inventario.verificarDisponibilidad("suite", "hotel"));
    }

    /**
     * ID: INV-002
     * Propósito: Verificar que disminuye correctamente el inventario
     * Precondiciones: Inventario con disponibilidad
     * Entradas: Tipo "suite", categoría "hotel"
     * Salida esperada: Disponibilidad disminuye en 1
     */
    @Test
    public void testDisminuirDisponible() {
        boolean disponibilidadAntes = inventario.verificarDisponibilidad("suite", "hotel");
        inventario.disminuirDisponible("suite", "hotel");
        assertTrue(disponibilidadAntes);
    }

    /**
     * ID: INV-003
     * Propósito: Verificar que falla al consultar tipo inexistente
     * Precondiciones: Inventario inicializado
     * Entradas: Tipo inválido
     * Salida esperada: false
     */
    @Test
    public void testVerificarDisponibilidadTipoInexistente() {
        assertFalse(inventario.verificarDisponibilidad("tipo_invalido", "hotel"));
    }
} 