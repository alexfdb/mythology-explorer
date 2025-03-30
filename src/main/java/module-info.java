module com.mythologi_explorer {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires transitive javafx.graphics;

    exports com.mythologi_explorer;

    opens com.mythologi_explorer to javafx.fxml;
}
