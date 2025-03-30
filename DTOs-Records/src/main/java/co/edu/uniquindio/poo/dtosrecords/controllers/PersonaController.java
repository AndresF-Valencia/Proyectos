package co.edu.uniquindio.poo.dtosrecords.controllers;

import co.edu.uniquindio.poo.dtosrecords.PersonaDTO;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class PersonaController {
    @FXML private TextField nombreField;
    @FXML private TextField edadField;
    @FXML private Label resultadoLabel;

    public void registrarPersona() {
        String nombre = nombreField.getText();
        int edad = Integer.parseInt(edadField.getText());

        PersonaDTO persona = new PersonaDTO(nombre, edad);
        resultadoLabel.setText("Registrado: " + persona.getNombre() + " - " + persona.getEdad() + "años");
    }

}