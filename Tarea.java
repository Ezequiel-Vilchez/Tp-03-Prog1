public class Tarea {
    private String descripcion;
    private Materia materia;
    private String fechaLimite;
    private int prioridad;

    public Tarea(String descripcion,Materia materia,String fechaLimite,int prioridad){
        this.descripcion = descripcion;
        this.materia = materia;
        this.fechaLimite = fechaLimite;
        this.prioridad = prioridad;
    }
    
    public String getDescripcion(){
        return this.descripcion;
    }
    public Materia getMateria(){
        return this.materia;
    }
    public String getFechaLimite(){
        return this.fechaLimite;
    }
    public int getPrioridad(){
        return this.prioridad;
    }

    @Override
    public String toString(){
        String nombreMateria = (this.materia != null) ? materia.getNombre() : "Sin materia";//Validacion por si la materia es null
        return "Tarea: " + this.descripcion + " ,Materia: " + nombreMateria + " ,Vence:"+ this.fechaLimite +" (Prioridad: " + this.prioridad + ")";
    }
}
