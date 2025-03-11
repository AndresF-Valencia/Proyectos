package co.edu.uniquindio.poo.gestionhospitalaria.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Hospital {
    private String nombre;
    protected GestorConfiguracion gestorConfiguracion;
    private ArrayList<Paciente> ListaPacientes = new ArrayList<>();
    private ArrayList<Doctor> ListaDoctores = new ArrayList<>();
    private ArrayList<ReglasFacturacion> facturaciones = new ArrayList<>();
    private ArrayList<HistorialEnfermedades> historialEnfermedades= new ArrayList<>();
    private ArrayList<Cita> ListaCitas= new ArrayList<>();


    public Hospital(String nombre) {
        this.nombre = nombre;
        this.gestorConfiguracion= GestorConfiguracion.getInstancia();
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private ObservableList<Cita> citasObservableList = FXCollections.observableArrayList(ListaCitas);
    private ObservableList<Doctor> doctoresObservableList = FXCollections.observableArrayList(ListaDoctores);
    private ObservableList<Paciente> pacientesObservableList = FXCollections.observableArrayList(ListaPacientes);
    private ObservableList<Paciente> palindromosObservableList = FXCollections.observableArrayList(obtenerPalindromos(ListaPacientes));
    private ObservableList<Paciente> vocalesObservableList = FXCollections.observableArrayList(obtenerPacientesVocalesRepetidas(ListaPacientes));
    public ObservableList<Cita> getCitasObservableList() {
        return citasObservableList;
    }

    public ObservableList<Doctor> getDoctoresObservableList() {
        return doctoresObservableList;
    }

    public ObservableList<Paciente> getPacientesObservableList() {
        return pacientesObservableList;
    }
    public ObservableList<Paciente> getPalindromosObservableList() {
        return palindromosObservableList;
    }
    public ObservableList<Paciente> getVocalesObservableList() {
        return vocalesObservableList;
    }

    public void agregarPaciente(Paciente paciente) {
        if (!verificarPaciente(paciente)) {
            ListaPacientes.add(paciente);
        }
    }
    public void agregarDoctor(Doctor doctor) {
        if (!verificarDoctor(doctor)) {
            ListaDoctores.add(doctor);
        }
    }
    public void reservarCita(Cita cita) {
        if (!verificarCita(cita)) {
            ListaCitas.add(cita);
            ordenarCitas();
        }
    }
    public void actualizarCita(String fecha, String hora, String asunto) {
        for (Cita cita : ListaCitas) {
            cita.setFecha(LocalDate.parse(fecha));
            cita.setHora(hora);
            cita.setAsunto(asunto);
            cita.toString();
        }
    }

    public void ordenarCitas() {
        Collections.sort(citasObservableList, new Comparator<Cita>() {
            @Override
            public int compare(Cita o1, Cita o2) {
                return o1.getFecha().compareTo(o2.getFecha());
            }
        });
    }
    public void mostrarCitas() {
        if (ListaCitas.isEmpty()) {
            System.out.println("No hay citas registradas");
        } else {
            for (Cita cita : ListaCitas) {
                System.out.println(cita);
            }
        }
    }

    public void eliminarPaciente(Paciente paciente) {
        if (!verificarPaciente(paciente)) {
            ListaPacientes.remove(paciente);
        }
    }
    public void eliminarDoctor(Doctor doctor) {
        if (!verificarDoctor(doctor)) {
            ListaDoctores.remove(doctor);
        }
    }
    public void eliminarCita(Cita cita) {
        if (!verificarCita(cita)) {
            ListaCitas.remove(cita);
        }
    }
    public boolean verificarPaciente(Paciente paciente) {
        boolean verificado = false;
        for (Paciente p : ListaPacientes) {
            if (p.getId().equals(paciente.getId())) {
                verificado = true;
                break;
            }
        }
        return verificado;
    }
    public boolean verificarCita(Cita cita) {
        boolean verificado = false;
        for (Cita c : ListaCitas) {
            if(c.getCodigo().equals(cita.getCodigo())) {
                verificado = true;
                break;
            }
        }
        return verificado;
    }
    public boolean verificarDoctor(Doctor doctor) {
        boolean verificado = false;
        for (Doctor doc : ListaDoctores) {
            if (doc.getId().equals(doctor.getId())) {
                verificado = true;
                break;
            }
        }
        return verificado;
    }
    public void leerPacientes(String id) {
        for(Paciente p : ListaPacientes) {
            if (p.getId().equals(id)) {
                ListaCitas.toString();
            }
        }
    }
    public void leerDoctors(String id) {
        for(Doctor doc : ListaDoctores) {
            if(doc.getId().equals(id)) {
                ListaDoctores.toString();
            }
        }
    }

    public void actualizarPacientes(String id,String nombre,int edad) {
        for(Paciente p : ListaPacientes) {
            if(p.getId().equals(id)) {
                p.setNombre(nombre);
                p.setEdad(edad);
                p.toString();
            }
        }
    }
    public void actualizarDoctors(String id,String nombre,int edad) {
        for(Doctor doc : ListaDoctores) {
            if(doc.getId().equals(id)) {
                doc.setNombre(nombre);
                doc.setEdad(edad);
                doc.toString();
            }
        }
    }

    public static boolean nombrePalindromo(String nombre) {
        String nombreMinuscula = nombre.toLowerCase();
        int izquierda = 0, derecha = nombreMinuscula.length() - 1;
        while (izquierda < derecha) {
            if (nombreMinuscula.charAt(izquierda) != nombreMinuscula.charAt(derecha)) {
                return false;
            }
            izquierda++;
            derecha--;
        }
        return true;
    }

    public ArrayList<Paciente> obtenerPalindromos(ArrayList<Paciente> pacientes) {
        ArrayList<Paciente> palindromos = new ArrayList<>();
        for (Paciente p : pacientes) {
            if (nombrePalindromo(p.getNombre())) {
                palindromos.add(p);
            }
        }
        return palindromos;
    }

    public static boolean vocalesRepetidas(String nombre) {
        String nombreMinuscula = nombre.toLowerCase();
        int a=0,e=0,i=0,o=0,u=0;
        for(char c : nombreMinuscula.toCharArray()) {
            switch (c) {
                case 'a':
                    a++;
                    break;
                case 'e':
                    e++;
                    break;
                case 'i':
                    i++;
                    break;
                case 'o':
                    o++;
                    break;
                case 'u':
                    u++;
                    break;
            }
        }
        return (a >= 2 || e >= 2 || i >= 2 || o >= 2 || u >= 2);
    }

    public ArrayList<Paciente> obtenerPacientesVocalesRepetidas(ArrayList<Paciente> pacientes) {
        ArrayList<Paciente> vocalesRepetidas = new ArrayList<>();
        for (Paciente p : pacientes) {
            if (vocalesRepetidas(p.getNombre())) {
                vocalesRepetidas.add(p);
            }
        }
        return vocalesRepetidas;
    }


    public ArrayList<Paciente> getListaPacientes() {
        return ListaPacientes;
    }

    public void setListaPacientes(ArrayList<Paciente> listaPacientes) {
        ListaPacientes = listaPacientes;
    }

    public ArrayList<Cita> getListaCitas() {
        return ListaCitas;
    }

    public void setListaCitas(ArrayList<Cita> listaCitas) {
        ListaCitas = listaCitas;
    }

    public ArrayList<Doctor> getListaDoctores() {
        return ListaDoctores;
    }

    public void setListaDoctores(ArrayList<Doctor> listaDoctores) {
        ListaDoctores = listaDoctores;
    }
}
