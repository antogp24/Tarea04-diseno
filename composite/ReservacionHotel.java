package composite;

import observer.NotificadorManager;

public class ReservacionHotel implements Component {
    protected int cantidadDeCamas;
    protected String estado;  // disponible, reservada, ocupada, mantenimiento
    protected String correoUsuario;
    protected double precio;
    protected String tipoHabitacion;

    public ReservacionHotel(String tipo, int cantidadDeCamas, double precio) {
        this.tipoHabitacion = tipo;
        this.cantidadDeCamas = cantidadDeCamas;
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

    public double getPrecio() {
        return precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }
}
