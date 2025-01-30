package observer;

public interface Subject {
    void agregarObservador(Observer observador);
    void eliminarObservador(Observer observador);
    void notificarObservadores(String mensaje);
} 