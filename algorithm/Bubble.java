package algorithm;

import static utility.utility.swap;

public class Bubble {
    // Counter to count primitive operations of Bubble Sort
    private static long bubbleCounter = 0L;
    // Bubble Sort Algorithm
    public static long BubbleSort(String[] word){
        int outer, inner;
        /*
        * Method calling of word.length
        * Subtraction of word.length-1
        * Assignment of outer=word.length-1
        * */
        bubbleCounter += 3;

        for(outer=word.length-1; outer>0; outer--){
            /*
            * Comparison of outer>0
            * Subtraction & Assignment of outer--
            * Assignment of inner=0
            * */
            bubbleCounter += 4;

            for(inner=0; inner<outer; inner++){
                /*
                * Comparison of inner<outer
                * Addition & Assignment of inner++
                * Referencing of word[inner]
                * Method calling of word[inner].compareTo()
                * Referencing & Addition of word[inner+1]
                * Comparison of word[inner].compareTo(word[inner+1])>0
                * */
                bubbleCounter += 8;

                if(word[inner].compareTo(word[inner+1])>0){
                    swap(word, inner, inner+1);
                    /*
                    * Addition of inner+1
                    * Method calling of swap()
                    * Assignment & Referencing of tmp=data[i]
                    * Referencing*2 & Assignment of data[i]=data[j]
                    * Referencing & Assignment of data[j]=tmp
                    * */
                    bubbleCounter += 9;
                }
            }
        }
        return bubbleCounter;
    }
}
