package singleton;

import composite.Reservacion;
import java.util.*;

public class ReservacionManager {
    private static ReservacionManager instance = new ReservacionManager();
    private Map<String, List<Reservacion>> reservacionesPorUsuario;

    private ReservacionManager() {
        reservacionesPorUsuario = new HashMap<>();
    }

    static public ReservacionManager getInstance() {
        return instance;
    }

    static public boolean revisarDisponible(Reservacion reservacion) {
        return true;
    }

    public void agregarReservacion(String correoUsuario, Reservacion reservacion) {
        reservacionesPorUsuario
            .computeIfAbsent(correoUsuario, k -> new ArrayList<>())
            .add(reservacion);
    }

    public List<Reservacion> obtenerReservaciones(String correoUsuario) {
        return reservacionesPorUsuario.getOrDefault(correoUsuario, new ArrayList<>());
    }
}
