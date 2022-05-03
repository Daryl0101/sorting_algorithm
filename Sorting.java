import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.LinkedList;

public class Sorting {
    public static void main(String[] args){
        // Import data from .txt file
        File file = new File("C:\\Users\\60134\\OneDrive - Universiti Sains Malaysia\\Classes Y2S2\\CPT212\\Assignment 1\\testList.txt");
        LinkedList<String> data;
        data = utility.utility.ImportFile(file);

        // Insertion Sort
        LinkedList<String> insertion_sorted = new LinkedList<>(data);
        algorithm.Insertion.InsertionSort(insertion_sorted);

        // Bubble Sort
        LinkedList<String> bubble_sorted = new LinkedList<>(data);
        algorithm.Bubble.BubbleSort(bubble_sorted);

        // Quick Sort
        LinkedList<String> quick_sorted = new LinkedList<>(data);
        algorithm.Quick.QuickSort(quick_sorted,0,quick_sorted.size()-1);

        // Radix Sort
        LinkedList<String> radix_sorted = new LinkedList<>(data);
        algorithm.Radix.RadixSort(radix_sorted);
    }












}
