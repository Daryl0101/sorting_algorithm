package algorithm;

import java.util.Arrays;

public class Radix {
    // Radix Sort Algorithm
    public static void RadixSort(String[] word, char lower, char upper){
        // Find the maximum index of the longest word
        int maxIndex = 0;
        for(int i=0;i<word.length;i++){
            if(word[i].length()-1 > maxIndex){
                maxIndex = word[i].length()-1;
            }
        }

        // LSD Sort
        for(int i=maxIndex;i>=0;i--){
            countingSort(word,i,lower,upper);
        }
    }

    // Counting Sort Algorithm
    private static void countingSort(String[] word,int index,char lower,char upper){
        // The 1 extra index denotes a null char
        int[] countArray = new int[(upper-lower)+2];
        String[] tempArray = new String[word.length];
        Arrays.fill(countArray,0);

        // Count the number of char at specific index
        for(int i=0;i<word.length;i++){
            int charIndex = (word[i].length()-1 < index) ? 0 : (word[i].charAt(index) - lower)+1;
            countArray[charIndex]++;
        }

        //sum up countArray;countArray will hold last index for the char at each strings' index
        for(int i=1;i<countArray.length;i++){
            countArray[i] += countArray[i-1];
        }

        for(int i=word.length-1;i>=0;i--){
            int charIndex = (word[i].length()-1 < index) ? 0 : (word[i].charAt(index) - lower)+1;
            tempArray[countArray[charIndex]-1] = word[i];
            countArray[charIndex]--;
        }

        for(int i=0;i<tempArray.length;i++){
            word[i] = tempArray[i];
        }
    }
}
