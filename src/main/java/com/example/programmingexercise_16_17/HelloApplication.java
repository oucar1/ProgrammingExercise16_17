package com.example.programmingexercise_16_17;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Exercise 16.17 (USE SCROLLBAR AND SLIDER)
 * Write a program that uses scrollbars or sliders to select the color for a text, as shown in Figure 16.43b.
 * Four horizontal scrollbars are used for selecting the colors: red, green, blue, and opacity percentages.
 */
public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a label for the title
        Label textLabel = new Label("Show Colors");
        textLabel.setStyle("-fx-font-size: 30px; -fx-font-weight: bold;");
        textLabel.setTextFill(Color.BLACK);

        // Create scrollbars for color and opacity
        ScrollBar redScrollBar = createColorScrollBar();
        ScrollBar greenScrollBar = createColorScrollBar();
        ScrollBar blueScrollBar = createColorScrollBar();
        ScrollBar opacityScrollBar = createOpacityScrollBar();

        // Listener that changes the text color when scrollbar values are changed
        ChangeListener<Number> colorChangeListener = (observable, oldValue, newValue) -> {
            // Create a color using the values from the scrollbars
            Color color = Color.rgb(
                    (int) redScrollBar.getValue(),
                    (int) greenScrollBar.getValue(),
                    (int) blueScrollBar.getValue(),
                    opacityScrollBar.getValue());
            // Apply the color to the text
            textLabel.setTextFill(color);
        };

        // Attach the listener to each scrollbar
        redScrollBar.valueProperty().addListener(colorChangeListener);
        greenScrollBar.valueProperty().addListener(colorChangeListener);
        blueScrollBar.valueProperty().addListener(colorChangeListener);
        opacityScrollBar.valueProperty().addListener(colorChangeListener);

        // Create a layout (GridPane) to organize the scrollbars and label
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        // Center the title label and stretch it across two columns
        GridPane.setColumnSpan(textLabel, 2);
        textLabel.setAlignment(Pos.CENTER);
        gridPane.add(textLabel, 0, 0);

        // Add labels and scrollbars to the GridPane
        gridPane.add(new Label("Red"), 0, 1);
        gridPane.add(redScrollBar, 1, 1);

        gridPane.add(new Label("Green"), 0, 2);
        gridPane.add(greenScrollBar, 1, 2);

        gridPane.add(new Label("Blue"), 0, 3);
        gridPane.add(blueScrollBar, 1, 3);

        gridPane.add(new Label("Opacity"), 0, 4);
        gridPane.add(opacityScrollBar, 1, 4);

        // Set up the scene and show the stage
        Scene scene = new Scene(gridPane, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise16_17 - Show Colors");
        primaryStage.show();
    }

    // Helper method to create scrollbars for colors
    private ScrollBar createColorScrollBar() {
        ScrollBar scrollBar = new ScrollBar();
        scrollBar.setMin(0);
        scrollBar.setMax(255);
        scrollBar.setValue(128);
        scrollBar.setUnitIncrement(10);
        scrollBar.setBlockIncrement(50);
        return scrollBar;
    }

    // Helper method to create a scrollbar for opacity (transparency)
    private ScrollBar createOpacityScrollBar() {
        ScrollBar scrollBar = new ScrollBar();
        scrollBar.setMin(0);
        scrollBar.setMax(1);
        scrollBar.setValue(1);
        scrollBar.setUnitIncrement(0.1);
        scrollBar.setBlockIncrement(0.1);
        return scrollBar;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
