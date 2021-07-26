package ucf.assignments;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.commons.io.FilenameUtils;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

public class MainWindowController {

    InventoryTrackerModel model;
    WindowManager windowManager;

    MainWindowController(WindowManager windowManager, InventoryTrackerModel model){

        this.model = model;
        this.windowManager = windowManager;
    }
    public void initialize(){

        // set items of table view to the displayed items
        // Make the table view edit friendly for all aspects of the Item
        // Make sure that the user inputs the new changes in proper format
        // If the user enters wrong serial number make a pop up
        // If the user tries to sort the list using the tableview sort it according
        // to the desired sorting
        // Give the user the ability to search using keyboard input in the list

        serialNumberColumn.setCellValueFactory(
                new PropertyValueFactory<Item, SimpleStringProperty>("serialNumber"));
        nameColumn.setCellValueFactory(
                new PropertyValueFactory<Item, SimpleStringProperty>("name"));
        valueColumn.setCellValueFactory(
                new PropertyValueFactory<Item, SimpleStringProperty>("value"));

        tableView.setItems(model.displayedItems);


    }

    @FXML
    private MenuItem saveAsButton;

    @FXML
    private MenuItem loadButton;

    @FXML
    private MenuItem quitButton;

    @FXML
    private TableView<Item> tableView;

    @FXML
    private TableColumn<Item, SimpleStringProperty> serialNumberColumn;

    @FXML
    private TableColumn<Item, SimpleStringProperty> nameColumn;

    @FXML
    private TableColumn<Item, SimpleStringProperty> valueColumn;

    @FXML
    private Button removeItemButton;

    @FXML
    private Button addItemButton;

    @FXML
    void addItemButtonClicked(ActionEvent event) {

        // Make a new stage and set scene to that of AddItem in WindowManager

        Stage stage = new Stage();
        stage.setTitle("Add inventory item");
        stage.setScene(windowManager.getScene("AddItem"));
        stage.show();


    }

    @FXML
    void loadButtonClicked(ActionEvent event) {

        // Open up a file chooser that gives you the option
        // to choose the file to load
        // delegate the tasks to the FileManager
        Stage currentStage = (Stage) addItemButton.getScene().getWindow();


        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        File file = fileChooser.showOpenDialog(currentStage);
        FileManager fileManager = new FileManager(file);
        fileManager.loadFile(model);

    }

    @FXML
    void quitButtonClicked(ActionEvent event) {

        // Quite the program
        Stage stage = (Stage) addItemButton.getScene().getWindow();
        stage.close();


    }

    @FXML
    void removeItemButtonClicked(ActionEvent event) {

        // Delete the item that's highlighted in the tableView
        Item item = tableView.getSelectionModel().getSelectedItem();
        model.removeItem(item);

    }

    @FXML
    void saveFileButtonClicked(ActionEvent event) {

        // Open up a file chooser that gives you the options
        // to save the file as HTML, TSV, and JSON
        // delegate the tasks to the FileManager
        Stage currentStage = (Stage)addItemButton.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("TSV", "*.txt"),
                new FileChooser.ExtensionFilter("HTML", "*.html"),
                new FileChooser.ExtensionFilter("JSON", "*.json")
        );

        try {

            File file = fileChooser.showSaveDialog(currentStage);
            FileManager fileManager = new FileManager(file);
            fileManager.writeFile(model);
            fileChooser.setInitialDirectory(file.getParentFile());


        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }


    }

}
