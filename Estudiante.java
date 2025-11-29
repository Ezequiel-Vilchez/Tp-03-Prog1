public class Estudiante extends Persona implements MiembroUniversidad {

    private String carrera;
    private double promedio;
    private ListaEnlazada materias;
    private Pila tareasPendientes;
    
    public Estudiante(String nombre, String apellido, int edad, String documento, String carrera) {
        super(nombre, apellido, edad, documento);
        this.carrera = carrera;
        this.materias = new ListaEnlazada(); 
        this.promedio = 0.0;
        this.tareasPendientes = new Pila();
    }

    public void agregarMateria(Materia m) {
        materias.agregar(m);
        this.calcularPromedioRecursivo();
    }

    
    public void agregarTarea(String descripcion, Materia materia, String fechaLimite, int prioridad){
        Tarea nuevaTarea = new Tarea(descripcion, materia, fechaLimite, prioridad);
        tareasPendientes.push(nuevaTarea);
        System.out.println(this.getNombre() + " agrego la tarea: " + descripcion );
    }

    public void realizarUltimaTarea(){
        if(!tareasPendientes.estaVacia()){
            
            Tarea tareaRealizada = (Tarea)  tareasPendientes.pop();
            System.out.println(this.getNombre() + " hizo la tarea: " + tareaRealizada);

        }else {
            System.out.println(this.getNombre() + " no hay tareas pendientes");
        }
    }

    
    public double calcularPromedioRecursivo() {
        if (materias.estaVacia()) {
            return 0.0;
        }

        
        this.promedio = calcularPromedioInterno(materias.getPrimero(),0,0.0);
        return this.promedio;
    }
    
    
    private double calcularPromedioInterno(Nodo actual, int contador, double suma) {
        
        
        if (actual == null) {
            
            return contador == 0 ? 0 : suma / contador;
        }

        Materia materia = (Materia) actual.getDato();
        return calcularPromedioInterno(
                actual.getSiguiente(),       
                contador + 1,               
                suma + materia.getCalificacion()    
        );
    }

    public String getCarrera() {
        return carrera;
    }

    public double getPromedio() {
        return promedio;
    }

    @Override
    public String obtenerRol() {
        return "Estudiante";
    }

    @Override
    public String obtenerInformacionCompleta() {
        return "Estudiante: " + getNombre() + " " + getApellido() + " - Promedio: " + String.format("%.2f", promedio);
    }
}