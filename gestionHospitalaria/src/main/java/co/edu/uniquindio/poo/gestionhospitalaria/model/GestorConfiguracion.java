package co.edu.uniquindio.poo.gestionhospitalaria.model;

public class GestorConfiguracion {
    private String horarioatencion;
    private int numMaxPacientesPorDoctor;
    private ReglasFacturacion reglasFacturacion;
    private static GestorConfiguracion instancia;

    private GestorConfiguracion() {
        this.horarioatencion = horarioatencion;
        this.numMaxPacientesPorDoctor = numMaxPacientesPorDoctor;
        this.reglasFacturacion = reglasFacturacion;
    }

    public static GestorConfiguracion getInstancia() {
        if (instancia == null) {
            instancia = new GestorConfiguracion();
        }
        return instancia;
    }

    public String getHorarioatencion() {
        return horarioatencion;
    }

    public void setHorarioatencion(String horarioatencion) {
        this.horarioatencion = horarioatencion;
    }

    public int getNumMaxPacientesPorDoctor() {
        return numMaxPacientesPorDoctor;
    }

    public void setNumMaxPacientesPorDoctor(int numMaxPacientesPorDoctor) {
        this.numMaxPacientesPorDoctor = numMaxPacientesPorDoctor;
    }

    public ReglasFacturacion getReglasFacturacion() {
        return reglasFacturacion;
    }

    public void setReglasFacturacion(ReglasFacturacion reglasFacturacion) {
        this.reglasFacturacion = reglasFacturacion;
    }
}
