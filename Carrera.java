public class Carrera {
    private String nombre;
    
    private ListaEnlazada estudiantes; 

    public Carrera(String nombre) {
        this.nombre = nombre;
        
        this.estudiantes = new ListaEnlazada();
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void agregarEstudiante(Estudiante estudiante) {
        
        this.estudiantes.agregar(estudiante);
    }

    
    public Object[] listarEstudiantes() {
        return this.estudiantes.convertirAArray();
    }

    
    public boolean buscarEstudiante(String nombreEstudiante) {
        Nodo actual = this.estudiantes.getPrimero();
        
        while (actual != null) {
            
            Estudiante e = (Estudiante) actual.getDato();
            if (e.getNombre().equalsIgnoreCase(nombreEstudiante)) {
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    public int getContadorEstudiantes() {
        return this.estudiantes.getTamano();
    }

    public void mostrarInformacion(){
        System.out.println("Carrera: " + this.nombre + " - Alumnos: " + this.getContadorEstudiantes());
    }

    @Override
    public String toString() {
        return "Carrera: " + nombre;
    }
}