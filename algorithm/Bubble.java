package algorithm;

import static utility.utility.*;

public class Bubble {
    // Bubble Sort Algorithm
    public static void BubbleSort(String[] data){
        int outer, inner;

        for(outer=data.length-1; outer>0; outer--){
            for(inner=0; inner<outer; inner++){
                if(data[inner].compareTo(data[inner+1])>0)
                    swap(data, inner, inner+1);
            }
        }
    }
}
