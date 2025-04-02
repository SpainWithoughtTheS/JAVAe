package org.yourcompany.javamonkey;

import java.util.Collections;
import java.util.List;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class InvestmentApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Personalized Investment Portfolio");

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.setStyle("-fx-background-color: #F4F4F4; -fx-border-radius: 10; -fx-background-radius: 10;");

        // UI Components
        Label title = new Label("Investment Portfolio Setup");
        title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        ComboBox<String> maritalStatusComboBox = new ComboBox<>();
        maritalStatusComboBox.getItems().addAll("Single", "Married", "Divorced", "Widowed");
        maritalStatusComboBox.setPromptText("Select Marital Status");

        TextField dependentsTextField = new TextField();
        dependentsTextField.setPromptText("Number of Dependents");

        TextField retirementAgeTextField = new TextField();
        retirementAgeTextField.setPromptText("Retirement Age");

        Label riskToleranceLabel = new Label("Risk Tolerance:");
        Slider riskToleranceSlider = new Slider(1, 10, 5);
        riskToleranceSlider.setShowTickLabels(true);
        riskToleranceSlider.setShowTickMarks(true);
        riskToleranceSlider.setMajorTickUnit(1);
        riskToleranceSlider.setMinorTickCount(0);

        CheckBox debtCheckBox = new CheckBox("Has Debt?");

        ComboBox<String> preferredSectorsComboBox = new ComboBox<>();
        preferredSectorsComboBox.getItems().addAll("Tech", "Healthcare", "Consumer Discretionary", "Utilities", "Materials");
        preferredSectorsComboBox.setPromptText("Preferred Sector");

        Button generatePortfolioButton = new Button("Generate Portfolio");
        generatePortfolioButton.setStyle("-fx-background-color: #0078D7; -fx-text-fill: white; -fx-font-size: 14px;");

        // Button Hover Effect
        generatePortfolioButton.setOnMouseEntered(e -> generatePortfolioButton.setStyle("-fx-background-color: #005A9E; -fx-text-fill: white;"));
        generatePortfolioButton.setOnMouseExited(e -> generatePortfolioButton.setStyle("-fx-background-color: #0078D7; -fx-text-fill: white;"));

        // Fade-in Animation
        FadeTransition fadeIn = new FadeTransition(Duration.millis(800), layout);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);
        fadeIn.play();

        // Event Handling
        generatePortfolioButton.setOnAction(e -> {
            try {
                String maritalStatus = maritalStatusComboBox.getValue();
                int dependents = dependentsTextField.getText().isEmpty() ? 0 : Integer.parseInt(dependentsTextField.getText());
                int retirementAge = retirementAgeTextField.getText().isEmpty() ? 65 : Integer.parseInt(retirementAgeTextField.getText());
                int riskTolerance = (int) riskToleranceSlider.getValue();
                boolean hasDebt = debtCheckBox.isSelected();
                List<String> preferredSectors = preferredSectorsComboBox.getValue() == null ? Collections.emptyList() : List.of(preferredSectorsComboBox.getValue());

                UserProfile userProfile = new UserProfile(maritalStatus, dependents, retirementAge, riskTolerance, hasDebt, preferredSectors);
                Portfolio portfolio = PortfolioGenerator.generatePortfolio(userProfile);
                PortfolioDisplay.displayPortfolio(portfolio);

            } catch (NumberFormatException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Please enter valid numbers for dependents and retirement age.", ButtonType.OK);
                alert.showAndWait();
            }
        });

        layout.getChildren().addAll(title, maritalStatusComboBox, dependentsTextField, retirementAgeTextField,
                riskToleranceLabel, riskToleranceSlider, debtCheckBox, preferredSectorsComboBox, generatePortfolioButton);

        Scene scene = new Scene(layout, 400, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
