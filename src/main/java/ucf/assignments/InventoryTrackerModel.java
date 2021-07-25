package ucf.assignments;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.*;

import java.util.*;

public class InventoryTrackerModel {

    Set<Item> items;
    ObservableList<Item> displayedItems;
    SimpleBooleanProperty itemDuplicate;
    public InventoryTrackerModel(){
        items = new HashSet<Item>();
        displayedItems = FXCollections.observableArrayList();
        itemDuplicate = new SimpleBooleanProperty();
        itemDuplicate.set(false);
    }

    public Item findName(String name){

        // have an iterator and iterate through the list
        // when you find an item that matches return it
        // else return null

        ListIterator<Item> iterator = displayedItems.listIterator();
        while(iterator.hasNext()){

            Item item = iterator.next();
            if(item.getName().equals(name)){
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
            if(item.getSerialNumber().equals(serialNumber)){
                return item;
            }

        }
        return null;


    }
    public boolean addItem(String name, String serialNumber, String value){

        // make a new item with the given parameters
        // add it to the list

        Item item = new Item(name, serialNumber, value);

        if(this.items.add(item)){
            this.displayedItems.add(item);
            return true;
        }else{
            itemDuplicate.set(true);
            return false;
        }

    }
    public void removeItem(Item item){

        // remove the item

        this.displayedItems.remove(item);
        this.items.remove(item);

    }
    public void editValue(Item item, String value){

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
                return o1.getName().compareToIgnoreCase(o2.getName());
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
                double doubleOne = Double.parseDouble(o1.getValue());
                double doubleTwo = Double.parseDouble(o2.getValue());
                if(doubleOne> doubleTwo){
                    return 1;
                }else{
                    return -1;
                }
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
                return o1.getValue().compareTo(o2.getValue());
            }
        };
        Collections.sort(this.displayedItems, comparator);

    }
    public boolean isItemDuplicate() {
        return itemDuplicate.get();
    }

    public void setItemDuplicate(boolean itemDuplicate) {
        this.itemDuplicate.set(itemDuplicate);;
    }
}
