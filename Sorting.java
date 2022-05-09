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
        data = ImportFile("C:\\Users\\60134\\OneDrive - Universiti Sains Malaysia\\Classes Y2S2\\CPT212\\Assignment 1\\wordList.txt");

        // Insertion Sort
        /*String[] insertion_sorted = data.clone();
        InsertionSort(insertion_sorted);

        // Bubble Sort
        String[] bubble_sorted = data.clone();
        BubbleSort(bubble_sorted);


        // Quick Sort
        String[] quick_sorted = data.clone();
        QuickSort(quick_sorted,0,quick_sorted.length-1);*/


        // Radix Sort
        String[] radix_sorted = data.clone();
        RadixSort(radix_sorted,'\'','™');
        PrintArray(radix_sorted);
        ExportFile("C:\\Users\\60134\\Downloads\\radix_sorted.txt", radix_sorted);
    }
}
