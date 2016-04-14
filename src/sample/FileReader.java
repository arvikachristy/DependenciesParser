package sample;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 14/04/2016.
 */
public class FileReader {

    public List<String> loadInput(String inputFilePath) {
        ArrayList<String> lines = new ArrayList<>();

        try {
            return Files.readAllLines(Paths.get(inputFilePath));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return lines;
    }
}
