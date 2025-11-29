public class Profesor extends Persona implements MiembroUniversidad {
    private String especialidad;
    private String aniosDeExperencia;
    private ListaEnlazada materiasAsignadas; 
    private Cola turnosConsultas;

    public Profesor(String nombre, String apellido, int edad, String documento, String especialidad, String aniosDeExperencia) {
        super(nombre, apellido, edad, documento);
        this.especialidad = especialidad;
        this.aniosDeExperencia = aniosDeExperencia;
        this.materiasAsignadas = new ListaEnlazada();
        this.turnosConsultas = new Cola();//inicializa la cola vacia
    }

    public void asignarMateria(Materia materia) {
        
        materiasAsignadas.agregar(materia);
        System.out.println("El profesor " + this.getNombre() + " se ha inscrito a la materia: " + materia.getNombre());
    }
    //agrega un turno a la cola
    public void agregarConsulta(Estudiante estudiante,String motivo, String horaLlegada, int duracionEstimada){
        //se crea el objeto turno con todos los datos requeridos
        TurnoConsulta turno = new TurnoConsulta(estudiante,motivo,horaLlegada,duracionEstimada);

        //lo metemos al final de la cola
        turnosConsultas.insertar(turno);
        System.out.println("Turno asignado a " + estudiante.getNombre() + "(" + horaLlegada + ") con el profesor " + this.getNombre());
    }
    //metodo para atender al siguiente estudiante en la cola
    public void atenderSiguienteEstudiante(){
        if(!turnosConsultas.estaVacia()){
            //sacamos el primero de la fila
            TurnoConsulta turno = (TurnoConsulta) turnosConsultas.quitar();
            System.out.println("El profesor "+ this.getNombre() + " esta atendiendo a " + turno.getEstudiante().getNombre());
            System.out.println("Detalle: "+ turno.toString());
        }else{
            System.out.println("El profesor " + this.getNombre() + " no tiene consultas pendientes ");
        }
    }

    public String getEspecialidad() { 
        return especialidad; 
    }
    public void setEspecialidad(String especialidad) { 
        this.especialidad = especialidad; 
    }
    public String getAniosDeExperencia() { 
        return aniosDeExperencia; 
    }
    public void setAniosDeExperencia(String aniosDeExperencia) { 
        this.aniosDeExperencia = aniosDeExperencia; 
    }

    @Override
    public String obtenerRol() { 
        return "Profesor"; 
    }

    @Override
    public String obtenerInformacionCompleta() {
        return "Profesor: " + getNombre() + " " + getApellido() + ", Especialidad: " + especialidad;
    }
    
    @Override
    public String toString() { 
        return obtenerInformacionCompleta();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Profesor that = (Profesor) obj;
        return this.documento.equals(that.documento);
    }
}

