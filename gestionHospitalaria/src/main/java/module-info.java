module co.edu.uniquindio.poo.gestionhospitalaria {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens co.edu.uniquindio.poo.gestionhospitalaria to javafx.fxml;
    exports co.edu.uniquindio.poo.gestionhospitalaria;
    exports co.edu.uniquindio.poo.gestionhospitalaria.model;
    exports co.edu.uniquindio.poo.gestionhospitalaria.viewController;
    opens co.edu.uniquindio.poo.gestionhospitalaria.model to javafx.fxml;
    opens co.edu.uniquindio.poo.gestionhospitalaria.viewController to javafx.fxml;
}