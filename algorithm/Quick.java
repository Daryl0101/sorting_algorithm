package algorithm;

import java.util.Random;

import static utility.utility.swap;

public class Quick {
    // Quick Sort Algorithm
    public static void QuickSort(String[] word, int left, int right){
        int pivot;
        if(left<right){
            pivot = Partition(word,left,right);
            QuickSort(word,left,pivot-1);
            QuickSort(word,pivot+1,right);
        }
    }

    // Partition Algorithm
    private static int Partition(String[] word, int left, int right){
        RandomPivot(word,left,right);
        String pivot_word = word[right];
        int i = left-1;
        for(int j=left;j<right;j++){
            if(word[j].compareTo(pivot_word)<0){
                i++;
                swap(word,i,j);
            }
        }
        swap(word,i+1,right);
        return i+1;
    }

    // Generate a random pivot
    private static void RandomPivot(String[] word, int left, int right){
        Random rand = new Random();
        int pivot = rand.nextInt(right-left)+left;
        swap(word,pivot,right);
    }
}
