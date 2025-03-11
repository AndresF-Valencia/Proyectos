package co.edu.uniquindio.poo.gestionhospitalaria.model;

import java.util.LinkedList;

public class Doctor extends Persona {
    private LinkedList<Cita> citas;

    public Doctor(String id,String nombre, int edad) {
        super(id,nombre, edad);
    }

    public LinkedList<Cita> getCitas() {
        return citas;
    }

    public void setCitas(LinkedList<Cita> citas) {
        this.citas = citas;
    }

    @Override
    public String toString() {
        return "Doctor{"+super.toString()+"}";
    }
}
