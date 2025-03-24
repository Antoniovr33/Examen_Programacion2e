public class Empleado {
    private String nombre;
    private int idEmpleado;
    private String puesto;

    public Empleado(String nombre, int idEmpleado, String puesto) {
        this.nombre = nombre;
        this.idEmpleado = idEmpleado;
        this.puesto = puesto;
    }

    public void asignarTarea() {}
    public void realizarTarea() {}

    @Override
    public String toString() {
        return nombre + " (ID: " + idEmpleado + ", Puesto: " + puesto + ")";
    }
}
