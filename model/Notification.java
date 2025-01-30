package model;

public class Notification {
    private String mensaje;
    private String tipo;
    private String destinatario;

    public Notification(String mensaje, String tipo, String destinatario) {
        this.mensaje = mensaje;
        this.tipo = tipo;
        this.destinatario = destinatario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDestinatario() {
        return destinatario;
    }
}
