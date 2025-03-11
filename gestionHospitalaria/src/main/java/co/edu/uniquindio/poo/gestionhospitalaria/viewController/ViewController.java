package co.edu.uniquindio.poo.gestionhospitalaria.viewController;

import co.edu.uniquindio.poo.gestionhospitalaria.model.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import java.util.ArrayList;

public class ViewController {
    private Hospital hospital = new Hospital("San Juan");

    @FXML
    private Pane citas,doctor,paciente;

    @FXML
    private Label LabelTitulo;

    @FXML
    private TextField fechaCita, horaCita, asuntoCita, cedulaPaciente, cedulaDoctor, nombrePaciente, nombreDoctor, edadPaciente, edadDoctor;

    @FXML
    private Button agregarPaciente,agregarDoctor,agregarCita;

    @FXML
    private Button eliminarPaciente,eliminarDoctor,eliminarCita;

    @FXML
    private Button actualizarPaciente,actualizarDoctor,actualizarCita;

    @FXML
    private Button palindromos,vocales,accesoPaciente,accesoDoctor,accesoCita;

    @FXML
    private TableView<Cita> tablaCita;

    @FXML
    private TableView<Doctor> tablaDoctor;

    @FXML
    private TableView<Paciente> tablaPaciente,tablaPalindromos,tablaVocales;

    @FXML
    private TableColumn<Paciente, String> nombrepaciente,nombrePalindromos,nombreVocales,edadpaciente,cedulapaciente,cedulaPalindromos,edadPalindromos,edadVocales,cedulaVocales;

    @FXML
    private TableColumn<Doctor, String> nombredoctor,ceduladoctor,edaddoctor;

    @FXML
    private TableColumn<Cita, String> fecha,hora;

    @FXML
    private void initialize() {
        citas.setVisible(false);
        doctor.setVisible(false);
        paciente.setVisible(false);
        tablaPalindromos.setVisible(false);
        tablaVocales.setVisible(false);

        cedulapaciente.setCellValueFactory(new PropertyValueFactory<>("id"));
        nombrepaciente.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        edadpaciente.setCellValueFactory(new PropertyValueFactory<>("edad"));
        ceduladoctor.setCellValueFactory(new PropertyValueFactory<>("id"));
        nombredoctor.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        edaddoctor.setCellValueFactory(new PropertyValueFactory<>("edad"));
        fecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        hora.setCellValueFactory(new PropertyValueFactory<>("hora"));
        nombrePalindromos.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        edadPalindromos.setCellValueFactory(new PropertyValueFactory<>("edad"));
        cedulaPalindromos.setCellValueFactory(new PropertyValueFactory<>("id"));
        nombreVocales.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        edadVocales.setCellValueFactory(new PropertyValueFactory<>("edad"));
        cedulaVocales.setCellValueFactory(new PropertyValueFactory<>("id"));

        tablaCita.setItems(hospital.getCitasObservableList());
        tablaDoctor.setItems(hospital.getDoctoresObservableList());
        tablaPaciente.setItems(hospital.getPacientesObservableList());
        tablaPalindromos.setItems(hospital.getPalindromosObservableList());
        tablaVocales.setItems(hospital.getVocalesObservableList());



        agregarPaciente.setOnAction(event -> agregarPaciente());
        agregarDoctor.setOnAction(event -> agregarDoctor());
        agregarCita.setOnAction(event -> agregarCita());
        eliminarPaciente.setOnAction(event -> eliminarPaciente());
        eliminarDoctor.setOnAction(event -> eliminarDoctor());
        eliminarCita.setOnAction(event -> eliminarCita());
        actualizarPaciente.setOnAction(event -> actualizarPaciente());
        actualizarDoctor.setOnAction(event -> actualizarDoctor());
        actualizarCita.setOnAction(event -> actualizarCita());

        palindromos.setOnAction(event -> palindromos());
        vocales.setOnAction(event -> vocales());
        accesoPaciente.setOnAction(event -> interfazPaciente() );
        accesoCita.setOnAction(event -> interfazCita());
        accesoDoctor.setOnAction(event -> interfazDoctor());

    }

    @FXML
    private void agregarPaciente() {
        String cedula = cedulaPaciente.getText();
        String nombre = nombrePaciente.getText();
        int edad = Integer.parseInt(edadPaciente.getText());

        Paciente pacienteOriginal = new Paciente(cedula, nombre, edad);
        Paciente pacienteClonado = pacienteOriginal.clone();

        hospital.agregarPaciente(pacienteClonado);
        hospital.getPacientesObservableList().add(pacienteClonado);
        tablaPaciente.refresh();

        cedulaPaciente.clear();
        nombrePaciente.clear();
        edadPaciente.clear();
    }

