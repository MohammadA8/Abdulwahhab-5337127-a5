package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddItemController {

    InventoryTrackerModel model;
    WindowManager windowManager;

    AddItemController(WindowManager windowManager, InventoryTrackerModel model){

        this.model = model;
        this.windowManager = windowManager;
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
        // Make sure that the formatting of each String is right
        // clear the text boxes
        // get the current stage and close it

        if(serialNumberText.getText().matches("^[a-zA-Z_0-9]{10}$")){
            if(itemValueText.getText().matches("^(\\d{1,3}(\\,\\d{3})*|(\\d+))(\\.\\d{2})?$")){
                if(itemNameText.getText().matches("[a-zA-Z_0-9]{2,256}+")){
                    if(this.model.addItem(itemNameText.getText(), serialNumberText.getText(), itemValueText.getText())){
                        model.setItemDuplicate(false);
                        Stage currentStage = (Stage)addButton.getScene().getWindow();
                        serialNumberText.clear();
                        itemValueText.clear();
                        itemNameText.clear();
                        currentStage.close();
                    }else{
                        showErrorWindow();
                    }

                }
                else {
                    showErrorWindow();
                }

            }else{
                showErrorWindow();
            }

        }else{

            showErrorWindow();

        }



    }

    public void showErrorWindow(){
        Stage stage = new Stage();
        stage.setTitle("Error");
        stage.setScene(windowManager.getScene("ErrorWindow"));
        stage.show();
    }

}
