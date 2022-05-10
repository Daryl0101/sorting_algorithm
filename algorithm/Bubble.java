package algorithm;

import static utility.utility.swap;

public class Bubble {
    // Counter to count primitive operations of Bubble Sort
    private static long bubbleCounter = 0L;
    // Bubble Sort Algorithm
    public static long BubbleSort(String[] word){
        int outer, inner;
        /*
        * Assignment & Method calling & Subtraction of outer=word.length-1
        * Comparison of outer>0
        * */
        bubbleCounter += 4;

        for(outer=word.length-1; outer>0; outer--){
            /*
            * Assignment of inner=0
            * Comparison of inner<outer
            * */
            bubbleCounter += 2;

            for(inner=0; inner<outer; inner++){
                /*
                * Referencing*2 & Addition & Method calling & Comparison of word[inner].compareTo(word[inner+1])>0
                * */
                bubbleCounter += 5;

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
                /*
                * Addition & Assignment of inner++
                * Comparison of inner<outer
                * */
                bubbleCounter += 3;
            }

            /*
            * Subtraction & Assignment of outer--
            * Comparison of outer>0
            * */
            bubbleCounter += 3;
        }
        return bubbleCounter;
    }
}
