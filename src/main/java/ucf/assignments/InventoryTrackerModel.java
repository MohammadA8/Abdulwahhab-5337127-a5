package ucf.assignments;

import javafx.collections.*;

import java.util.*;

public class InventoryTrackerModel {

    Set<Item> items;
    ObservableList<Item> displayedItems;

    public InventoryTrackerModel(){
        items = new HashSet<>();
        displayedItems = FXCollections.observableArrayList();
    }

    public Item findName(String name){

        // have an iterator and iterate through the list
        // when you find an item that matches return it
        // else return null

        ListIterator<Item> iterator = displayedItems.listIterator();
        while(iterator.hasNext()){

            Item item = iterator.next();
            if(item.getNameProperty().get().equals(name)){
                return item;
            }

        }
        return null;

    }
    public Item findSerialNumber(String serialNumber){

        // have an iterator and iterate through the list
        // when you find an item that matches return it
        // else return null

        ListIterator<Item> iterator = displayedItems.listIterator();
        while(iterator.hasNext()){

            Item item = iterator.next();
            if(item.getSerialNumberProperty().get().equals(serialNumber)){
                return item;
            }

        }
        return null;


    }
    public void addItem(String name, String serialNumber, double value){

        // make a new item with the given parameters
        // add it to the list

        Item item = new Item(name, serialNumber, value);

        if(this.items.add(item)){
            this.displayedItems.add(item);
        }

    }
    public void removeItem(Item item){

        // remove the item

        this.displayedItems.remove(item);
        this.items.remove(item);

    }
    public void editValue(Item item, double value){

        // set the value of the item to be the value given
        item.setValue(value);

    }
    public void editSerialNumber(Item item, String serialNumber){

        // set the serial number of the item to be the serial number given
        item.setSerialNumber(serialNumber);

    }
    public void editName(Item item, String name){

        // set the name of the item to be the name given
        item.setName(name);

    }
    public void sortName(){

        // make a comparator of items and have an anonymous class that compares the names
        // call the sort function on list using that comparator
        // use this video https://youtu.be/oAp4GYprVHM?t=523
        Comparator<Item> comparator = new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.getNameProperty().get().compareToIgnoreCase(o2.getNameProperty().get());
            }
        };
        Collections.sort(this.displayedItems, comparator);

    }
    public void sortSerialNumber(){

        // make a comparator of items and have an anonymous class that compares the serial numbers
        // call the sort function on list using that comparator
        Comparator<Item> comparator = new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.getSerialNumberProperty().get().compareTo(o2.getSerialNumberProperty().get());
            }
        };
        Collections.sort(this.displayedItems, comparator);

    }
    public void sortValue(){

        // make a comparator of items and have an anonymous class that compares the values
        // call the sort function on list using that comparator

        Comparator<Item> comparator = new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                if(o1.getValueProperty().get()>o2.getValueProperty().get()){
                    return 1;
                }
                else{
                    return -1;
                }
            }
        };
        Collections.sort(this.displayedItems, comparator);

    }
}
