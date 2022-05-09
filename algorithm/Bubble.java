package algorithm;

import static utility.utility.swap;

public class Bubble {
    // Bubble Sort Algorithm
    public static void BubbleSort(String[] word){
        int outer, inner;

        for(outer=word.length-1; outer>0; outer--){
            for(inner=0; inner<outer; inner++){
                if(word[inner].compareTo(word[inner+1])>0)
                    swap(word, inner, inner+1);
            }
        }
    }
}
