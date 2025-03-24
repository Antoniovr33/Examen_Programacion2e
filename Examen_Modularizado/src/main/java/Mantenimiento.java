public class Mantenimiento extends Empleado {
    private String areaResponsable;

    public Mantenimiento(String nombre, int idEmpleado, String puesto, String areaResponsable) {
        super(nombre, idEmpleado, puesto);
        this.areaResponsable = areaResponsable;
    }

    public void realizarMantenimiento() {}
    public void reportarProblema() {}

    @Override
    public String toString() {
        return super.toString() + " (Área: " + areaResponsable + ")";
    }
}
