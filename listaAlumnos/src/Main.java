import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaAlumnos lista = new ListaAlumnos();

        // datos de prueba
        lista.agregar(new Alumno("240102", "Franco Morales", 4, "C"));
        lista.agregar(new Alumno("240101", "Erick Domínguez", 4, "C"));
        lista.agregar(new Alumno("240105", "Valeria Gómez", 4, "C"));

        int opcion = 0;

        do {
            System.out.println("\n---- CONTROL DE ALUMNOS INSCRITOS ----");
            System.out.println("1. Agregar alumno");
            System.out.println("2. Eliminar alumno");
            System.out.println("3. Buscar alumno");
            System.out.println("4. Ver lista de alumnos");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Por favor ingresa un número válido.");
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.println("\n--- AGREGAR ALUMNO ---");
                    String mat;
                    do {
                        System.out.print("Matrícula (6 dígitos): ");
                        mat = scanner.nextLine().trim();
                        if (!Alumno.esMatriculaValida(mat)) {
                            System.out.println("La matrícula debe tener exactamente 6 dígitos.");
                        }
                    } while (!Alumno.esMatriculaValida(mat));

                    System.out.print("Nombre completo: ");
                    String nom = scanner.nextLine().trim();
                    System.out.print("Grado: ");
                    int grado = 1;
                    try {
                        grado = Integer.parseInt(scanner.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Grado inválido, se asignó 1 por defecto.");
                    }
                    System.out.print("Grupo: ");
                    String grupo = scanner.nextLine().trim();

                    if (lista.agregar(new Alumno(mat, nom, grado, grupo))) {
                        System.out.println("Alumno registrado correctamente.");
                    }
                    break;

                case 2:
                    System.out.println("\n--- ELIMINAR ALUMNO ---");
                    System.out.print("Ingresa la matrícula del alumno que deseas eliminar: ");
                    String matEliminar = scanner.nextLine().trim();

                    if (lista.eliminar(matEliminar)) {
                        System.out.println("Alumno eliminado correctamente.");
                    } else {
                        System.out.println("No se encontró ningún alumno con esa matrícula.");
                    }
                    break;

                case 3:
                    System.out.println("\n--- BUSCAR ALUMNO ---");
                    System.out.print("Ingresa la matrícula: ");
                    String matBuscar = scanner.nextLine().trim();

                    Alumno encontrado = lista.buscar(matBuscar);
                    if (encontrado != null) {
                        System.out.println("Encontrado: " + encontrado);
                    } else {
                        System.out.println("No se encontró al alumno.");
                    }
                    break;

                case 4:
                    lista.mostrar();
                    break;

                case 5:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 5);

        scanner.close();
    }
}