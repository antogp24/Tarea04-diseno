package observer;

import model.Notification;

public class ObservadorEmail implements Observer {
    private String email;

    public ObservadorEmail(String email) {
        this.email = email;
    }

    @Override
    public void actualizar(Notification notificacion) {
        System.out.println("Enviando Email a " + email + ": " + notificacion.getMensaje());
    }
} 