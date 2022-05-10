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
        * */
        insertionCounter++;

        for(outer=1; outer<word.length; outer++){
            tmp = word[outer];
            /*
            * Comparison & Referencing of outer<word.length
            * Addition & Assignment of outer++
            * Assignment & Referencing of tmp=word[outer]
            * Assignment of inner=outer
            * */
            insertionCounter += 7;

            for(inner=outer; inner>0; inner--){
                /*
                * Comparison of inner>0
                * Subtraction & Assignment of inner--
                * Method calling of tmp.compareTo()
                * Subtraction & Referencing of word[inner-1]
                * Comparison of tmp.compareTo(word[inner-1])>=0
                * */
                insertionCounter += 7;

                if(tmp.compareTo(word[inner-1])>=0){
                    break;
                }
                word[inner] = word[inner-1];
                /*
                 * Referencing of word[inner]
                 * Subtraction & Referencing of word[inner-1]
                 * */
                insertionCounter += 3;
            }
            word[inner] = tmp;
            /*
            * Referencing & Assignment of word[inner]=tmp
            * */
            insertionCounter += 2;
        }
        return insertionCounter;
    }
}
