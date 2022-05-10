import java.io.IOException;

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
        String[] radix_sorted = data.clone();
        long val4 = RadixSort(radix_sorted,'\'','™');

        System.out.println(val4);
        ExportFile("C:\\Users\\60134\\Downloads\\radix_sorted.txt", radix_sorted);
    }
}
