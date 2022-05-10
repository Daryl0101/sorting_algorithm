package algorithm;

public class Insertion {
    // Counter to count primitive operations of Insertion Sort
    private static long insertionCounter = 0L;
    // Insertion Sort Algorithm
    public static long InsertionSort(String[] word){
        String tmp;
        int outer, inner;
        /*
        * Assignment of outer=1
        * Comparison & Referencing of outer<word.length
        * */
        insertionCounter += 3;

        for(outer=1; outer<word.length; outer++){
            tmp = word[outer];
            /*
             * Assignment & Referencing of tmp=word[outer]
             * Assignment of inner=outer
             * Comparison of inner>0
             * */
            insertionCounter += 4;

            for(inner=outer; inner>0; inner--){
                /*
                * Method calling of tmp.compareTo()
                * Subtraction & Referencing of word[inner-1]
                * Comparison of tmp.compareTo(word[inner-1])>=0
                * */
                insertionCounter += 4;

                if(tmp.compareTo(word[inner-1])>=0){
                    break;
                }
                word[inner] = word[inner-1];
                /*
                 * Referencing*2 & Subtraction & Assignment of word[inner]=word[inner-1]
                 * Subtraction & Assignment of inner--
                 * Comparison of inner>0
                 * */
                insertionCounter += 7;
            }
            word[inner] = tmp;
            /*
            * Referencing & Assignment of word[inner]=tmp
            * Addition & Assignment of outer++
            * Comparison & Referencing of outer<word.length
            * */
            insertionCounter += 6;
        }
        return insertionCounter;
    }
}
