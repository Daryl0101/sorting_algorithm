package algorithm;

import java.util.Arrays;
import java.util.LinkedList;

public class Radix {
    // Radix Sort Algorithm
    public static void RadixSort(LinkedList<String> data){
        int maxIndex = 0;
        for(int i=0;i<data.size();i++){
            if(data.get(i).length()-1 > maxIndex){
                maxIndex = data.get(i).length()-1;
            }
        }

        for(int i=maxIndex;i>=0;i--){
            countingSort(data,i,'a','z');
        }
    }

    // Counting Sort Algorithm
    private static void countingSort(LinkedList<String> data,int index,char lower,char upper){
        int[] countArray = new int[(upper-lower)+2];
        String[] tempArray = new String[data.size()];
        Arrays.fill(countArray,0);

        //increase count for char at index
        for(int i=0;i<data.size();i++){
            int charIndex = (data.get(i).length()-1 < index) ? 0 : ((data.get(i).charAt(index) - lower)+1);
            countArray[charIndex]++;
        }

        //sum up countArray;countArray will hold last index for the char at each strings index
        for(int i=1;i<countArray.length;i++){
            countArray[i] += countArray[i-1];
        }

        for(int i=data.size()-1;i>=0;i--){
            int charIndex = (data.get(i).length()-1 < index) ? 0 : (data.get(i).charAt(index) - lower)+1;
            tempArray[countArray[charIndex]-1] = data.get(i);
            countArray[charIndex]--;
        }

        for(int i=0;i<tempArray.length;i++){
            data.set(i,tempArray[i]);
        }
    }
}
