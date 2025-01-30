package model;

import composite.Component;
import observer.NotificadorManager;

public class ReservacionPaseo implements Component {
    protected String tipo;
    protected String estado;
    protected String correoUsuario;
    protected double precio;

    public ReservacionPaseo(String tipo, double precio) {
        this.tipo = tipo;
        this.precio = precio;
        this.estado = "disponible";
    }

    @Override
    public void confirmar() {
        if (estado.equals("disponible")) {
            estado = "reservada";
            NotificadorManager.getInstance().enviarNotificacion(this);
        }
    }

    @Override
    public void cancelar() {
        if (estado.equals("reservada")) {
            estado = "disponible";
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