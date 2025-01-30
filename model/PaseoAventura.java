package model;

import composite.Reservacion;

public class PaseoAventura implements Reservacion {
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

    @Override
    public double getPrecio() {
        return precio;
    }
}
