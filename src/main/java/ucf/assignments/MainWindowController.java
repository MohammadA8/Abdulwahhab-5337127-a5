package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class MainWindowController {

    InventoryTrackerModel model;
    WindowManager windowManager;

    MainWindowController(WindowManager windowManager, InventoryTrackerModel model){

        this.model = model;
        this.windowManager = windowManager;
    }

    @FXML
    private MenuItem saveAsButton;

    @FXML
    private MenuItem loadButton;

    @FXML
    private MenuItem quitButton;

    @FXML
    private TableView<?> tableView;

    @FXML
    private TableColumn<?, ?> serialNumberColumn;

    @FXML
    private TableColumn<?, ?> nameColumn;

    @FXML
    private TableColumn<?, ?> valueColumn;

    @FXML
    private Button removeItemButton;

    @FXML
    private Button addItemButton;

    @FXML
    void addItemButtonClicked(ActionEvent event) {

    }

    @FXML
    void loadButtonClicked(ActionEvent event) {

    }

    @FXML
    void quitButtonClicked(ActionEvent event) {

    }

    @FXML
    void removeItemButtonClicked(ActionEvent event) {

    }

    @FXML
    void saveFileButtonClicked(ActionEvent event) {

    }

}
