package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddItemController {

    InventoryTrackerModel model;

    AddItemController(InventoryTrackerModel model){

        this.model = model;
    }

    @FXML
    private TextField serialNumberText;

    @FXML
    private TextField itemNameText;

    @FXML
    private TextField itemValueText;

    @FXML
    private Button addButton;

    @FXML
    void addButtonClicked(ActionEvent event) {

        // add the new item with the given parameters
        // clear the text boxes 
        // get the current stage and close it

        this.model.addItem(itemNameText.getText(), serialNumberText.getText(), Double.parseDouble(itemValueText.getText()));
        Stage currentStage = (Stage)addButton.getScene().getWindow();
        serialNumberText.clear();
        itemValueText.clear();
        itemNameText.clear();
        currentStage.close();

    }

}
