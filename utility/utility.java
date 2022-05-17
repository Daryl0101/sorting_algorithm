package utility;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.io.FileWriter;

public class utility {
    // Utility function for importing file into array
    public static String[] ImportFile(String path) throws IOException{
        File file = new File(path);
        ArrayList<String> data_list = new ArrayList<>();
        Scanner fileReader = new Scanner(file);
        //for(int i=0;i<140000;i++)
        while (fileReader.hasNextLine())
            data_list.add(fileReader.nextLine());
        fileReader.close();
        String[] data = new String[data_list.size()];
        data = data_list.toArray(data);
        return data;
    }

    // Utility function for exporting array into file
    public static void ExportFile(String path, String[] data){
        try {
            File file = new File(path);
            FileWriter fileWriter = new FileWriter(path);
            for(int i=0; i<data.length; i++)
                fileWriter.write(data[i]+'\n');
            fileWriter.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    // Utility function for swapping
    public static void swap(String[] data, int i, int j){
        String tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    // Utility function for printing array
    public static void PrintArray(String[] word){
        for (int i = 0; i < word.length; i++){
            System.out.println(word[i]);
        }
    }

    // Utility function to reverse an array
    public static void InvertArray(String[] word){
        String[] newString = new String[word.length];
        for(int i = 0; i< word.length ; i++){
            newString[i] = word[word.length-i-1];
        }
        for(int i = 0; i< word.length ; i++){
            word[i] = newString[i];
        }
    }

    // Utility function to slice an array
    public static String[] SliceArray(String[] word, int start, int end){
        end = end>word.length-1 ? word.length-1 : end;
        String[] sliced = new String[end-start+1];
        for(int i=0;i<sliced.length;i++){
            sliced[i] = word[start+i];
        }
        return sliced;
    }

    public static String[] ShuffleList(String[] data){
        List<String> tempList = Arrays.asList(data);
        Collections.shuffle(tempList);
        return tempList.toArray(data);
    }
}
