import singleton.*;
import factory.*;
import composite.*;
import builder.*;
import model.Incidente;
import java.util.Scanner;
import java.util.List;
import composite.ReservacionPaseo;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static ReservacionManager reservacionManager = ReservacionManager.getInstance();
    private static PaqueteBuilder paqueteBuilder = new PaqueteTuristicoBuilder();
    private static PaqueteDirector paqueteDirector = new PaqueteDirector(paqueteBuilder);

    public static void main(String[] args) {
        System.out.println("Bienvenido a TravelStay");
        System.out.println("------------------------");
        
        boolean running = true;
        while (running) {
            mostrarMenu();
            int opcion = nextNumber(scanner, "Seleccione una opción: ", 1, 6);
            
            switch (opcion) {
                case 1: reservarHotel(); break;
                case 2: reservarPaseo(); break;
                case 3: crearPaquete(); break;
                case 4: verReservaciones(); break;
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

    private static ReservacionHotel reservarHotel() {
        System.out.println("\nTipos de habitación disponibles:");
        System.out.println("1. Estándar ($100)");
        System.out.println("2. Suite ($200)");
        System.out.println("3. Familiar ($150)");
        
        int opcion = nextNumber(scanner, "Seleccione tipo de habitación: ", 1, 3);
        
        System.out.print("Ingrese su correo electrónico: ");
        String correo = scanner.nextLine();
        
        ReservacionHotel reservacion = null;
        String tipo = "";
        double precio = 0;
        
        switch (opcion) {
            case 1:
                tipo = "estandar";
                precio = 100;
                break;
            case 2:
                tipo = "suite";
                precio = 200;
                break;
            case 3:
                tipo = "familiar";
                precio = 150;
                break;
            default:
                System.out.println("Opción inválida");
                return null;
        }
        
        if (Inventario.getInstance().verificarDisponibilidad(tipo, "hotel")) {
            reservacion = new ReservacionHotel(tipo, 2, precio);
            reservacion.setCorreoUsuario(correo);
            reservacion.confirmar();
            Inventario.getInstance().disminuirDisponible(tipo, "hotel");
            reservacionManager.agregarReservacion(correo, reservacion);
            System.out.println("Reservación confirmada exitosamente");
            return reservacion;
        } else {
            System.out.println("No hay disponibilidad para este tipo de habitación");
            return null;
        }
    }

    private static ReservacionPaseo reservarPaseo() {
        System.out.println("\nTipos de paseo disponibles:");
        System.out.println("1. Cultural ($80)");
        System.out.println("2. Aventura ($120)");
        System.out.println("3. Familiar ($100)");
        
        int opcion = nextNumber(scanner, "Seleccione tipo de paseo: ", 1, 3);
        
        System.out.print("Ingrese su correo electrónico: ");
        String correo = scanner.nextLine();
        
        ReservacionPaseo reservacion = null;
        String tipo = "";
        double precio = 0;
        
        switch (opcion) {
            case 1:
                tipo = "cultural";
                precio = 80;
                break;
            case 2:
                tipo = "aventura";
                precio = 120;
                break;
            case 3:
                tipo = "familiar";
                precio = 100;
                break;
            default:
                System.out.println("Opción inválida");
                return null;
        }
        
        if (Inventario.getInstance().verificarDisponibilidad(tipo, "paseo")) {
            reservacion = new ReservacionPaseo(tipo, precio);
            reservacion.setCorreoUsuario(correo);
            reservacion.confirmar();
            Inventario.getInstance().disminuirDisponible(tipo, "paseo");
            reservacionManager.agregarReservacion(correo, reservacion);
            System.out.println("Reservación confirmada exitosamente");
            return reservacion;
        } else {
            System.out.println("No hay disponibilidad para este tipo de paseo");
            return null;
        }
    }

    private static void crearPaquete() {
        System.out.println("\nTipos de paquetes:");
        System.out.println("1. Básico (10% descuento)");
        System.out.println("2. Premium (20% descuento + servicios adicionales)");
        
        int opcion = nextNumber(scanner, "Seleccione tipo de paquete: ", 1, 2);
        
        System.out.println("\nPrimero, seleccione su hotel:");
        ReservacionHotel hotel = (ReservacionHotel) reservarHotel();
        
        System.out.println("\nAhora, seleccione su paseo:");
        ReservacionPaseo paseo = (ReservacionPaseo) reservarPaseo();
        
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
        
        int opcion = nextNumber(scanner, "Seleccione tipo de incidente: ", 1, 3);
        
        System.out.print("Describa el problema: ");
        String descripcion = scanner.nextLine();
        
        System.out.print("Ingrese su correo electrónico: ");
        String correo = scanner.nextLine();
        
        String tipo = opcion == 1 ? "hotel" : opcion == 2 ? "paseo" : "paquete";
        Incidente incidente = new Incidente(tipo, descripcion, correo);
        IncidenteManager.getInstance().reportarIncidente(incidente);
        
        System.out.println("Incidente reportado exitosamente");
    }

    private static void verReservaciones() {
        System.out.print("Ingrese su correo electrónico: ");
        String correo = scanner.nextLine();
        
        List<Reservacion> reservaciones = reservacionManager.obtenerReservaciones(correo);
        
        if (reservaciones.isEmpty()) {
            System.out.println("\nNo tiene reservaciones registradas.");
            return;
        }

        System.out.println("\nSus reservaciones:");
        System.out.println("------------------");
        
        for (Reservacion reservacion : reservaciones) {
            if (reservacion instanceof ReservacionHotel hotel) {
                System.out.printf("Hotel - Tipo: %s, Estado: %s, Precio: $%.2f%n", 
                    hotel.getTipoHabitacion(), hotel.getEstado(), hotel.getPrecio());
            } else if (reservacion instanceof ReservacionPaseo paseo) {
                System.out.printf("Paseo - Tipo: %s, Estado: %s, Precio: $%.2f%n",
                    paseo.getTipo(), paseo.getEstado(), paseo.getPrecio());
            } else {
                System.out.printf("Reservación - Precio: $%.2f%n", 
                    reservacion.getPrecio());
            }
        }
    }

    private static int nextNumber(Scanner scanner, String prompt, int min, int max) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine();
                int number = Integer.parseInt(input);
                
                if (number >= min && number <= max) {
                    return number;
                } else {
                    System.out.printf("Por favor ingrese un número entre %d y %d%n", min, max);
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor ingrese un número válido");
            }
        }
    }
}
