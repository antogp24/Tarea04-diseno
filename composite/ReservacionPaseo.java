package composite;

import observer.NotificadorManager;

public class ReservacionPaseo implements Reservacion {
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

    @Override
    public double getPrecio() {
        return precio;
    }

    public String getEstado() {
        return estado;
    }

    public String getTipo() {
        return tipo;
    }
}
