package learn.fileio;

import learn.fileio.utils.FileHelper;

import java.util.ArrayList;
import java.util.List;

public class LabApp {
    public static void main(String[] args) {

        List<String> fileContents = FileHelper.readFile("README.txt");
        List<String> commands = new ArrayList<String>();

        for (String line : fileContents) {
            if(!line.startsWith("#")){
                commands.add(line);
            }
        }

        for (String command : commands){
            String[] words = command.split(" ", 3);
            if (command.startsWith("CREATE")){
                // CREATE FILE
                FileHelper.createFile(words[1]);
            } else if (command.startsWith("APPEND")){
                // append a line to a file
                FileHelper.appendToFile(words[1], words[2]);
            } else if (command.startsWith("COPY")){
                // copy file contents from source file to destination file
                FileHelper.copyFile(words[1], words[2]);
            } else if (command.startsWith("DELETE")){
                // delete file with filename
                FileHelper.deleteFile(words[1]);
            }
            System.out.println(command);
        }
        System.out.println("\nPrinting elements.data...");
        List<String> elements = FileHelper.readFile("elements.data");
        for (String line : elements) {
            System.out.println(line);
        }
        System.out.println("\nPrinting destination/new-elements-file.txt...");
        List<String> newElements = FileHelper.readFile("destination/new-elements-file.txt");
        for (String line : newElements) {
            System.out.println(line);
        }
    }
}
