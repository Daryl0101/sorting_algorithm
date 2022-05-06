package algorithm;

import static utility.utility.swap;

public class Quick {
    // Quick Sort Algorithm
    public static void QuickSort(String[] data, int left, int right){
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
    private static int Partition(String[] data, int left, int right){
        String pivot_data = data[left];
        int i = left;
        for(int j=left+1;j<=right;j++){
            if(data[j].compareTo(pivot_data)<0){
                i = i + 1;
                swap(data,i,j);
            }
        }
        swap(data,i,left);
        return i;
    }
}
