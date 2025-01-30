package singleton;

public class Servicio {
    private String tipoServicio;
    private String particularidad;
    private int precio;

    public Servicio(String tipoServicio, String particularidad, int precio) {
        this.tipoServicio = tipoServicio;
        this.particularidad = particularidad;
        this.precio = precio;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public String getParticularidad() {
        return particularidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public void setParticularidad(String particularidad) {
        this.particularidad = particularidad;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
