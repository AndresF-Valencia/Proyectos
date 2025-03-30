package co.edu.uniquindio.poo.dtosrecords.controllers;

import co.edu.uniquindio.poo.dtosrecords.ProductoDTO;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class ProductoController {
    @FXML private TextField nombreField;
    @FXML private TextField precioField;
    @FXML private Label resultadoLabel;

    public void registrarProducto() {
        String nombre = nombreField.getText();
        double precio = Double.parseDouble(precioField.getText());

        ProductoDTO producto = new ProductoDTO(nombre, precio);
        resultadoLabel.setText("Producto: " + producto.getNombre() + " - $" + producto.getPrecio());
    }
}