import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import model.Notification;

public class NotificadorManagerTest {
    private NotificadorManager notificador;
    private TestObserver testObserver;

    private class TestObserver implements Observer {
        private boolean notificado = false;
        
        @Override
        public void actualizar(Notification notificacion) {
            notificado = true;
        }
        
        public boolean fueNotificado() {
            return notificado;
        }
    }

    @Before
    public void setUp() {
        notificador = NotificadorManager.getInstance();
        testObserver = new TestObserver();
    }

    /**
     * ID: NM-001
     * Propósito: Verificar que se puede agregar un observador
     * Precondiciones: NotificadorManager inicializado
     * Entradas: Nuevo observador
     * Salida esperada: Observador agregado correctamente
     */
    @Test
    public void testAgregarObservador() {
        notificador.agregarObservador(testObserver);
        notificador.notificarObservadores("test");
        assertTrue(testObserver.fueNotificado());
    }

    /**
     * ID: NM-002
     * Propósito: Verificar que se puede eliminar un observador
     * Precondiciones: Observador agregado al notificador
     * Entradas: Observador a eliminar
     * Salida esperada: Observador no recibe notificaciones
     */
    @Test
    public void testEliminarObservador() {
        notificador.agregarObservador(testObserver);
        notificador.eliminarObservador(testObserver);
        notificador.notificarObservadores("test");
        assertFalse(testObserver.fueNotificado());
    }

    /**
     * ID: NM-003
     * Propósito: Verificar que falla al eliminar observador no registrado
     * Precondiciones: NotificadorManager inicializado
     * Entradas: Observador no registrado
     * Salida esperada: IllegalStateException
     */
    @Test(expected = IllegalStateException.class)
    public void testEliminarObservadorNoRegistrado() {
        notificador.eliminarObservador(new TestObserver());
    }
} 