/**
 * Clase Estudiante que representa a un estudiante con nombre, número de identificación y calificación.
 */
public class Estudiante {
    // Atributos
    private String nombre;
    private int numeroIdentificacion;
    private double calificacion;

    /**
     * Constructor para inicializar un objeto Estudiante con todos sus atributos.
     *
     * @param nombre Nombre del estudiante
     * @param numeroIdentificacion Número único de identificación
     * @param calificacion Calificación del estudiante
     */
    public Estudiante(String nombre, int numeroIdentificacion, double calificacion) {
        this.nombre = nombre;
        this.numeroIdentificacion = numeroIdentificacion;
        this.calificacion = calificacion;
    }

    /**
     * Obtiene el nombre del estudiante.
     *
     * @return nombre del estudiante
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del estudiante.
     *
     * @param nombre nuevo nombre del estudiante
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el número de identificación del estudiante.
     *
     * @return número de identificación
     */
    public int getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    /**
     * Establece el número de identificación del estudiante.
     *
     * @param numeroIdentificacion nuevo número de identificación
     */
    public void setNumeroIdentificacion(int numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    /**
     * Obtiene la calificación del estudiante.
     *
     * @return calificación del estudiante
     */
    public double getCalificacion() {
        return calificacion;
    }

    /**
     * Establece la calificación del estudiante.
     *
     * @param calificacion nueva calificación
     */
    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    /**
     * Retorna una representación en texto del estudiante.
     *
     * @return cadena con la información del estudiante
     */
    @Override
    public String toString() {
        return "Estudiante [ID: " + numeroIdentificacion +
                ", Nombre: " + nombre +
                ", Calificación: " + calificacion + "]";
    }
}