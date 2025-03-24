import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ParqueAtracciones parque = new ParqueAtracciones();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú:\n1. Agregar Empleado\n2. Agregar Atracción\n3. Agregar Visitante\n4. Mostrar Información del Parque\n5. Salir");
            System.out.print("Elige una opción: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Ingresa un número válido.");
                scanner.next();
            }
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Nombre del empleado: ");
                    String nombreEmpleado = scanner.next();
                    System.out.print("ID del empleado: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Ingresa un número válido.");
                        scanner.next();
                    }
                    int idEmpleado = scanner.nextInt();
                    System.out.print("Puesto del empleado (Mantenimiento, Vendedor, Seguridad): ");
                    String puesto = scanner.next();
                    if (puesto.equalsIgnoreCase("Mantenimiento")) {
                        System.out.print("Área responsable (Mecánica, Eléctrica, Limpieza): ");
                        String areaResponsable = scanner.next();
                        parque.agregarEmpleado(new Mantenimiento(nombreEmpleado, idEmpleado, puesto, areaResponsable));
                    } else if (puesto.equalsIgnoreCase("Vendedor")) {
                        System.out.print("Número de ventas: ");
                        while (!scanner.hasNextInt()) {
                            System.out.println("Ingresa un número válido.");
                            scanner.next();
                        }
                        int ventasRealizadas = scanner.nextInt();
                        parque.agregarEmpleado(new Vendedor(nombreEmpleado, idEmpleado, puesto, ventasRealizadas));
                    } else {
                        parque.agregarEmpleado(new Empleado(nombreEmpleado, idEmpleado, puesto));
                    }
                }
                case 2 -> {
                    System.out.print("Nombre de la atracción: ");
                    String nombreAtraccion = scanner.next();
                    System.out.print("Capacidad de la atracción: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Ingresa un número válido.");
                        scanner.next();
                    }
                    int capacidad = scanner.nextInt();
                    System.out.print("Estado de la atracción (Operativa, Mantenimiento, SinServicio): ");
                    String estado = scanner.next();
                    parque.agregarAtraccion(new Atraccion(nombreAtraccion, capacidad, estado));
                }
                case 3 -> {
                    System.out.print("Nombre del visitante: ");
                    String nombreVisitante = scanner.next();
                    System.out.print("ID del visitante: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Ingresa un número válido.");
                        scanner.next();
                    }
                    int idVisitante = scanner.nextInt();
                    System.out.print("Edad del visitante: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Ingresa un número válido.");
                        scanner.next();
                    }
                    int edad = scanner.nextInt();
                    parque.agregarVisitante(new Visitante(nombreVisitante, idVisitante, edad));
                }
                case 4 -> parque.mostrarInformacionParque();
                case 5 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida. Inténtalo de nuevo.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}