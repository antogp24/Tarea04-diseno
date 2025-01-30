package model;

import composite.Component;

public class PaseoAventura implements Component {
    private String tipo = "aventura";
    private double precio = 120.0;

    @Override
    public void cancelar() {
        // Implementación
    }

    @Override
    public void confirmar() {
        // Implementación
    }

    public double getPrecio() {
        return precio;
    }
}
