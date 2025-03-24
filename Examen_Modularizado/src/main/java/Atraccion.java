public class Atraccion {
    private String nombre;
    private int capacidad;
    private String estado;

    public Atraccion(String nombre, int capacidad, String estado) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.estado = estado;
    }

    public void iniciarAtraccion() {}
    public void detenerAtraccion() {}
    public void cambiarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
    }

    @Override
    public String toString() {
        return nombre + " (Capacidad: " + capacidad + ", Estado: " + estado + ")";
    }
}
