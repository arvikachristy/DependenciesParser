package sample;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main{

    //ordered alphabetically,
    static HashMap<String, String[]> sourceData = new LinkedHashMap<>(); // the input
    static ArrayList<String> keysMe = new ArrayList<>(); //key in order as specified

    public void storeHead(String input){
        String[] empty = new String[1];
        empty[0]=null;
        String[] res = input.split(" -> "); //now store [gui,<space>awtui swingui]
        if(res.length>1){
        sourceData.put(res[0],storeTails(res[1]));}
        else{
            sourceData.put(res[0],empty);
        }
        keysMe.add(res[0]); //adding key in order as specified
    }

    public String[] storeTails(String input){
        String[] res = input.split(" ");
        return res;
    }


    public String appendResult(String input){ //append everything as string
        StringBuilder builder = new StringBuilder();
        builder.append(input + " -> ");
        builder.append(resultSet(input, new HashSet<>()));
        return builder.toString();
    }

    //recursive function to get all of the child members
    public HashSet<String> resultSet(String input, HashSet<String> result){
        String[] value = sourceData.get(input);
        if (value != null){
            for(int u=0;u<value.length;u++){
                result.add(value[u]);
                resultSet(value[u], result);
            }
        }
        else{
            return null; //if the key doesnt exist!
        }
        //System.out.println(result);
        return result;
    }

    //reading the txt file
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

        String argstest[] = new String[2];
        argstest[0] ="swingui";
        argstest[1] ="awtui";

        if (args.length < 1) {
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
