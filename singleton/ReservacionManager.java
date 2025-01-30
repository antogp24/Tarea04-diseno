package singleton;

import composite.Component;
import java.util.*;

public class ReservacionManager {
    private static ReservacionManager instance = new ReservacionManager();
    private Map<String, List<Component>> reservacionesPorUsuario;

    private ReservacionManager() {
        reservacionesPorUsuario = new HashMap<>();
    }

    static public ReservacionManager getInstance() {
        return instance;
    }

    static public boolean revisarDisponible(Component reservacion) {
        return true;
    }

    public void agregarReservacion(String correoUsuario, Component reservacion) {
        reservacionesPorUsuario
            .computeIfAbsent(correoUsuario, k -> new ArrayList<>())
            .add(reservacion);
    }

    public List<Component> obtenerReservaciones(String correoUsuario) {
        return reservacionesPorUsuario.getOrDefault(correoUsuario, new ArrayList<>());
    }
}
