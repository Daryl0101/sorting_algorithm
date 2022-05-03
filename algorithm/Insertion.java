package algorithm;

import java.util.LinkedList;

public class Insertion {
    // Insertion Sort Algorithm
    public static void InsertionSort(LinkedList<String> data){
        String tmp;
        int outer, inner;

        for(outer=1; outer<data.size(); outer++){
            tmp = data.get(outer);
            for(inner=outer; inner>0; inner--){
                if(tmp.compareTo(data.get(inner-1))<0)
                    data.set(inner, data.get(inner-1));
                else
                    break;
            }
            data.set(inner, tmp);
        }
    }
}
