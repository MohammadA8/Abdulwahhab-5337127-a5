package ucf.assignments;

import javafx.beans.property.*;

public class Item {

    private final SimpleStringProperty name ;
    private final SimpleStringProperty serialNumber;
    private final SimpleStringProperty value;

    Item(String name, String serialNumber, String value){

        this.name = new SimpleStringProperty(name);
        this.serialNumber = new SimpleStringProperty(serialNumber);
        this.value = new SimpleStringProperty(value);

    }

    public boolean equals(Object o) {
        return (o instanceof Item) && (((Item) o).getSerialNumber()).equals(this.getSerialNumber());
    }
    public int hashCode() {
        return serialNumber.get().hashCode();
    }

    public String getName() {
        return name.get();
    }
    public void setName(String name) {
        this.name.set(name);
    }
    public String getSerialNumber() {
        return serialNumber.get();
    }
    public void setSerialNumber(String serialNumber) {
        this.serialNumber.set(serialNumber);
    }
    public String getValue() {
        return value.get();
    }
    public void setValue(String value) {
        this.value.set(value);
    }
    public String toString(){

        return (String) this.serialNumber.get() + this.name.get() + this.value.get();

    }


}
