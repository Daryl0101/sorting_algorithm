package algorithm;

import static utility.utility.swap;

public class Quick {
    // Quick Sort Algorithm
    public static void QuickSort(String[] word, int left, int right){
        int pivot;
        if(left>right)
            return;
        else{
            pivot = Partition(word,left,right);
            QuickSort(word,left,pivot-1);
            QuickSort(word,pivot+1,right);
        }
    }

    // Partition Algorithm
    private static int Partition(String[] word, int left, int right){
        String pivot_word = word[left];
        int i = left;
        for(int j=left+1;j<=right;j++){
            if(word[j].compareTo(pivot_word)<0){
                i = i + 1;
                swap(word,i,j);
            }
        }
        swap(word,i,left);
        return i;
    }
}
