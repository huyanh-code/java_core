package csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class createFileCSV {
    public static void main(String[] args) {
//        create_FileCSV();
        insertDataByFileCSV();
    }

    private static void insertDataByFileCSV() {
        try{
            //Tạo đối tượng lớp CSVPrint.
            Writer writer = Files.newBufferedWriter(Paths.get("student.csv"));
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("Name", "Gender",
                                                                                       "Age", "Address"));

            //Viết bản ghi trong tệp CSV được tạo.
            csvPrinter.printRecord("Jame", "Male", 18, "USA");
            csvPrinter.printRecord("Alex", "Male", 29, "Canada");
            csvPrinter.printRecord("Huyền", "Female", 16, "VN");
            csvPrinter.printRecord("Nanao", "Female", 18, "Japan");
            csvPrinter.printRecord("Adam", "Male", 30, "Brazil");

            //Viết lại bản ghi dưới dạng danh sách
            csvPrinter.printRecord(Arrays.asList("Momo", "Female", 20, "Korea"));
            csvPrinter.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void create_FileCSV() {
        try {
            File file = new File("student.csv");
            if (file.createNewFile()) {
                System.out.println("File create!!");
            } else {
                System.out.println("File already exists");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
