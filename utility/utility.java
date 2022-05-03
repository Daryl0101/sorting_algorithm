package utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class utility {
    // Import File
    public static LinkedList<String> ImportFile(File file){
        LinkedList<String> data = new LinkedList<>();
        try{
            Scanner fileReader = new Scanner(file);
            while (fileReader.hasNextLine())
                data.add(fileReader.nextLine());
            fileReader.close();
        }catch (FileNotFoundException e){
            System.out.println("Error happened when importing file.");
            e.printStackTrace();
        }
        return data;
    }

    // Utility function for swapping
    public static void swap(LinkedList<String> data, int i, int j){
        String tmp = data.get(i);
        data.set(i, data.get(j));
        data.set(j, tmp);
    }
}
