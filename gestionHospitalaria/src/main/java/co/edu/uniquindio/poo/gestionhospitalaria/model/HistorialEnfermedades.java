package co.edu.uniquindio.poo.gestionhospitalaria.model;

import java.time.LocalDate;

public class HistorialEnfermedades {
    private String id;
    private LocalDate fechaDiagnostico;
    private String diagnostico;
    private EstadoEnfermedad estado;

    public HistorialEnfermedades(String id, LocalDate fechaDiagnostico, String diagnostico, EstadoEnfermedad estado) {
        this.id = id;
        this.fechaDiagnostico = fechaDiagnostico;
        this.diagnostico = diagnostico;
        this.estado = EstadoEnfermedad.ACTIVA;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getFechaDiagnostico() {
        return fechaDiagnostico;
    }

    public void setFechaDiagnostico(LocalDate fechaDiagnostico) {
        this.fechaDiagnostico = fechaDiagnostico;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public EstadoEnfermedad getEstado() {
        return estado;
    }

    public void setEstado(EstadoEnfermedad estado) {
        this.estado = estado;
    }
}
