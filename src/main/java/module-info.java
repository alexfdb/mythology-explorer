module com.mythologi.explorer {
    requires javafx.fxml;
    requires javafx.controls;
    requires transitive java.sql;
    requires org.controlsfx.controls;
    requires transitive javafx.graphics;

    exports com.mythologi.explorer;
    exports com.mythologi.explorer.model;
    exports com.mythologi.explorer.controller;

    opens com.mythologi.explorer to javafx.fxml;
    opens com.mythologi.explorer.model to javafx.fxml;
    opens com.mythologi.explorer.controller to javafx.fxml;
}