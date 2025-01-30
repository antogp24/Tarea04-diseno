package observer;

import model.*;

public abstract class CorreoCreator {
    private String receptor;
    private String mensaje;

    public abstract Notification crearNotificacion(String receptor, String mensaje);
}
