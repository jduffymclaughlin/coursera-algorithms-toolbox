import java.util.*;
import java.lang.*;

public class SelectionSort {

    private static int findMin(ArrayList<Integer> arr) {
        int minVal = arr.get(0);
        int minIdx = 0;

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) < minVal) {
                minVal = arr.get(i);
                minIdx = i;
            }
        }
        return minIdx;
    }

    private static ArrayList<Integer> selectionSort(ArrayList<Integer> arr) {
        ArrayList<Integer> sorted = new ArrayList<>();
        int len = arr.size();

        for (int i = 0; i < len; i++) {
            int min = findMin(arr);
            sorted.add(arr.get(min));
            arr.remove(min);
        }
        return sorted;
    }



    public static void main(String[] args) {
        Random rand = new Random();
        ArrayList alist = new ArrayList<Integer>();

        for (int i = 0; i < 10; i++) {
            alist.add(rand.nextInt(100));
        }
        System.out.println(alist);

        System.out.println(selectionSort(alist));
    }

}
