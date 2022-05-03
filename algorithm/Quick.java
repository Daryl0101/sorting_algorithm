package algorithm;

import java.util.LinkedList;

public class Quick {
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
                utility.utility.swap(data,i,j);
            }
        }
        utility.utility.swap(data,i,left);
        return i;
    }
}
