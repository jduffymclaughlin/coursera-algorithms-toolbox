import java.io.*;
import java.util.*;

public class QuickSort {
    //private static Random rand = new Random();


    private static ArrayList<Integer> quickSort(ArrayList<Integer> arr) {

        if (arr.size() < 2) {
            return arr;

        } else {
            Random rand = new Random();
            int pivot = arr.get(rand.nextInt(arr.size()));

            ArrayList more = new ArrayList<Integer>();
            ArrayList same = new ArrayList<Integer>();
            ArrayList less = new ArrayList<Integer>();

            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i) > pivot) {
                    more.add(arr.get(i));
                } else if (arr.get(i) == pivot) {
                    same.add(arr.get(i));
                } else {
                    less.add(arr.get(i));
                }
            }

            ArrayList<Integer> sorted = new ArrayList<Integer>();
            sorted.addAll(quickSort(less));
            sorted.addAll(same);
            sorted.addAll(quickSort(more));

            return sorted;
        }
    }


    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        //int[] a = new int[n];
        ArrayList<Integer> a = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            a.add(scanner.nextInt());
        }
        //randomizedQuickSort(a, 0, n - 1);
        a = quickSort(a);
        for (int i = 0; i < n; i++) {
            System.out.print(a.get(i) + " ");
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

