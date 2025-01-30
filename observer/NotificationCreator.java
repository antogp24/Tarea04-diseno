package observer;

import model.*;

public abstract class NotificationCreator {
    private String receptor;
    private String mensaje;

    public abstract Notification crearNotificacion(String receptor, String mensaje);
}
