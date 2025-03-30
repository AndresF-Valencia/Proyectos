module co.edu.uniquindio.poo.dtosrecords {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.poo.dtosrecords to javafx.fxml;
    exports co.edu.uniquindio.poo.dtosrecords;
    exports co.edu.uniquindio.poo.dtosrecords.controllers;
    opens co.edu.uniquindio.poo.dtosrecords.controllers to javafx.fxml;
}