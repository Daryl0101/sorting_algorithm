package algorithm;

import java.util.LinkedList;

public class Bubble {
    // Bubble Sort Algorithm
    public static void BubbleSort(LinkedList<String> data){
        int outer, inner;

        for(outer=data.size()-1; outer>0; outer--){
            for(inner=0; inner<outer; inner++){
                if(data.get(inner).compareTo(data.get(inner+1))>0)
                    utility.utility.swap(data, inner, outer);
            }
        }
    }
}
