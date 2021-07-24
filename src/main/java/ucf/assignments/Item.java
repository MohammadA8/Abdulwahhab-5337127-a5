package ucf.assignments;

import javafx.beans.property.*;

public class Item {

    private SimpleStringProperty name;
    private SimpleStringProperty serialNumber;
    private SimpleDoubleProperty value;

    Item(String name, String serialNumber, double value){

        this.name.set(name);
        this.serialNumber.set(serialNumber);
        this.value.set(value);

    }

    public boolean equals(Item item){

        if(this == item){
            return true;
        }

        if(this.serialNumber.get().equals(item.serialNumber.get())){
            return true;
        }

        return false;
    }

    public SimpleStringProperty getNameProperty() {
        return name;
    }
    public void setName(String name) {
        this.name.set(name);
    }
    public SimpleStringProperty getSerialNumberProperty() {
        return serialNumber;
    }
    public void setSerialNumber(String serialNumber) {
        this.serialNumber.set(serialNumber);
    }
    public SimpleDoubleProperty getValueProperty() {
        return value;
    }
    public void setValue(double value) {
        this.value.set(value);
    }


}
