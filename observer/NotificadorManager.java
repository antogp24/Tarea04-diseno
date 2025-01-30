package observer;

import model.Notification;
import composite.Reservacion;
import java.util.ArrayList;
import java.util.List;

public class NotificadorManager implements Subject {
    private static NotificadorManager instance = new NotificadorManager();
    private List<Observer> observadores;

    private NotificadorManager() {
        observadores = new ArrayList<>();
        inicializarObservadores();
    }

    private void inicializarObservadores() {
        // Por defecto agregamos observadores para email y WhatsApp
        agregarObservador(new ObservadorEmail("usuario@email.com"));
        agregarObservador(new ObservadorWhatsapp("+1234567890"));
    }

    public static NotificadorManager getInstance() {
        return instance;
    }

    @Override
    public void agregarObservador(Observer observador) {
        observadores.add(observador);
    }

    @Override
    public void eliminarObservador(Observer observador) {
        observadores.remove(observador);
    }

    @Override
    public void notificarObservadores(String mensaje) {
        Notification notificacion = new Notification(mensaje, "INFO", "usuario");
        for (Observer observador : observadores) {
            observador.actualizar(notificacion);
        }
    }

    public void enviarNotificacion(Reservacion reservacion) {
        String mensaje = "Su reservación ha sido confirmada";
        notificarObservadores(mensaje);
    }
}
