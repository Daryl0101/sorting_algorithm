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
        data = ImportFile(file);

        // Insertion Sort
        LinkedList<String> insertion_sorted = new LinkedList<>(data);
        InsertionSort(insertion_sorted);

        // Bubble Sort
        LinkedList<String> bubble_sorted = new LinkedList<>(data);
        BubbleSort(bubble_sorted);

        // Quick Sort
        LinkedList<String> quick_sorted = new LinkedList<>(data);
        QuickSort(quick_sorted,0,quick_sorted.size()-1);

        // Radix Sort
        LinkedList<String> radix_sorted = new LinkedList<>(data);
        RadixSort(radix_sorted);
    }

    // Import File
    private static LinkedList<String> ImportFile(File file){
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

    // Insertion Sort Algorithm
    public static void InsertionSort(LinkedList<String> data){
        String tmp;
        int outer, inner;

        for(outer=1; outer<data.size(); outer++){
            tmp = data.get(outer);
            for(inner=outer; inner>0; inner--){
                if(tmp.compareTo(data.get(inner-1))<0)
                    data.set(inner, data.get(inner-1));
                else
                    break;
            }
            data.set(inner, tmp);
        }
    }

    // Bubble Sort Algorithm
    public static void BubbleSort(LinkedList<String> data){
        int outer, inner;

        for(outer=data.size()-1; outer>0; outer--){
            for(inner=0; inner<outer; inner++){
                if(data.get(inner).compareTo(data.get(inner+1))>0)
                    swap(data, inner, outer);
            }
        }
    }

    // Quick Sort Algorithm
    public static void QuickSort(LinkedList<String> data, int left, int right){
        int pivot;
        if(left>right)
            return;
        else{
            pivot = Partition(data,left,right);
            QuickSort(data,left,pivot-1);
            QuickSort(data,pivot+1,right);
        }
    }

    // Partition Algorithm
    private static int Partition(LinkedList<String> data, int left, int right){
        String pivot_data = data.get(left);
        int i = left;
        for(int j=left+1;j<=right;j++){
            if(data.get(j).compareTo(pivot_data)<0){
                i = i + 1;
                swap(data,i,j);
            }
        }
        swap(data,i,left);
        return i;
    }

    // Utility function for swapping
    private static void swap(LinkedList<String> data, int i, int j){
        String tmp = data.get(i);
        data.set(i, data.get(j));
        data.set(j, tmp);
    }

    // Radix Sort Algorithm
    public static void RadixSort(LinkedList<String> data){
        int maxIndex = 0;
        for(int i=0;i<data.size();i++){
            if(data.get(i).length()-1 > maxIndex){
                maxIndex = data.get(i).length()-1;
            }
        }

        for(int i=maxIndex;i>=0;i--){
            countingSort(data,i,'a','z');
        }
    }

    // Counting Sort Algorithm
    private static void countingSort(LinkedList<String> data,int index,char lower,char upper){
        int[] countArray = new int[(upper-lower)+2];
        String[] tempArray = new String[data.size()];
        Arrays.fill(countArray,0);

        //increase count for char at index
        for(int i=0;i<data.size();i++){
            int charIndex = (data.get(i).length()-1 < index) ? 0 : ((data.get(i).charAt(index) - lower)+1);
            countArray[charIndex]++;
        }

        //sum up countArray;countArray will hold last index for the char at each strings index
        for(int i=1;i<countArray.length;i++){
            countArray[i] += countArray[i-1];
        }

        for(int i=data.size()-1;i>=0;i--){
            int charIndex = (data.get(i).length()-1 < index) ? 0 : (data.get(i).charAt(index) - lower)+1;
            tempArray[countArray[charIndex]-1] = data.get(i);
            countArray[charIndex]--;
        }

        for(int i=0;i<tempArray.length;i++){
            data.set(i,tempArray[i]);
        }
    }
}
