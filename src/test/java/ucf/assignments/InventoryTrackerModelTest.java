package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryTrackerModelTest {

    @Test
    void addItem() {

        InventoryTrackerModel model = new InventoryTrackerModel();
        InventoryTrackerModel model2 = new InventoryTrackerModel();

        model.addItem("name", "0123456789", "4");
        Item item = new Item("name", "0123456789", "4");
        model2.displayedItems.add(item);

        assertEquals(model.displayedItems, model2.displayedItems);


    }

    @Test
    void removeItem() {

        InventoryTrackerModel model = new InventoryTrackerModel();
        InventoryTrackerModel model2 = new InventoryTrackerModel();

        Item item = new Item("name", "0123456789", "4");
        model.displayedItems.add(item);
        model.removeItem(item);

        Item item1 = new Item("name", "0123456789", "4");
        model2.displayedItems.add(item1);
        model2.displayedItems.remove(item1);

        assertEquals(model.displayedItems, model2.displayedItems);

    }

    @Test
    void editValue() {
        InventoryTrackerModel model = new InventoryTrackerModel();
        InventoryTrackerModel model2 = new InventoryTrackerModel();

        Item item = new Item("name", "0123456789", "4");
        model.displayedItems.add(item);
        model.editValue(item, "5");

        ObservableList<Item> displayedItems = FXCollections.observableArrayList();
        Item item2 = new Item("name", "0123456789", "6");
        displayedItems.add(item2);


        assertEquals(model.displayedItems, displayedItems);
    }

    @Test
    void editSerialNumber() {
        InventoryTrackerModel model = new InventoryTrackerModel();
        InventoryTrackerModel model2 = new InventoryTrackerModel();

        Item item = new Item("name", "0123456789", "4");
        model.displayedItems.add(item);
        model.editSerialNumber(item, "01234567ab");

        ObservableList<Item> displayedItems = FXCollections.observableArrayList();
        Item item2 = new Item("name", "01234567ab", "4");
        displayedItems.add(item2);


        assertEquals(model.displayedItems, displayedItems);
    }

    @Test
    void editName() {
        InventoryTrackerModel model = new InventoryTrackerModel();
        InventoryTrackerModel model2 = new InventoryTrackerModel();

        Item item = new Item("name", "0123456789", "4");
        model.displayedItems.add(item);
        model.editName(item, "nickname");

        ObservableList<Item> displayedItems = FXCollections.observableArrayList();
        Item item2 = new Item("nickname", "0123456789", "4");
        displayedItems.add(item2);


        assertEquals(model.displayedItems, displayedItems);
    }
}