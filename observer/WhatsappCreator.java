package observer;

import model.*;

public abstract class WhatsappCreator {
    private String receptor;
    private String mensaje;

    public abstract Notification crearNotificacion(String receptor, String mensaje);
}
