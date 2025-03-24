package biblioteca.examen_programacion2;

import java.util.ArrayList;
import java.util.Scanner;

class Empleado {
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

class Atraccion {
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

class Visitante {
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

class Mantenimiento extends Empleado {
    private String areaResponsable;

    public Mantenimiento(String nombre, int idEmpleado, String puesto, String areaResponsable) {
        super(nombre, idEmpleado, puesto);
        this.areaResponsable = areaResponsable;
    }

    public void realizarMantenimiento() {}
    public void reportarProblema() {}

    @Override
    public String toString() {
        return super.toString() + " (Area: " + areaResponsable + ")";
    }
}

class Vendedor extends Empleado {
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

class ParqueAtracciones {
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

public class Main {
    public static void main(String[] args) {
        ParqueAtracciones parque = new ParqueAtracciones();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menu:\n1. Agregar Empleado\n2. Agregar Atraccion\n3. Agregar Visitante\n4. Mostrar Informacion del Parque\n5. Salir");
            System.out.print("Elige una opcion: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Ingresa un numero valido.");
                scanner.next();
            }
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Nombre del empleado: ");
                    String nombreEmpleado = scanner.next();
                    System.out.print("ID del empleado: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Ingresa un numero valido.");
                        scanner.next();
                    }
                    int idEmpleado = scanner.nextInt();
                    System.out.print("Puesto del empleado (Mantenimiento, Vendedor, Seguridad): ");
                    String puesto = scanner.next();
                    if (puesto.equalsIgnoreCase("Mantenimiento")) {
                        System.out.print("Area responsable (Mecanica, Electrica, Limpieza): ");
                        String areaResponsable = scanner.next();
                        parque.agregarEmpleado(new Mantenimiento(nombreEmpleado, idEmpleado, puesto, areaResponsable));
                    } else if (puesto.equalsIgnoreCase("Vendedor")) {
                        System.out.print("Numero de ventas: ");
                        while (!scanner.hasNextInt()) {
                            System.out.println("Ingresa un numero valido.");
                            scanner.next();
                        }
                        int ventasRealizadas = scanner.nextInt();
                        parque.agregarEmpleado(new Vendedor(nombreEmpleado, idEmpleado, puesto, ventasRealizadas));
                    } else {
                        parque.agregarEmpleado(new Empleado(nombreEmpleado, idEmpleado, puesto));
                    }
                }
                case 2 -> {
                    System.out.print("Nombre de la atraccion: ");
                    String nombreAtraccion = scanner.next();
                    System.out.print("Capacidad de la atraccion: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Ingresa un numero valido.");
                        scanner.next();
                    }
                    int capacidad = scanner.nextInt();
                    System.out.print("Estado de la atraccion (Operativa, Mantenimiento, Sinservicio): ");
                    String estado = scanner.next();
                    if (estado.equalsIgnoreCase("Operativa") || estado.equalsIgnoreCase("Mantenimiento") || estado.equalsIgnoreCase("Sinservicio")) {
                        parque.agregarAtraccion(new Atraccion(nombreAtraccion, capacidad, estado));
                    } else {
                        System.out.println("Estado invalido. Intentalo de nuevo.");
                    }
                }
                case 3 -> {
                    System.out.print("Nombre del visitante: ");
                    String nombreVisitante = scanner.next();
                    System.out.print("ID del visitante: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Ingresa un numero valido.");
                        scanner.next();
                    }
                    int idVisitante = scanner.nextInt();
                    System.out.print("Edad del visitante: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Ingresa un numero valido.");
                        scanner.next();
                    }
                    int edad = scanner.nextInt();
                    parque.agregarVisitante(new Visitante(nombreVisitante, idVisitante, edad));
                }
                case 4 -> parque.mostrarInformacionParque();
                case 5 -> System.out.println("Saliendo...");
                default -> System.out.println("Opcion Invalida. Intentalo de nuevo.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}