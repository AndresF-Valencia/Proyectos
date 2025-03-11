package co.edu.uniquindio.poo.gestionhospitalaria.model;

public class ReglasFacturacion {
    private TipoFacturacion tipoFacturacion;
    private double porcentajeImpuesto;
    private double montoMinimo;
    private MedioPago medioPago;

    public ReglasFacturacion(TipoFacturacion tipoFacturacion, double porcentajeImpuesto, double montoMinimo, MedioPago medioPago) {
        this.tipoFacturacion = tipoFacturacion;
        this.porcentajeImpuesto = porcentajeImpuesto;
        this.montoMinimo = montoMinimo;
        this.medioPago = medioPago;
    }

    public TipoFacturacion getTipoFacturacion() {
        return tipoFacturacion;
    }

    public void setTipoFacturacion(TipoFacturacion tipoFacturacion) {
        this.tipoFacturacion = tipoFacturacion;
    }

    public double getPorcentajeImpuesto() {
        return porcentajeImpuesto;
    }

    public double getMontoMinimo() {
        return montoMinimo;
    }

    public void setMontoMinimo(double montoMinimo) {
        this.montoMinimo = montoMinimo;
    }

    public void setPorcentajeImpuesto(double porcentajeImpuesto) {
        this.porcentajeImpuesto = porcentajeImpuesto;
    }

    public MedioPago getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(MedioPago medioPago) {
        this.medioPago = medioPago;
    }
}
