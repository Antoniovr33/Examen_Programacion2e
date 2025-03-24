public class Vendedor extends Empleado {
    private int ventasRealizadas;

    public Vendedor(String nombre, int idEmpleado, String puesto, int ventasRealizadas) {
        super(nombre, idEmpleado, puesto);
        this.ventasRealizadas = ventasRealizadas;
    }

    public void venderEntrada() {
        ventasRealizadas++;
    }

    public void reportarVentas() {
        System.out.println("Ventas realizadas: " + ventasRealizadas);
    }

    @Override
    public String toString() {
        return super.toString() + " (Ventas: " + ventasRealizadas + ")";
    }
}