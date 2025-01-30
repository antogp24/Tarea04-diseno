package model;

public class Incidente {
    private String tipo;
    private String descripcion;
    private String correoUsuario;

    public Incidente(String tipo, String descripcion, String correoUsuario) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.correoUsuario = correoUsuario;
    }

    public String getTipo() { return tipo; }
    public String getDescripcion() { return descripcion; }
    public String getCorreoUsuario() { return correoUsuario; }
}
