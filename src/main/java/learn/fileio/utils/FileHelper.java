package learn.fileio.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHelper {

    // create
    public static void createFile(String filename){
        File file = new File("src/data/" + filename);
        try{
            if (file.createNewFile()){
                System.out.println(filename + " created.");
            } else {
                System.out.println(filename + " already exists.");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static List<String> readFile(String fileName) {
        List<String> fileContents = new ArrayList<String>();

        try (FileReader fileReader = new FileReader("src/data/" + fileName);
             BufferedReader reader = new BufferedReader(fileReader)) {

            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                if (!line.isBlank()) {
                    fileContents.add(line);
                }
            }

        } catch (IOException ex) {
            // this is okay... we'll create the file
        }

        return fileContents;
    }

    // update
    public static void appendToFile(String filename, String line){
        try (FileWriter fileWriter = new FileWriter("src/data/" + filename, true);
             PrintWriter writer = new PrintWriter(fileWriter)) {
            writer.println(line);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void copyFile(String source, String destination){
        createFile(destination);
        List<String> contents = readFile(source);
        for (String line : contents){
            appendToFile(destination, line);
        }
    }

    // delete
    public static void deleteFile(String filename){
        File file = new File("src/data/" + filename);
        boolean success = file.delete();
        if (success) {
            System.out.println("file deleted");
        } else {
            System.out.println("file NOT deleted");
        }
    }
}
