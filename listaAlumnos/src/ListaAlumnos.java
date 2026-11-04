public class ListaAlumnos {
    private Nodo primero;
    private int cantidad;

    public ListaAlumnos() {
        this.primero = null;
        this.cantidad = 0;
    }

    public boolean estaVacia() {
        return primero == null;
    }

    public int getCantidad() {
        return cantidad;
    }

    public boolean agregar(Alumno alumno) {
        if (alumno == null) return false;

        if (buscar(alumno.getMatricula()) != null) {
            System.out.println("Ya existe un alumno con esa matrícula.");
            return false;
        }

        Nodo nuevo = new Nodo(alumno);

        if (primero == null || alumno.compareTo(primero.alumno) < 0) {
            nuevo.siguiente = primero;
            primero = nuevo;
            cantidad++;
            return true;
        }

        Nodo actual = primero;
        while (actual.siguiente != null && actual.siguiente.alumno.compareTo(alumno) < 0) {
            actual = actual.siguiente;
        }

        nuevo.siguiente = actual.siguiente;
        actual.siguiente = nuevo;
        cantidad++;
        return true;
    }

    public boolean eliminar(String matricula) {
        if (estaVacia() || matricula == null) return false;

        matricula = matricula.trim();

        if (primero.alumno.getMatricula().equalsIgnoreCase(matricula)) {
            primero = primero.siguiente;
            cantidad--;
            return true;
        }

        Nodo anterior = primero;
        Nodo actual = primero.siguiente;

        while (actual != null && !actual.alumno.getMatricula().equalsIgnoreCase(matricula)) {
            anterior = actual;
            actual = actual.siguiente;
        }

        if (actual != null) {
            anterior.siguiente = actual.siguiente;
            cantidad--;
            return true;
        }

        return false;
    }

    public Alumno buscar(String matricula) {
        if (matricula == null) return null;

        Nodo actual = primero;
        while (actual != null) {
            if (actual.alumno.getMatricula().equalsIgnoreCase(matricula.trim())) {
                return actual.alumno;
            }
            actual = actual.siguiente;
        }
        return null;
    }

    public void mostrar() {
        if (estaVacia()) {
            System.out.println("No hay alumnos inscritos en esta materia.");
            return;
        }

        System.out.println("\n--- LISTA DE ALUMNOS INSCRITOS (" + cantidad + ") ---");
        System.out.printf("%-4s %-10s | %-5s | %s\n", "N°", "Matrícula", "Grupo", "Nombre");
        System.out.println("--------------------------------------------------");

        Nodo actual = primero;
        int num = 1;
        while (actual != null) {
            System.out.printf("%-4d %s\n", num++, actual.alumno.toString());
            actual = actual.siguiente;
        }
        System.out.println("--------------------------------------------------");
    }
}