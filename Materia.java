import java.util.Objects;

public class Materia {
    
    private String nombre;
    private String codigo;
    private int creditos;
    private double calificacion;
    private Profesor profesor; 

    public Materia(String nombre, String codigo, int creditos, double calificacion, Profesor profesor) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.creditos = creditos;
        this.calificacion = calificacion;
        this.profesor = profesor;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCredito() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    
    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }


    public void mostrarInformacion() {
        System.out.println("Materia: " + this.nombre);
        System.out.println("Codigo: " + this.codigo);
        System.out.println("Creditos: " + this.creditos);
        System.out.println("Calificacion: " + this.calificacion);
        // Verificamos que el profesor no sea nulo para evitar errores
        if (this.profesor != null) {
            System.out.println("Profesor: " + this.profesor.getNombre() + " " + this.profesor.getApellido());
        }
    }

    @Override
    public String toString() {
        String nombreProfesor = (this.profesor != null) ? this.profesor.getNombre() + " " + this.profesor.getApellido()
                : "Sin asignar";
        return "Materia: " + this.nombre + ", Codigo: " + this.codigo +
                ", Creditos: " + this.creditos + ", Calificacion: " + this.calificacion +
                ", Profesor: " + nombreProfesor;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Materia materia = (Materia) obj;
        return Objects.equals(codigo, materia.codigo); 
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}