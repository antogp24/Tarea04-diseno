package observer;

import model.Notification;

public class ObservadorWhatsapp implements Observer {
    private String numeroTelefono;

    public ObservadorWhatsapp(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    @Override
    public void actualizar(Notification notificacion) {
        System.out.println("Enviando WhatsApp a " + numeroTelefono + ": " + notificacion.getMensaje());
    }
} 