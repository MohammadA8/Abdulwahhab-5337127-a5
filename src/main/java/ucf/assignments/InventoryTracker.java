/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Mohammad Abdulwahhab
 */

package ucf.assignments;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class InventoryTracker extends Application {

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){

        WindowManager windowManager = new WindowManager();
        windowManager.load();


        Scene scene = windowManager.getScene("MainWindow");

        primaryStage.setScene(scene);
        primaryStage.setTitle("Inventory Manager");
        primaryStage.show();

    }

}