    @FXML
    private void agregarDoctor() {
        String id = cedulaDoctor.getText();
        String nombre = nombreDoctor.getText();
        int edad = Integer.parseInt(edadDoctor.getText());
        Doctor doctor = new Doctor(id, nombre, edad);
        hospital.agregarDoctor(doctor);
        hospital.getDoctoresObservableList().add(doctor);
        tablaDoctor.refresh();

        cedulaDoctor.clear();
        nombreDoctor.clear();
        edadDoctor.clear();
    }
    @FXML
    private void agregarCita() {
        String fecha = fechaCita.getText();
        String hora = horaCita.getText();
        String asunto = asuntoCita.getText();

        Cita cita = new Cita(fecha, hora, asunto);
        hospital.reservarCita(cita);
        hospital.getCitasObservableList().add(cita);
        hospital.ordenarCitas();
        tablaCita.refresh();

        fechaCita.clear();
        horaCita.clear();
        asuntoCita.clear();
    }

    @FXML
    private void eliminarPaciente() {
        Paciente paciente = tablaPaciente.getSelectionModel().getSelectedItem();
        hospital.eliminarPaciente(paciente);
        hospital.getPacientesObservableList().remove(paciente);
        tablaPaciente.refresh();
    }

    @FXML
    private void eliminarDoctor() {
        Doctor doctor = tablaDoctor.getSelectionModel().getSelectedItem();
        hospital.eliminarDoctor(doctor);
        hospital.getDoctoresObservableList().remove(doctor);
        tablaDoctor.refresh();
    }

    @FXML
    private void eliminarCita() {
        Cita cita = tablaCita.getSelectionModel().getSelectedItem();
        hospital.eliminarCita(cita);
        hospital.getCitasObservableList().remove(cita);
        tablaCita.refresh();
    }

    @FXML
    private void actualizarPaciente() {
        String cedula = cedulaPaciente.getText();
        String nombre = nombrePaciente.getText();
        int edad = Integer.parseInt(edadPaciente.getText());
        hospital.actualizarPacientes(cedula, nombre, edad);
        tablaPaciente.refresh();

        cedulaPaciente.clear();
        nombrePaciente.clear();
        edadPaciente.clear();
    }

    @FXML
    private void actualizarDoctor() {
        String cedula = cedulaDoctor.getText();
        String nombre = nombreDoctor.getText();
        int edad = Integer.parseInt(edadDoctor.getText());
        hospital.actualizarDoctors(cedula, nombre, edad);
        tablaDoctor.refresh();

        cedulaDoctor.clear();
        nombreDoctor.clear();
        edadDoctor.clear();
    }

    @FXML
    private void actualizarCita() {
        String fecha = fechaCita.getText();
        String hora = horaCita.getText();
        String asunto = asuntoCita.getText();
        hospital.actualizarCita(fecha, hora, asunto);
        tablaCita.refresh();

        fechaCita.clear();
        horaCita.clear();
        asuntoCita.clear();
    }

    @FXML
    private void palindromos() {
        ArrayList<Paciente> palindromos=hospital.obtenerPalindromos(hospital.getListaPacientes());
        hospital.getPalindromosObservableList().addAll(palindromos);
        tablaPaciente.setVisible(false);
        tablaPalindromos.setVisible(true);
    }

    @FXML
    private void vocales(){
        ArrayList<Paciente> vocales=hospital.obtenerPacientesVocalesRepetidas(hospital.getListaPacientes());
        hospital.getVocalesObservableList().addAll(vocales);
        tablaPalindromos.setVisible(false);
        tablaVocales.setVisible(true);
    }

    @FXML
    private void interfazPaciente() {
        LabelTitulo.setVisible(false);
        doctor.setVisible(false);
        citas.setVisible(false);
        paciente.setVisible(true);
    }

    @FXML
    private void interfazDoctor() {
        LabelTitulo.setVisible(false);
        paciente.setVisible(false);
        citas.setVisible(false);
        doctor.setVisible(true);
    }

    @FXML
    private void interfazCita() {
        LabelTitulo.setVisible(false);
        paciente.setVisible(false);
        doctor.setVisible(false);
        citas.setVisible(true);
    }


}
