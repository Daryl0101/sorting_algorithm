package algorithm;

public class Insertion {
    // Insertion Sort Algorithm
    public static void InsertionSort(String[] word){
        String tmp;
        int outer, inner;

        for(outer=1; outer<word.length; outer++){
            tmp = word[outer];
            for(inner=outer; inner>0; inner--){
                if(tmp.compareTo(word[inner-1])>=0)
                    break;
                word[inner] = word[inner-1];
            }
            word[inner] = tmp;
        }
    }
}
