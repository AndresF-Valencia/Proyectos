package co.edu.uniquindio.poo.gestionhospitalaria.model;

public class HistorialMedicamentos {
    private String id;
    private String medicamento;
    private String dosis;

    public HistorialMedicamentos(String id, String medicamento, String dosis) {
        this.id = id;
        this.medicamento = medicamento;
        this.dosis = dosis;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
