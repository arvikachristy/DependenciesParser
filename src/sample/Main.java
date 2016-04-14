package sample;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main{

    static HashMap<String, String[]> sourceData = new LinkedHashMap<>(); // the input txt stored
    static ArrayList<String> keysMe = new ArrayList<>(); //key in order as specified

    // parsing the txt Head file
    public void storeHead(String input){
            //handling empty line
            String[] empty = new String[1];
            empty[0]= " ";
            String[] res = input.split("\\s+->\\s+");
            if(res.length>1){
                sourceData.put(res[0],storeTails(res[1]));}
            else{
                sourceData.put(res[0],empty);
            }
            keysMe.add(res[0]);
    }

    //parsing the txt tail
    public String[] storeTails(String input){
        String[] res = input.split("\\s+");
        return res;
    }

    //append result as string
    public String appendResult(String input){
        StringBuilder builder = new StringBuilder();
        builder.append(input + " -> ");
        if(sourceData.containsKey(input)) {
            TreeSet<String> resultMe = resultSet(input, new TreeSet<>());
            for (String p : resultMe) {
                builder.append(p + " ");
            }
        }
        return builder.toString();
    }

    //recursive function to get all of the child members
    //use tree to be alphabetical
    public TreeSet<String> resultSet(String input, TreeSet<String> result){
        String[] value = sourceData.get(input);
        if (value != null){
            for(int u=0;u<value.length;u++){
                result.add(value[u]);
                resultSet(value[u], result);
            }
        }
        //if the key doesnt exist!
        else{
            return null;
        }
        return result;
    }

    //reading the original txt file
    public List<String> fileReader(String inputFilePath) {
        ArrayList<String> lines = new ArrayList<>();

        try {
            return Files.readAllLines(Paths.get(inputFilePath));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return lines;
    }

    public static void main(String[] args) {
        List<String> lines;

        if (args.length < 2) {
            System.out.println("Please provide input file name");
        }
        else {//load the txt file
            Main callit = new Main();
            lines = callit.fileReader(args[0]);

            for (int u = 0; u < lines.size(); u++) {
                callit.storeHead(lines.get(u));
            }

            for (int i = 1; i < args.length; i++) {
                    System.out.println(callit.appendResult(args[i]));
            }
        }

    }
}
