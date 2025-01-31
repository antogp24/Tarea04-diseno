import singleton.*;
import composite.*;
import java.util.Scanner;
import java.util.List;

public class Reservaciones {
    private static ReservacionManager reservacionManager = ReservacionManager.getInstance();

    public static ReservacionHotel reservarHotel(Scanner scanner) {
        mostrarTiposHabitacion();
        
        int opcion = Util.nextNumber(scanner, "Seleccione tipo de habitación: ", 1, 3);
        
        System.out.print("Ingrese su correo electrónico: ");
        String correo = scanner.nextLine();
        
        ReservacionHotel reservacion = crearReservacionHotel(opcion, correo);
        
        if (reservacion != null) {
            reservacion.confirmar();
            Inventario.getInstance().disminuirDisponible(reservacion.getTipoHabitacion(), "hotel");
            reservacionManager.agregarReservacion(correo, reservacion);
            System.out.println("Reservación confirmada exitosamente");
        } else {
            System.out.println("No hay disponibilidad para este tipo de habitación");
        }
        
        return reservacion;
    }

    private static void mostrarTiposHabitacion() {
        System.out.println("\nTipos de habitación disponibles:");
        System.out.println("1. Estándar ($100)");
        System.out.println("2. Suite ($200)");
        System.out.println("3. Familiar ($150)");
    }

    private static ReservacionHotel crearReservacionHotel(int opcion, String correo) {
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
            ReservacionHotel reservacion = new ReservacionHotel(tipo, 2, precio);
            reservacion.setCorreoUsuario(correo);
            return reservacion;
        } else {
            return null;
        }
    }

    public static ReservacionPaseo reservarPaseo(Scanner scanner) {
        System.out.println("\nTipos de paseo disponibles:");
        System.out.println("1. Cultural ($80)");
        System.out.println("2. Aventura ($120)");
        System.out.println("3. Familiar ($100)");
        
        int opcion = Util.nextNumber(scanner, "Seleccione tipo de paseo: ", 1, 3);
        
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

    public static void imprimirTabla(Scanner scanner) {
        System.out.print("Ingrese su correo electrónico: ");
        String correo = scanner.nextLine();
        
        List<Component> reservaciones = reservacionManager.obtenerReservaciones(correo);
        
        if (reservaciones.isEmpty()) {
            System.out.println("\nNo tiene reservaciones registradas.");
            return;
        }

        System.out.println("\nSus reservaciones:");
        System.out.println("------------------");
        
        for (Component reservacion : reservaciones) {
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
}
