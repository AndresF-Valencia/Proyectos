package co.edu.uniquindio.poo.gestionhospitalaria.model;

import java.util.LinkedList;

public class Paciente extends Persona implements ClonablePaciente {
    private LinkedList<Cita> citas;

    public Paciente(String id,String nombre, int edad) {
        super(id,nombre, edad);
        this.citas = new LinkedList<>();
    }

    @Override
    public Paciente clone() {
        try {
            return (Paciente) super.clone();
        } catch (CloneNotSupportedException e) {
            throw  new RuntimeException("El paciente no puede ser Cloneable");
        }
    }

    public LinkedList<Cita> getCitas() {
        return citas;
    }

    public void setCitas(LinkedList<Cita> citas) {
        this.citas = citas;
    }

    @Override
    public String toString() {
        return "Paciente{"+ super.toString() +"citas=" + citas + "}";
    }
}
