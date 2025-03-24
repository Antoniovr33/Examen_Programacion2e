import java.util.ArrayList;

public class ParqueAtracciones {
    private ArrayList<Empleado> listaEmpleados = new ArrayList<>();
    private ArrayList<Atraccion> listaAtracciones = new ArrayList<>();
    private ArrayList<Visitante> listaVisitantes = new ArrayList<>();

    public void agregarEmpleado(Empleado empleado) {
        listaEmpleados.add(empleado);
    }

    public void agregarAtraccion(Atraccion atraccion) {
        listaAtracciones.add(atraccion);
    }

    public void agregarVisitante(Visitante visitante) {
        listaVisitantes.add(visitante);
    }

    public void mostrarInformacionParque() {
        System.out.println("Empleados:");
        listaEmpleados.forEach(System.out::println);
        System.out.println("Atracciones:");
        listaAtracciones.forEach(System.out::println);
        System.out.println("Visitantes:");
        listaVisitantes.forEach(System.out::println);
    }
}