public class TurnoConsulta {
    private Estudiante estudiante;
    private String motivo;
    private String horaLlegada;
    private int duracionEstimada;

    public TurnoConsulta(Estudiante estudiante, String motivo, String horaLlegada, int duracionEstimada) {
        this.estudiante = estudiante;
        this.motivo = motivo;
        this.horaLlegada = horaLlegada;
        this.duracionEstimada = duracionEstimada;
    }

    public Estudiante getEstudiante(){
        return estudiante;
    }

    @Override
    public String toString(){
        return " consulta: " + estudiante.getNombre() + " ,Motivo: " + this.motivo + " ,Hora de llegada: " + this.horaLlegada + " ,Duracion estimada: " + this.duracionEstimada + " min"; 
    }
}
