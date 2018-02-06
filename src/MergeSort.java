import java.util.*;

public class MergeSort {

    private static ArrayList<Integer> mergeSort(ArrayList<Integer> arr) {


        return arr;
    }


    public static void main(String[] args) {
        Random rand = new Random();
        ArrayList<Integer> alist = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            alist.add(rand.nextInt(100));
        }
        System.out.println(alist);

        System.out.println(mergeSort(alist));

    }
}
