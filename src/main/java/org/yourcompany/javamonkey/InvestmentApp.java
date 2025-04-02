package org.yourcompany.javamonkey;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.*;


public class InvestmentApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Personalized Investment Portfolio");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        // UI Components
        Label maritalStatusLabel = new Label("Marital Status:");
        ComboBox<String> maritalStatusComboBox = new ComboBox<>();
        maritalStatusComboBox.getItems().addAll("Single", "Married", "Divorced", "Widowed");
        GridPane.setConstraints(maritalStatusLabel, 0, 0);
        GridPane.setConstraints(maritalStatusComboBox, 1, 0);

        Label dependentsLabel = new Label("Number of Dependents:");
        TextField dependentsTextField = new TextField();
        GridPane.setConstraints(dependentsLabel, 0, 1);
        GridPane.setConstraints(dependentsTextField, 1, 1);

        Label retirementAgeLabel = new Label("Retirement Age:");
        TextField retirementAgeTextField = new TextField();
        GridPane.setConstraints(retirementAgeLabel, 0, 2);
        GridPane.setConstraints(retirementAgeTextField, 1, 2);

        Label riskToleranceLabel = new Label("Risk Tolerance (1-10):");
        Slider riskToleranceSlider = new Slider(1, 10, 5);
        riskToleranceSlider.setShowTickLabels(true);
        riskToleranceSlider.setShowTickMarks(true);
        GridPane.setConstraints(riskToleranceLabel, 0, 3);
        GridPane.setConstraints(riskToleranceSlider, 1, 3);

        Label debtLabel = new Label("Has Debt:");
        CheckBox debtCheckBox = new CheckBox();
        GridPane.setConstraints(debtLabel, 0, 4);
        GridPane.setConstraints(debtCheckBox, 1, 4);

        Label preferredSectorsLabel = new Label("Preferred Sectors:");
        ComboBox<String> preferredSectorsComboBox = new ComboBox<>();
        preferredSectorsComboBox.getItems().addAll("Tech", "Healthcare", "Consumer Discretionary", "Utilities", "Materials");
        GridPane.setConstraints(preferredSectorsLabel, 0, 5);
        GridPane.setConstraints(preferredSectorsComboBox, 1, 5);

        Button generatePortfolioButton = new Button("Generate Portfolio");
        GridPane.setConstraints(generatePortfolioButton, 1, 6);

        // Event Handling
        generatePortfolioButton.setOnAction(e -> {
            String maritalStatus = maritalStatusComboBox.getValue();
            int dependents = Integer.parseInt(dependentsTextField.getText());
            int retirementAge = Integer.parseInt(retirementAgeTextField.getText());
            int riskTolerance = (int) riskToleranceSlider.getValue();
            boolean hasDebt = debtCheckBox.isSelected();
            List<String> preferredSectors = Collections.singletonList(preferredSectorsComboBox.getValue());

            UserProfile userProfile = new UserProfile(maritalStatus, dependents, retirementAge, riskTolerance, hasDebt, preferredSectors);
            Portfolio portfolio = PortfolioGenerator.generatePortfolio(userProfile);
            PortfolioDisplay.displayPortfolio(portfolio);
        });

        grid.getChildren().addAll(maritalStatusLabel, maritalStatusComboBox, dependentsLabel, dependentsTextField,
                retirementAgeLabel, retirementAgeTextField, riskToleranceLabel, riskToleranceSlider, debtLabel, debtCheckBox,
                preferredSectorsLabel, preferredSectorsComboBox, generatePortfolioButton);

        Scene scene = new Scene(grid, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
