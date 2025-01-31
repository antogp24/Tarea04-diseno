import singleton.*;
import composite.*;
import builder.*;
import model.Incidente;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static PaqueteBuilder paqueteBuilder = new PaqueteTuristicoBuilder();
    private static PaqueteDirector paqueteDirector = new PaqueteDirector(paqueteBuilder);

    public static void main(String[] args) {
        System.out.println("Bienvenido a TravelStay");
        System.out.println("------------------------");
        
        boolean running = true;
        while (running) {
            mostrarMenu();
            int opcion = Util.nextNumber(scanner, "Seleccione una opción: ", 1, 6);
            
            switch (opcion) {
                case 1: Reservaciones.reservarHotel(scanner); break;
                case 2: Reservaciones.reservarPaseo(scanner); break;
                case 3: crearPaquete(); break;
                case 4: Reservaciones.imprimirTabla(scanner); break;
                case 5: reportarIncidente(); break;
                case 6: running = false; break;
                default: System.out.println("Opción inválida");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("\nMenú Principal:");
        System.out.println("1. Reservar Hotel");
        System.out.println("2. Reservar Paseo");
        System.out.println("3. Crear Paquete Turístico");
        System.out.println("4. Ver Reservaciones");
        System.out.println("5. Reportar Incidente");
        System.out.println("6. Salir");
    }

    private static void crearPaquete() {
        System.out.println("\nTipos de paquetes:");
        System.out.println("1. Básico (10% descuento)");
        System.out.println("2. Premium (20% descuento + servicios adicionales)");
        
        int opcion = Util.nextNumber(scanner, "Seleccione tipo de paquete: ", 1, 2);
        
        System.out.println("\nPrimero, seleccione su hotel:");
        ReservacionHotel hotel = (ReservacionHotel) Reservaciones.reservarHotel(scanner);
        
        System.out.println("\nAhora, seleccione su paseo:");
        ReservacionPaseo paseo = (ReservacionPaseo) Reservaciones.reservarPaseo(scanner);
        
        if (hotel != null && paseo != null) {
            if (opcion == 1) {
                paqueteDirector.construirPaqueteBasico(hotel, paseo);
            } else {
                paqueteDirector.construirPaquetePremium(hotel, paseo);
            }
            
            PaqueteTuristico paquete = paqueteBuilder.build();
            paquete.confirmar();
            System.out.println("Paquete turístico creado exitosamente");
        } else {
            System.out.println("No se pudo crear el paquete");
        }
    }

    private static void reportarIncidente() {
        System.out.println("\nTipo de incidente:");
        System.out.println("1. Problema con hotel");
        System.out.println("2. Problema con paseo");
        System.out.println("3. Problema con paquete");
        
        int opcion = Util.nextNumber(scanner, "Seleccione tipo de incidente: ", 1, 3);
        
        System.out.print("Describa el problema: ");
        String descripcion = scanner.nextLine();
        
        System.out.print("Ingrese su correo electrónico: ");
        String correo = scanner.nextLine();
        
        String tipo = opcion == 1 ? "hotel" : opcion == 2 ? "paseo" : "paquete";
        Incidente incidente = new Incidente(tipo, descripcion, correo);
        IncidenteManager.getInstance().reportarIncidente(incidente);
        
        System.out.println("Incidente reportado exitosamente");
    }

}
