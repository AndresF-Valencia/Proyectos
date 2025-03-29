package co.edu.uniquindio.poo.dtosrecords;

public record ClienteDTOComoRecord() {
    record ClienteDTO(String nombre, String direccion) {}
}
