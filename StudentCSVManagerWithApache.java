package csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class StudentCSVManagerWithApache {
    private static final String CSV_FILE = "student.csv";
    private static final String[] HEADERS = {"Name", "Gender", "Age", "Address"};

    public static void main(String[] args) {
        readAndPrintCSV();
        addNewStudent();
    }

    public static void readAndPrintCSV(){
        try (Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE))){
            CSVFormat csvFormat = CSVFormat.DEFAULT
                            .withHeader(HEADERS) //Định nghĩa dòng tiêu đề
                            .withSkipHeaderRecord(); //Bỏ qua dòng tiêu đề khi phân tích cú pháp
            Iterable<CSVRecord> records = csvFormat.parse(reader);
            System.out.println("List student: ");
            for(CSVRecord record: records){
                System.out.println("Name: " + record.get("Name") +
                                    ", Gender: " + record.get("Gender") +
                                    ", Age: " + record.get("Age") +
                                    ", Address: " + record.get("Address"));
            }
        }catch (IOException ex){
            System.out.println("File not found: ");
            ex.printStackTrace();
        }
    }

    private static void addNewStudent(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nName:");
        String name = scanner.nextLine();

        scanner = new Scanner(System.in);
        System.out.println("Gender: ");
        String gender = scanner.nextLine();

        scanner = new Scanner(System.in);
        System.out.println("Age: ");
        int age = scanner.nextInt();

        scanner = new Scanner(System.in);
        System.out.println("Address");
        String address = scanner.nextLine();

        try(BufferedWriter writer = Files.newBufferedWriter(Paths.get(CSV_FILE),
                StandardCharsets.UTF_8,
                StandardOpenOption.APPEND);
            CSVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT)){

            printer.printRecord(name, gender, age, address);
            printer.flush();
            System.out.println("Update new student!!");
        }catch (IOException e){
            System.out.println("Error");
        }
    }
}
