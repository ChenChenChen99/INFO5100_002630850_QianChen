package com.example.exercise9;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorController {
    @FXML
    private TextField result;

    private int num1 = 0;
    private int num2 = 0;
    private String operator = "";

    @FXML
    public String getButtonValue(ActionEvent event){
        Button button = (Button) event.getSource();
        return button.getText();
    }

    @FXML
    public void pressNumber(ActionEvent event){
        String number = getButtonValue(event);
        result.setText(result.getText() + number);
    }

    @FXML
    public void pressOperator(ActionEvent event){
        num1 = Integer.parseInt(result.getText());
        operator = getButtonValue(event);
        result.setText("");
    }

    @FXML
    public void calculate(){
        num2 = Integer.parseInt(result.getText());
        int answer = 0;
        switch (operator){
            case "+":
                answer = num1 + num2;
                break;
            case "-":
                answer = num1 - num2;
                break;
            case "*":
                answer = num1 * num2;
                break;
            case "/":
                if (num2 == 0){
                    result.setText("Error");
                    return;
                }
                answer = num1 / num2;
                break;
        }
        result.setText(String.valueOf(answer));
    }

    @FXML
    public void clear(){
        num1 = 0;
        num2 = 0;
        operator = "";
        result.setText("");
    }

}
