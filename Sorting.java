import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

import static utility.utility.*;
import static algorithm.Insertion.*;
import static algorithm.Bubble.*;
import static algorithm.Quick.*;
import static algorithm.Radix.*;

public class Sorting {
    public static void main(String[] args) throws IOException{

        Scanner myObj = new Scanner(System.in);
        // Prompt user to input the algorithm
        System.out.println("Which sorting algorithm do you like to use?");
        System.out.println("A: Insertion Sort");
        System.out.println("B: Bubble Sort");
        System.out.println("C: Quick Sort");
        System.out.println("D: Radix Sort");
        System.out.print("Choice: ");
        char algo = myObj.next().charAt(0);

        // Input validation
        while(algo != 'a' && algo != 'A' && algo != 'b' && algo != 'B' && algo != 'c' && algo != 'C' && algo != 'd' && algo != 'D') {
            System.out.println("\nInvalid selection! Try again ...");
            System.out.println("Which sorting algorithm do you like to use?");
            System.out.println("A: Insertion Sort");
            System.out.println("B: Bubble Sort");
            System.out.println("C: Quick Sort");
            System.out.println("D: Radix Sort");
            System.out.print("Choice: ");
            algo = myObj.next().charAt(0);
        }

        // Prompt user to input the case
        System.out.println("\nWhich case do you like to sort?");
        System.out.println("A: Best Case");
        System.out.println("B: Average Case");
        System.out.println("C: Worst Case");
        System.out.print("Choice: ");
        char cs = myObj.next().charAt(0);

        // Input validation
        while(cs != 'a' && cs != 'A' && cs != 'b' && cs != 'B' && cs != 'c' && cs != 'C') {
            System.out.println("\nInvalid selection! Try again ...");
            System.out.println("Which case do you like to sort?");
            System.out.println("A: Best Case");
            System.out.println("B: Average Case");
            System.out.println("C: Worst Case");
            System.out.print("Choice: ");
            cs = myObj.next().charAt(0);
        }

        // Ask if user wants to get the graph data
        System.out.println("\nDo you want to get the graph data?");
        System.out.print("Y/N: ");
        char gdt = myObj.next().charAt(0);

        // Input validation
        while(gdt != 'y' && gdt != 'Y' && gdt != 'n' && gdt != 'N') {
            System.out.println("\nInvalid selection! Try again ...");
            System.out.println("Do you want to get the graph data?");
            System.out.print("Y/N: ");
            gdt = myObj.next().charAt(0);
        }

        String[] data;
        String path = "";

        // Choose txt file according to case
        switch (cs) {
            case 'a':
            case 'A':
                path = "src/txtFiles/bestList.txt";
                break;
            case 'b':
            case 'B':
                path = "src/txtFiles/avgList.txt";
                break;
            case 'c':
            case 'C':
                path = "src/txtFiles/worstList.txt";
                break;
        }
        // Import data from .txt file
        data = ImportFile(path);
        if(path=="src/txtFiles/avgList.txt"){
            // Shuffle array if average case is chosen
            data = ShuffleList(data);
        }

        // Sort whole word list only without generating graph data
        long val = 0L;
        if(gdt=='n' || gdt=='N'){
            switch (algo){
                case ('a'):
                case ('A'):
                    // Insertion Sort
                    val = InsertionSort(data);
                    break;
                case ('b'):
                case ('B'):
                    // Bubble Sort
                    val = BubbleSort(data);
                    break;
                case ('c'):
                case ('C'):
                    // Quick Sort
                    val = QuickSort(data,0,data.length-1);
                    break;
                case ('d'):
                case ('D'):
                    // Radix Sort
                    val = RadixSort(data,'\'','™');
                    break;
            }
            System.out.println("Sorted list:");
            PrintArray(data);
            System.out.println();
            System.out.println("Total Number of Primitive Operations: " + val);
            ExportFile("sorting_algorithm/sortedFiles/sorted.txt", data);
            System.out.println("Graph data exported to txt file at: sorting_algorithm/sortedFiles/sorted.txt");
        }
        else if(gdt=='y' || gdt=='Y'){
            LinkedList<String> y = new LinkedList<>();
            System.out.println("Sorting . . .");
            for(int i=0;i<data.length;i+=2000){
                i = data.length-1-i<2000 ? data.length-1 : i;
                String[] sliced = SliceArray(data,0,i);
                val = 0L;
                switch (algo){
                    case ('a'):
                    case ('A'):
                        // Insertion Sort
                        val = InsertionSort(sliced);
                        break;
                    case ('b'):
                    case ('B'):
                        // Bubble Sort
                        val = BubbleSort(sliced);
                        break;
                    case ('c'):
                    case ('C'):
                        // Quick Sort
                        val = QuickSort(sliced,0,sliced.length-1);
                        break;
                    case ('d'):
                    case ('D'):
                        // Radix Sort
                        val = RadixSort(sliced,'\'','™');
                        break;
                }
                y.add(Long.toString(val));
                System.out.println(i+1);
            }
            ExportFile("sorting_algorithm/sortedFiles/y_data.txt", y.toArray(new String[y.size()]));
            System.out.println("Graph data exported to txt file at: sorting_algorithm/sortedFiles/y_data.txt");
        }

    }
}
