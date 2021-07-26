package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.commons.io.FilenameUtils;

import java.io.*;
import java.util.Formatter;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileManager {

    private File file;

    FileManager(File file){
        this.file = file;
    }

    public void writeFile(InventoryTrackerModel model){
        String extension = FilenameUtils.getExtension(file.getAbsolutePath());
        if(extension.equals("html")){
            writeHtml(model.displayedItems);
        }
        if(extension.equals("txt")){
            writeTSV(model.displayedItems);
        }
        if(extension.equals("json")){
            writeJSON(model.displayedItems);
        }
    }

    public void writeHtml(ObservableList<Item> items){

        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write("<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "<head>\n" +
                    "<style>\n" +
                    "table {\n" +
                    "  font-family: arial, sans-serif;\n" +
                    "  border-collapse: collapse;\n" +
                    "  width: 100%;\n" +
                    "}\n" +
                    "\n" +
                    "td, th {\n" +
                    "  border: 1px solid #dddddd;\n" +
                    "  text-align: left;\n" +
                    "  padding: 8px;\n" +
                    "}\n" +
                    "\n" +
                    "tr:nth-child(even) {\n" +
                    "  background-color: #dddddd;\n" +
                    "}\n" +
                    "</style>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "\n" +
                    "<h2>HTML Table</h2>\n" +
                    "\n" +
                    "<table>\n" +
                    "  <tr>\n" +
                    "    <th>Serial Number</th>\n" +
                    "    <th>Name</th>\n" +
                    "    <th>Value</th>\n" +
                    "  </tr>\n");
            for(Item item : items){

                bw.write(String.format("<tr>\n" +
                        "    <td>%s</td>\n" +
                        "    <td>%s</td>\n" +
                        "    <td>%s</td>\n" +
                        "  </tr>", item.getSerialNumber(), item.getName(), item.getValue()));
            }
            bw.write("</table>\n" +
                    "\n" +
                    "</body>\n" +
                    "</html>");
            bw.close();
        }catch(Exception e){
            System.out.printf("Error is %s", e.getMessage());
        }

    }
    public void writeTSV(ObservableList<Item> items){
        Formatter formatter = null;
        try{
             formatter = new Formatter(file.getAbsolutePath());
        }catch(Exception e){
            System.out.printf("Error is %s", e.getMessage());
        }
        for(Item item : items){
            formatter.format("%s %s %s\n", item.getSerialNumber(), item.getName(), item.getValue());
        }
        formatter.close();

    }
    public void writeJSON(ObservableList<Item> items){

    }

    public void loadFile(InventoryTrackerModel model){
        String extension = FilenameUtils.getExtension(file.getAbsolutePath());
        if(extension.equals("html")){
            loadHtml(model);
        }
        if(extension.equals("txt")){
            loadTSV(model);
        }
        if(extension.equals("json")){
            loadJSON(model);
        }
    }

    public void loadHtml(InventoryTrackerModel model){
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {

            model.items.clear();
            model.displayedItems.clear();
            System.out.println("START_____");
            for(String line; !(line = br.readLine()).equals("    <th>Value</th>"); ) {
                System.out.println(line);
            }
            br.readLine();
            for(String line; !(line = br.readLine()).equals("  </tr></table>"); ) {
                System.out.println(line);
                String serialNumberLine = br.readLine();
                System.out.println(serialNumberLine);
                String nameLine = br.readLine();
                System.out.println(nameLine);
                String valueLine = br.readLine();
                System.out.println(valueLine);
                addItem(model, serialNumberLine, nameLine, valueLine);
            }
        }catch(Exception e){
            System.out.printf("Error is %s", e.getMessage());
        }

    }
    public void addItem(InventoryTrackerModel model, String serialNumberLine, String nameLine, String valueLine){

        String serialNumber = serialNumberLine.substring(8, serialNumberLine.length()-5);
        String name = nameLine.substring(8, nameLine.length()-5);
        String value = valueLine.substring(8, valueLine.length()-5);
        System.out.println(String.format("%s %s %s", serialNumber, name, value));

        model.addItem(name, serialNumber, value);

    }
    public void loadTSV(InventoryTrackerModel model){
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {

            model.items.clear();
            model.displayedItems.clear();
            for(String line; (line = br.readLine()) != null; ) {
                Scanner scanner = new Scanner(line);
                model.addItem(scanner.next(), scanner.next(), scanner.next());
            }
        }catch(Exception e){
            System.out.printf("Error is %s", e.getMessage());
        }

    }
    public void loadJSON(InventoryTrackerModel model){

    }

}
