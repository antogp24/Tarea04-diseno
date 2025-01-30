package singleton;

import java.util.HashMap;

public class Inventario {
    private static Inventario instance = new Inventario();
    private HashMap<String, Integer> disponibilidadHoteles;
    private HashMap<String, Integer> disponibilidadPaseos;

    private Inventario() {
        disponibilidadHoteles = new HashMap<>();
        disponibilidadPaseos = new HashMap<>();

        disponibilidadHoteles.put("estandar", 120);
        disponibilidadHoteles.put("suite", 120);
        disponibilidadHoteles.put("familiar", 120);

        disponibilidadPaseos.put("cultural", 85);
        disponibilidadPaseos.put("aventura", 85);
        disponibilidadPaseos.put("familiar", 85);
    }

    public static Inventario getInstance() {
        return instance;
    }

    public boolean verificarDisponibilidad(String tipo, String categoria) {
        if (categoria.equals("hotel")) {
            return disponibilidadHoteles.getOrDefault(tipo, 0) > 0;
        } else {
            return disponibilidadPaseos.getOrDefault(tipo, 0) > 0;
        }
    }

    public void disminuirDisponible(String tipo, String categoria) {
        HashMap<String, Integer> inventario = 
            categoria.equals("hotel") ? disponibilidadHoteles : disponibilidadPaseos;
        if (inventario.containsKey(tipo)) {
            inventario.put(tipo, inventario.get(tipo) - 1);
        }
    }

    public void aumentarDisponible(String tipo, String categoria) {
        HashMap<String, Integer> inventario = 
            categoria.equals("hotel") ? disponibilidadHoteles : disponibilidadPaseos;
        if (inventario.containsKey(tipo)) {
            inventario.put(tipo, inventario.get(tipo) + 1);
        }
    }
}
