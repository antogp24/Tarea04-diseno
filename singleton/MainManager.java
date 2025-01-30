package singleton;

import com.sun.tools.javac.Main;

import observer.*;

import java.sql.SQLOutput;


public class MainManager {
    private static MainManager instance = new MainManager();
    private static ReservacionManager reservacionManager = ReservacionManager.getInstance();
    private static IncidenteManager incidenteManager = IncidenteManager.getInstance();
    private static NotificadorManager notificadorManager = NotificadorManager.getInstance();
    private static AgregadorServicioManager agregador = AgregadorServicioManager.getInstance();

    private MainManager(){}

    public static MainManager getInstance(){
        return instance;
    }

    public static ReservacionManager getReservacionManager() {
        return reservacionManager;
    }

    public static IncidenteManager getIncidenteManager() {
        return incidenteManager;
    }

    public static NotificadorManager getNotificadorManager() {
        return notificadorManager;
    }

    public void execute() {
        System.out.println("Sistema operando");
        System.out.println("Inicie sesion");
        System.out.println("Esperando las reservaciones de usuario");
    }
}
