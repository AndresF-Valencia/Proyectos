package co.edu.uniquindio.poo.dtosrecords;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) {
        //Vista vista = new Vista();
        //new Controlador(vista);

        primaryStage.setTitle("Ingreso de Datos");
        //primaryStage.setScene(vista.getScene());
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}