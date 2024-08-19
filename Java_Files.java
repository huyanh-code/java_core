package file;

import java.awt.*;
import java.io.*;
import java.util.Date;

public class Java_Files {
    public static void main(String[] args) {
//        create_File();
//        rename_File();
//        delete_File();
//        overwritter_File();
//        append_Files();
//        checkFiles();
//        create_Folder();
//        RootFilesExample();
//        list_Folder();
//        rename_Folder();
    }

    private static void rename_Folder() {
        File srcFile = new File("D:\\created2\\child2\\child1.txt");
        File destFile = new File("D:\\created3\\child3\\file3.txt");

        if (!srcFile.exists()) {
            System.out.println("Src File doest not exists");
            return;
        }

        // Tạo thư mục cha của file đích
        destFile.getParentFile().mkdirs();

        boolean renamed = srcFile.renameTo(destFile);
        System.out.println("Renamed: " + renamed); // true
    }

    private static void list_Folder() {
        //Liệt kê tất cả thư mục và tập tin con trực thuộc của 1 thư mục.
        System.out.println("File[] listFiles(): ");
        File dir = new File("D:\\created2\\child2");
        File[] children = dir.listFiles();
        for (File file : children) {
            System.out.println(file.getAbsolutePath());
        }

        System.out.println();

        System.out.println("String[] list(): ");
        String[] paths = dir.list();
        for (String path : paths) {
            System.out.println(path);
        }
    }

    private static void RootFilesExample() {
        //Liệt kê các thư mục gốc
        File[] roots = File.listRoots();
        for(File root: roots){
            System.out.println(root.getAbsolutePath());
        }
    }

    private static void create_Folder() {
        File dir = new File("D:/created2/child4");
        System.out.println("Pathname: " + dir.getAbsolutePath());
        System.out.println("Path exists:  " + dir.exists()); // false
        System.out.println("Parent Path exists: " + dir.getParentFile().exists()); // false

        // Với mkdir(), thư mục chỉ được tạo ra nếu thư mục cha tồn tại.
        boolean created = dir.mkdir();
        System.out.println("Directory created: " + created); // false

//        System.out.println("--------------------");
//
//        File dir2 = new File("D:/created2/child2");
//        System.out.println("Pathname: " + dir2.getAbsolutePath());
//        System.out.println("File exists: " + dir2.exists()); // false
//
//        // Với mkdirs(), thư mục được tạo ra bao gồm cả các thư mục cha nếu nó không tồn tại.
//        created = dir2.mkdirs();
//        System.out.println("Directory created: " + created); // true
    }

    private static void checkFiles() {
        //Tạo 1 đối tượng File đại diện cho 1 đuờng dẫn
        File file = new File("D:\\files.txt");
        //Kiểm tra sự tồn tại.
        System.out.println("Path exists : " + file.exists());

        if(file.exists()){
            //Kiểm tra file có phải là 1 folder hay không?
            System.out.println("isDirectory: " + file.isDirectory());

            //Kiểm tra file có phải là 1 đường dẫn ẩn hay không?
            System.out.println("isHidden: " + file.isHidden());

            // Lấy tên file/ folder
            System.out.println("Simple name: " + file.getName());

            //Đường dẫn tuyệt đối.
            System.out.println("Absolute Path: " + file.getAbsolutePath());

            //Kiểm tra kích thước file:
            System.out.println("Length: " + file.length() + " (bytes)");

            //Thời điểm sửa đổi lần cuối
            long lastModifyMillis = file.lastModified(); //milliseconds
            Date lastModifyDate = new Date(lastModifyMillis);
            System.out.println("Last modify date: " + lastModifyDate);
        }
    }

    private static void append_Files() {
        String text = """
                \nThis will write “Java files are easy” to a file called newfile.txt in the same directory as your Main.java file. If the file already exists, it will be overwritten.
                                
                If you want to append data to an existing file, you can pass true as a second argument to FileWriter. This enables append mode, so the file will not be overwritten.
                """;

        try{
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:\\files.txt", true));
            bufferedWriter.write(text);
            bufferedWriter.close();
            System.out.println("Successfully wrote to the files");
        }catch (IOException e){
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }

    private static void overwritter_File() {
        String text = "Computer Science Portal GeeksforGeeks";
        try{
            FileWriter myWriter = new FileWriter("D:\\files.txt");
            myWriter.write(text);
            myWriter.close();
            System.out.println("Successfully wrote to the files");
        }catch (IOException e){
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }

    private static void delete_File() {
        File files = new File("D:\\new-files.txt");
        if(files.delete()){
            System.out.println("Complete!");
        }else {
            System.out.println("File don't exists");
        }
    }

    private static void rename_File() {
        File files = new File("D:\\files.txt");
        if(files.renameTo(new File("D:\\new-files.txt"))){
            System.out.println("File rename");
        }else{
            System.out.println("File don't exists");
        }
    }

    private static void create_File() {
        try {
            File files = new File("D:\\created2\\child4\\welcome.docx");
            if(files.createNewFile()){
                System.out.println("File create!!");
            }else {
                System.out.println("File already exists");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
