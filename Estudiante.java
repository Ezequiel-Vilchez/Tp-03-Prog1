public class Estudiante extends Persona implements MiembroUniversidad {

    private String carrera;
    private double promedio;
    private ListaEnlazada materias;
    private Pila tareasPendientes;
    
    public Estudiante(String nombre, String apellido, int edad, String documento, String carrera) {
        super(nombre, apellido, edad, documento);
        this.carrera = carrera;
        this.materias = new ListaEnlazada(); //Crea la lista vacia
        this.promedio = 0.0;
        this.tareasPendientes = new Pila();//crea la pila vacia
    }

    public void agregarMateria(Materia m) {
        materias.agregar(m);
        this.calcularPromedioRecursivo();
    }

    //Metodo para agregar tarea a la pila
    public void agregarTarea(String descripcion, Materia materia, String fechaLimite, int prioridad){
        Tarea nuevaTarea = new Tarea(descripcion, materia, fechaLimite, prioridad);
        tareasPendientes.push(nuevaTarea);
        System.out.println(this.getNombre() + " agrego la tarea: " + descripcion );
    }

    public void realizarUltimaTarea(){
        //verificamos si hay tareas pendientes
        if(!tareasPendientes.estaVacia()){
            // 2. Sacamos la tarea de la cima (quitar devuelve Object)
            // 3. Hacemos el Casting (Tarea) para que Java sepa qué tipo de objeto es
            Tarea tareaRealizada = (Tarea)  tareasPendientes.pop();
            System.out.println(this.getNombre() + " hizo la tarea: " + tareaRealizada);

        }else {
            System.out.println(this.getNombre() + " no hay tareas pendientes");
        }
    }

    
    public double calcularPromedioRecursivo() {
        if (materias.estaVacia()) {//si no hay materias retorna el promedio 0
            this.promedio = 0.0;
            return 0.0;
        }

        //llama al metodo recursivo empezando por el primer nodo
        this.promedio = calcularPromedioInterno(materias.getPrimero(),0,0.0);
        return this.promedio;
    }
    
    //Este método se llama a sí mismo una y otra vez, viajando por la lista de materias hasta que actual es null (fin de la lista). En ese momento, devuelve la división final (suma / contador).    
    private double calcularPromedioInterno(Nodo actual, int contador, double suma) {
        
        
        if (actual == null) {
            
            return contador == 0 ? 0 : suma / contador;
        }

        Materia materia = (Materia) actual.getDato();//recuperamos la materia del nodo actual
        return calcularPromedioInterno(
                actual.getSiguiente(),       //avanzamos al siguiente nodo
                contador + 1,                //contamos una materia mas
                suma + materia.getCalificacion()    //sumamos la nota 
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