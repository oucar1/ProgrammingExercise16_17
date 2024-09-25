module com.example.programmingexercise_16_17 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.programmingexercise_16_17 to javafx.fxml;
    exports com.example.programmingexercise_16_17;
}