import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ComponentTest {
    private TestComponent component;

    // Implementación de prueba de Component
    private class TestComponent implements Component {
        private String estado = "disponible";
        private double precio = 100.0;

        @Override
        public void confirmar() {
            estado = "reservada";
        }

        @Override
        public void cancelar() {
            if (estado.equals("reservada")) {
                estado = "disponible";
            }
        }

        @Override
        public double getPrecio() {
            return precio;
        }

        public String getEstado() {
            return estado;
        }
    }

    @Before
    public void setUp() {
        component = new TestComponent();
    }

    /**
     * ID: COMP-001
     * Propósito: Verificar comportamiento básico de confirmar
     * Precondiciones: Componente en estado inicial
     * Entradas: Ninguna
     * Salida esperada: Estado cambia a "reservada"
     */
    @Test
    public void testConfirmar() {
        component.confirmar();
        assertEquals("reservada", component.getEstado());
    }

    /**
     * ID: COMP-002
     * Propósito: Verificar comportamiento básico de cancelar
     * Precondiciones: Componente confirmado
     * Entradas: Ninguna
     * Salida esperada: Estado cambia a "disponible"
     */
    @Test
    public void testCancelar() {
        component.confirmar();
        component.cancelar();
        assertEquals("disponible", component.getEstado());
    }

    /**
     * ID: COMP-003
     * Propósito: Verificar obtención de precio
     * Precondiciones: Componente inicializado
     * Entradas: Ninguna
     * Salida esperada: Precio correcto
     */
    @Test
    public void testGetPrecio() {
        assertEquals(100.0, component.getPrecio(), 0.01);
    }
} 