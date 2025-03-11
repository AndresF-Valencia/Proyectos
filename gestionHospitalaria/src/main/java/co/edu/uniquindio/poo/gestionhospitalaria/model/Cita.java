package co.edu.uniquindio.poo.gestionhospitalaria.model;

import java.time.LocalDate;
import java.util.Random;

public class Cita {
    private String codigo;
    private LocalDate fecha;
    private String asunto;
    private String hora;
    private Paciente paciente;
    private Doctor doctor;

    public Cita(String fecha, String hora, String asunto) {
        this.fecha = LocalDate.parse(fecha);
        this.hora = hora;
        this.asunto = asunto;
        this.codigo = generarCodigo();
    }

    public String generarCodigo(){
        Random r = new Random();
        return codigo = String.valueOf(r.nextInt(900000) + 100000);
    }

    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public String getHora() {
        return hora;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    @Override
    public String toString() {
        return "Cita{" +
                "fecha=" + fecha +
                ", hora='" + hora + '\'' +
                '}';
    }
}
