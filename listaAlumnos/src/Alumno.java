public class Alumno {
    private String matricula;
    private String nombre;
    private int grado;
    private String grupo;

    public Alumno(String matricula, String nombre, int grado, String grupo) {
        if (!esMatriculaValida(matricula == null ? null : matricula.trim())) {
            throw new IllegalArgumentException("La matrícula debe tener exactamente 6 dígitos.");
        }
        this.matricula = matricula.trim();
        this.nombre = nombre.trim();
        this.grado = grado;
        this.grupo = grupo.trim().toUpperCase();
    }

    public static boolean esMatriculaValida(String matricula) {
        return matricula != null && matricula.matches("[0-9]{6}");
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        if (matricula == null || !esMatriculaValida(matricula.trim())) {
            throw new IllegalArgumentException("La matrícula debe tener exactamente 6 dígitos.");
        }
        this.matricula = matricula.trim();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getGrado() {
        return grado;
    }

    public void setGrado(int grado) {
        this.grado = grado;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public int compareTo(Alumno otro) {
        int compMatricula = this.matricula.compareToIgnoreCase(otro.matricula);
        if (compMatricula != 0) {
            return compMatricula;
        }
        int compGrado = Integer.compare(this.grado, otro.grado);
        if (compGrado != 0) {
            return compGrado;
        }
        return this.nombre.compareToIgnoreCase(otro.nombre);
    }

    @Override
    public String toString() {
        return String.format("%-10s | %d°%s | %s", matricula, grado, grupo, nombre);
    }
}