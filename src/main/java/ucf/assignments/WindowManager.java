package ucf.assignments;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WindowManager {
    private Map<String, Scene> scenes = new HashMap<>();

    public void load(){

        InventoryTrackerModel model = new InventoryTrackerModel();

        MainWindowController listViewerController = new MainWindowController(this, model);
        AddItemController addItemController = new AddItemController(model);


        Parent root;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
        loader.setController(listViewerController);

        try{

            root= loader.load();
            scenes.put("MainWindow", new Scene(root));

        } catch (IOException e){
            e.printStackTrace();
        }

        loader = new FXMLLoader((getClass().getResource("AddItem.fxml")));
        loader.setController((addItemController));

        try{
            root = loader.load();
            scenes.put("AddItem", new Scene(root));
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public Scene getScene(String name){

        return scenes.get(name);

    }



}