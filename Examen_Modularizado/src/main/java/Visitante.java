public class Visitante {
    private String nombre;
    private int idVisitante;
    private int edad;

    public Visitante(String nombre, int idVisitante, int edad) {
        this.nombre = nombre;
        this.idVisitante = idVisitante;
        this.edad = edad;
    }

    public void comprarEntrada() {}
    public void usarAtraccion() {}

    @Override
    public String toString() {
        return nombre + " (ID: " + idVisitante + ", Edad: " + edad + ")";
    }
}