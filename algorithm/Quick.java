package algorithm;

import java.util.Random;

import static utility.utility.swap;

public class Quick {
    // Counter to count primitive operations of Quick Sort
    private static long quickCounter = 0L;
    // Quick Sort Algorithm
    public static long QuickSort(String[] word, int left, int right){
        int pivot;

        /*
        * Comparison of left<right
        * */
        quickCounter++;

        if(left<right){
            pivot = Partition(word,left,right);
            QuickSort(word,left,pivot-1);
            QuickSort(word,pivot+1,right);

            /*
            * Method calling & Assignment of pivot=Partition(word,left,right)
            * Method calling & Subtraction of QuickSort(word,left,pivot-1)
            * Method calling & Addition of QuickSort(word,pivot+1,right);
            * */
            quickCounter += 6;
        }
        return quickCounter;
    }

    // Partition Algorithm
    private static int Partition(String[] word, int left, int right){
        RandomPivot(word,left,right);
        String pivot_word = word[right];
        int i = left-1;

        /*
        * Method calling of RandomPivot(word,left,right)
        * Assignment & Referencing of pivot_word=word[right]
        * Subtraction & Assignment of i=left-1
        * Assignment of j=left
        * Comparison of j<right
        * */
        quickCounter += 7;

        for(int j=left;j<right;j++){

            /*
            * Referencing & Method calling & Comparison of word[j].compareTo(pivot_word)<0
            * */
            quickCounter += 3;

            if(word[j].compareTo(pivot_word)<0){
                i++;
                swap(word,i,j);

                /*
                * Addition & Assignment of i++
                * Method calling of swap()
                * Assignment & Referencing of tmp=data[i]
                * Referencing*2 & Assignment of data[i]=data[j]
                * Referencing & Assignment of data[j]=tmp
                * */
                quickCounter += 10;
            }

            /*
            * Addition & Assignment of j++
            * Comparison of j<right
            * */
            quickCounter += 3;
        }

        /*
        * Addition of i+1
        * Method calling of swap()
        * Assignment & Referencing of tmp=data[i]
        * Referencing*2 & Assignment of data[i]=data[j]
        * Referencing & Assignment of data[j]=tmp
        * Addition & Return of i+1
        * */
        quickCounter += 11;

        swap(word,i+1,right);
        return i+1;
    }

    // Generate a random pivot
    private static void RandomPivot(String[] word, int left, int right){
        Random rand = new Random();
        int pivot = rand.nextInt(right-left)+left;
        swap(word,pivot,right);

        /*
        * Assignment & Method calling & Subtraction & Addition of pivot=rand.nextInt(right-left)+left
        * Method calling of swap()
        * Assignment & Referencing of tmp=data[i]
        * Referencing*2 & Assignment of data[i]=data[j]
        * Referencing & Assignment of data[j]=tmp
        * */
        quickCounter += 12;
    }
}
