import java.io.IOException;
import java.util.LinkedList;

import static utility.utility.*;
import static algorithm.Insertion.*;
import static algorithm.Bubble.*;
import static algorithm.Quick.*;
import static algorithm.Radix.*;

public class Sorting {
    public static void main(String[] args) throws IOException{
        // Import data from .txt file
        String[] data;
        data = ImportFile("src/txtFiles/avgList.txt");

        // Insertion Sort
        /*String[] insertion_sorted = data.clone();
        long val1 = InsertionSort(insertion_sorted);*/

        // Bubble Sort
        /*String[] bubble_sorted = data.clone();
        long val2 = BubbleSort(bubble_sorted);*/


        // Quick Sort
        /*String[] quick_sorted = data.clone();
        long val3 = QuickSort(quick_sorted,0,quick_sorted.length-1);*/

        // Radix Sort
        /*String[] radix_sorted = data.clone();
        long val4 = RadixSort(radix_sorted,'\'','™');*/

        LinkedList<String> y = new LinkedList<>();
        for(int i=0;i<data.length;i+=2000){
            i = data.length-1-i<2000 ? data.length-1 : i;
            String[] sliced = SliceArray(data,0,i);
            //long var = InsertionSort(sliced);
            //long var = BubbleSort(sliced);
            //long var = QuickSort(sliced,0,sliced.length-1);
            long var = RadixSort(sliced,'\'','™');
            y.add(Long.toString(var));
            System.out.println(i+1);
        }
        ExportFile("C:\\Users\\60134\\Downloads\\sorted_y.txt", y.toArray(new String[y.size()]));
    }
}
