package co.edu.uniquindio.poo.dtosrecords;

public record Cliente() {
    record ClienteRecord(String nombre, String email) {}
}
