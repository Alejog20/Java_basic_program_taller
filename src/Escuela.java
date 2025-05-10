import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Clase Escuela que representa una lista de estudiantes y las operaciones asociadas.
 */
public class Escuela {
    // Atributo para almacenar los estudiantes
    private Set<Estudiante> estudiantes;

    /**
     * Constructor que inicializa la colección de estudiantes.
     */
    public Escuela() {
        this.estudiantes = new HashSet<>();
    }

    /**
     * Agrega un estudiante a la lista.
     *
     * @param estudiante Estudiante a agregar
     * @return true si se agregó correctamente, false si ya existía un estudiante con ese ID
     */
    public boolean agregarEstudiante(Estudiante estudiante) {
        // Verificamos si ya existe un estudiante con el mismo ID
        for (Estudiante e : estudiantes) {
            if (e.getNumeroIdentificacion() == estudiante.getNumeroIdentificacion()) {
                return false; // No se agrega si ya existe ese ID
            }
        }
        // Si no existe, lo agregamos
        return estudiantes.add(estudiante);
    }

    /**
     * Busca un estudiante por su número de identificación.
     *
     * @param numeroIdentificacion ID del estudiante a buscar
     * @return el estudiante encontrado o null si no existe
     */
    public Estudiante buscarEstudiante(int numeroIdentificacion) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getNumeroIdentificacion() == numeroIdentificacion) {
                return estudiante;
            }
        }
        return null; // No se encontró el estudiante
    }

    /**
     * Obtiene la cantidad de estudiantes en la escuela.
     *
     * @return número de estudiantes
     */
    public int getCantidadEstudiantes() {
        return estudiantes.size();
    }

    /**
     * Muestra todos los estudiantes registrados.
     */
    public void mostrarEstudiantes() {
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }

        System.out.println("Lista de estudiantes:");
        for (Estudiante estudiante : estudiantes) {
            System.out.println(estudiante);
        }
    }

    /**
     * Método principal que implementa el menú y la interacción con el usuario.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Escuela escuela = new Escuela();

        // Agregamos al menos tres estudiantes como pide el ejercicio
        escuela.agregarEstudiante(new Estudiante("Ana García", 1001, 8.5));
        escuela.agregarEstudiante(new Estudiante("Luis Martínez", 1002, 9.2));
        escuela.agregarEstudiante(new Estudiante("María López", 1003, 7.8));

        // Buscamos un estudiante para mostrar que el método funciona
        Estudiante estudiante = escuela.buscarEstudiante(1002);
        System.out.println("\nBúsqueda de estudiante con ID 1002:");
        if (estudiante != null) {
            System.out.println("Estudiante encontrado: " + estudiante);
        } else {
            System.out.println("Estudiante no encontrado.");
        }

        // Menú interactivo
        int opcion;
        do {
            System.out.println("\n----- MENÚ GESTIÓN DE ESTUDIANTES -----");
            System.out.println("1. Agregar nuevo estudiante");
            System.out.println("2. Buscar estudiante por ID");
            System.out.println("3. Mostrar todos los estudiantes");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número.");
                opcion = 0; // Valor inválido para volver a mostrar el menú
                continue;
            }

            switch (opcion) {
                case 1: // Agregar estudiante
                    agregarNuevoEstudiante(scanner, escuela);
                    break;

                case 2: // Buscar estudiante
                    buscarEstudiantePorId(scanner, escuela);
                    break;

                case 3: // Mostrar todos
                    escuela.mostrarEstudiantes();
                    break;

                case 4: // Salir
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }

        } while (opcion != 4);

        scanner.close();
    }

    /**
     * Método auxiliar para agregar un nuevo estudiante con validación de datos.
     */
    private static void agregarNuevoEstudiante(Scanner scanner, Escuela escuela) {
        System.out.println("\n--- Agregar nuevo estudiante ---");

        // Ingreso y validación del nombre
        System.out.print("Nombre del estudiante: ");
        String nombre = scanner.nextLine().trim();
        if (nombre.isEmpty()) {
            System.out.println("Error: El nombre no puede estar vacío.");
            return;
        }

        // Ingreso y validación del ID
        int id;
        try {
            System.out.print("Número de identificación: ");
            id = Integer.parseInt(scanner.nextLine());
            if (id <= 0) {
                System.out.println("Error: El ID debe ser un número positivo.");
                return;
            }

            // Verificar si ya existe un estudiante con ese ID
            if (escuela.buscarEstudiante(id) != null) {
                System.out.println("Error: Ya existe un estudiante con ese ID.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: El ID debe ser un número entero.");
            return;
        }

        // Ingreso y validación de la calificación
        double calificacion;
        try {
            System.out.print("Calificación (0-10): ");
            calificacion = Double.parseDouble(scanner.nextLine());
            if (calificacion < 0 || calificacion > 10) {
                System.out.println("Error: La calificación debe estar entre 0 y 10.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: La calificación debe ser un número.");
            return;
        }

        // Crear y agregar el estudiante
        Estudiante nuevoEstudiante = new Estudiante(nombre, id, calificacion);
        if (escuela.agregarEstudiante(nuevoEstudiante)) {
            System.out.println("Estudiante agregado correctamente.");
        } else {
            System.out.println("No se pudo agregar el estudiante.");
        }
    }

    /**
     * Método auxiliar para buscar un estudiante por su ID.
     */
    private static void buscarEstudiantePorId(Scanner scanner, Escuela escuela) {
        System.out.println("\n--- Buscar estudiante por ID ---");

        try {
            System.out.print("Ingrese el ID del estudiante: ");
            int id = Integer.parseInt(scanner.nextLine());

            Estudiante estudiante = escuela.buscarEstudiante(id);
            if (estudiante != null) {
                System.out.println("Estudiante encontrado:");
                System.out.println(estudiante);
            } else {
                System.out.println("No se encontró ningún estudiante con el ID: " + id);
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: El ID debe ser un número entero.");
        }
    }
}