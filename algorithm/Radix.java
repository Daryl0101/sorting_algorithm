package algorithm;

import java.util.Arrays;

public class Radix {
    // Counter to count primitive operations of Radix Sort
    private static long radixCounter = 0L;

    // Radix Sort Algorithm
    public static long RadixSort(String[] word, char lower, char upper){
        // Find the maximum index of the longest word
        int maxIndex = 0;

        /*
        * Assignment of maxIndex=0
        * Assignment of i=0
        * Referencing & Comparison of i<word.length
        * */
        radixCounter += 4;

        for(int i=0;i<word.length;i++){

            /*
            * Referencing & Method calling & Subtraction & Comparison of word[i].length()-1>maxIndex
            * */
            radixCounter += 4;

            if(word[i].length()-1 > maxIndex){
                maxIndex = word[i].length()-1;

                /*
                * Assignment & Referencing & Method calling & Subtraction of maxIndex=word[i].length()-1
                * */
                radixCounter += 4;

            }

            /*
            * Addition & Assignment of i++
            * Referencing & Comparison of i<word.length
            * */
            radixCounter += 4;
        }

        /*
        * Assignment of i=maxIndex
        * Comparison of i>=0
        * */
        radixCounter += 2;

        // LSD Sort
        for(int i=maxIndex;i>=0;i--){
            bucketSort(word,i,lower,upper);

            /*
            * Method calling of countingSort(word,i,lower,upper)
            * Subtraction & Assignment of i--
            * Comparison of i>=0
            * */
            radixCounter += 4;
        }
        return radixCounter;
    }

    // Bucket Sort Algorithm
    private static void bucketSort(String[] word,int index,char lower,char upper){
        // The 1 extra index denotes a null char
        int[] countArray = new int[(upper-lower)+2];
        String[] tempArray = new String[word.length];
        Arrays.fill(countArray,0);

        /*
        * Subtraction & Addition of (upper-lower)+2
        * Referencing of word.length
        * Method calling of Arrays.fill(countArray,0)
        * Assignment of i=0
        * Comparison & Referencing of i<word.length
        * */
        radixCounter += 7;

        // Count the number of char at specific index
        for(int i=0;i<word.length;i++){
            int charIndex = (word[i].length()-1 < index) ? 0 : (word[i].charAt(index) - lower)+1;
            countArray[charIndex]++;

            /*
            * Referencing*2 & Subtraction & Comparison of word[i].length()-1<index
            * Assignment of charIndex=0 //IF// word[i].length()-1<index
            * Assignment & Referencing*2 & Subtraction & Addition of charIndex=(word[i].charAt(index)-lower)+1 //ELSE//
            * Assignment & Referencing & Addition of countArray[charIndex]++
            * Addition & Assignment of i++
            * Comparison & Referencing of i<word.length
            * */
            radixCounter += 11;
            radixCounter += (word[i].length()-1 < index) ? 1 : 5;
        }

        /*
        * Assignment of i=1
        * Comparison & Referencing of i<countArray.length
        * */
        radixCounter += 3;

        //sum up countArray;countArray will hold last index for the char at each strings' index
        for(int i=1;i<countArray.length;i++){
            countArray[i] += countArray[i-1];

            /*
            * Referencing*2 & Assignment & Subtraction & Addition of countArray[i]+=countArray[i-1]
            * Addition & Assignment of i++
            * Comparison & Referencing of i<countArray.length
            * */
            radixCounter += 9;
        }

        /*
        * Assignment & Referencing & Subtraction of i=word.length-1
        * Comparison of i>=0
        * */
        radixCounter += 4;

        for(int i=word.length-1;i>=0;i--){
            int charIndex = (word[i].length()-1 < index) ? 0 : (word[i].charAt(index) - lower)+1;
            tempArray[countArray[charIndex]-1] = word[i];
            countArray[charIndex]--;

            /*
            * Referencing*2 & Subtraction & Comparison of word[i].length()-1<index
            * Assignment of charIndex=0 //IF// word[i].length()-1<index
            * Assignment & Referencing*2 & Subtraction & Addition of charIndex=(word[i].charAt(index)-lower)+1 //ELSE//
            * Referencing*3 & Subtraction & Assignment of tempArray[countArray[charIndex]-1]=word[i]
            * Assignment & Referencing & Subtraction of countArray[charIndex]--
            * Subtraction & Assignment of i--
            * Comparison of i>=0
            * */
            radixCounter += 15;
            radixCounter += (word[i].length()-1 < index) ? 1 : 5;
        }

        /*
        * Assignment of i=0
        * Comparison & Referencing of i<tempArray.length
        * */
        radixCounter += 3;

        for(int i=0;i<tempArray.length;i++){
            word[i] = tempArray[i];

            /*
            * Referencing*2 & Assignment of word[i]=tempArray[i]
            * Addition & Assignment of i++
            * Comparison & Referencing of i<tempArray.length
            * */
            radixCounter += 7;
        }
    }
}
