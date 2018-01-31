import java.util.*;
import java.lang.*;

public class greedyNotes {

    static int findMax(ArrayList<Integer> arr) {
        int maxIdx = 0;

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) > arr.get(maxIdx)) {
                maxIdx = i;
            }
        }
        return maxIdx;
    }



    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<Integer>();
        ArrayList<Integer> sortedArr = new ArrayList<Integer>();

        Random rand  = new Random();

        for (int i = 0; i < 10; i++) {
            arr.add(rand.nextInt(100) + 1);
        }

        int size = arr.size();
        int idx;

        for (int j = 0; j < size; j++) {
            idx = findMax(arr);
            sortedArr.add(arr.get(idx));
            arr.remove(idx);
        }

        System.out.println(sortedArr);


    }
}
