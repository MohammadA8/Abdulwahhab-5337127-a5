package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class WrongSerialNumberController{

    @FXML
    private Label errorMessage;
    @FXML
    private Button closeButton;

    @FXML
    void closeButtonClosed(ActionEvent event) {

        Stage currentStage = (Stage)closeButton.getScene().getWindow();
        currentStage.close();

    }
    public void initialize(){

        String error = "Please input is in the following format:\n" +
                "Serial number is XXXXXXXXXX where X can be either a letter or digit\n" +
                "Name is  between 2 and 256 characters in length (inclusive)\n" +
                "Value representing its monetary value in US dollars";
        errorMessage.setText(error);

    }

}
