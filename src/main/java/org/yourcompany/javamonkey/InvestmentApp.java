package org.yourcompany.javamonkey;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
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
            String maritalStatus = maritalStatusComboBox.getValue();
            int dependents = Integer.parseInt(dependentsTextField.getText());
            int retirementAge = Integer.parseInt(retirementAgeTextField.getText());
            int riskTolerance = (int) riskToleranceSlider.getValue();
            boolean hasDebt = debtCheckBox.isSelected();
            String preferredSector = preferredSectorsComboBox.getValue();

            UserProfile userProfile = new UserProfile(maritalStatus, dependents, retirementAge, riskTolerance, hasDebt, preferredSector);
            Portfolio portfolio = PortfolioGenerator.generatePortfolio(userProfile);
            PortfolioDisplay.displayPortfolio(portfolio);
        });

        layout.getChildren().addAll(title, maritalStatusComboBox, dependentsTextField, retirementAgeTextField,
                riskToleranceSlider, debtCheckBox, preferredSectorsComboBox, generatePortfolioButton);

        Scene scene = new Scene(layout, 400, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
