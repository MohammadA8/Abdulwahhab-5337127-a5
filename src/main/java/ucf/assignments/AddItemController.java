package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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

    }

}
