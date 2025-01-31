import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AdicionalTest {
    private TestAdicional adicional;

    // Implementación de prueba de Adicional
    private class TestAdicional implements Adicional {
        private String estado = "pendiente";
        private double precio = 50.0;

        @Override
        public void confirmar() {
            estado = "confirmado";
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
        adicional = new TestAdicional();
    }

    /**
     * ID: AD-001
     * Propósito: Verificar confirmación de adicional
     * Precondiciones: Adicional en estado inicial
     * Entradas: Ninguna
     * Salida esperada: Estado cambia a "confirmado"
     */
    @Test
    public void testConfirmar() {
        adicional.confirmar();
        assertEquals("confirmado", adicional.getEstado());
    }

    /**
     * ID: AD-002
     * Propósito: Verificar obtención de precio
     * Precondiciones: Adicional inicializado
     * Entradas: Ninguna
     * Salida esperada: Precio correcto
     */
    @Test
    public void testGetPrecio() {
        assertEquals(50.0, adicional.getPrecio(), 0.01);
    }

    /**
     * ID: AD-003
     * Propósito: Verificar que el precio no es negativo
     * Precondiciones: Adicional inicializado
     * Entradas: Ninguna
     * Salida esperada: Precio mayor o igual a cero
     */
    @Test
    public void testPrecioNoNegativo() {
        assertTrue(adicional.getPrecio() >= 0);
    }
} 