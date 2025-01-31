package model;

import composite.Component;
import observer.NotificadorManager;

public class ReservacionPaseo implements Component {
    protected Estado estado;
    protected String correoUsuario;
    protected double precio;

    public static enum Estado {
        DISPONIBLE, RESERVADA
    }

    public ReservacionPaseo(String tipo, double precio) {
        this.precio = precio;
        this.estado = Estado.DISPONIBLE;
    }

    @Override
    public void confirmar() {
        if (estado == Estado.DISPONIBLE) {
            estado = Estado.RESERVADA;
            NotificadorManager.getInstance().enviarNotificacion(this);
        }
    }

    @Override
    public void cancelar() {
        if (estado == Estado.RESERVADA) {
            estado = Estado.DISPONIBLE;
            NotificadorManager.getInstance().enviarNotificacion(this);
        }
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public double getPrecio() {
        return precio;
    }
} 