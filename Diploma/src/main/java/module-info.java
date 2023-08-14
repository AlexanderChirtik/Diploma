module com.example.diploma {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires poi.ooxml;
    requires java.sql;

    opens com.example.diploma to javafx.fxml;
    exports com.example.diploma;
    exports com.example.diploma.Database;
    opens com.example.diploma.Database to javafx.fxml;
    exports com.example.diploma.Interfaces;
    opens com.example.diploma.Interfaces to javafx.fxml;

}