module com.mythologi_explorer {
    requires javafx.fxml;
    requires javafx.controls;
    requires transitive java.sql;
    requires org.controlsfx.controls;
    requires transitive javafx.graphics;

    exports com.mythologi_explorer;
    exports com.mythologi_explorer.model;
    exports com.mythologi_explorer.controller;

    opens com.mythologi_explorer to javafx.fxml;
    opens com.mythologi_explorer.model to javafx.fxml;
    opens com.mythologi_explorer.controller to javafx.fxml;
}