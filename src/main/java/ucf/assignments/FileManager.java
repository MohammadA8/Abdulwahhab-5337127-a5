package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.commons.io.FilenameUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Formatter;

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
            formatter.format("%s %s %s", item.getSerialNumber(), item.getName(), item.getValue());
        }
        formatter.close();

    }
    public void writeJSON(ObservableList<Item> items){

    }

}
