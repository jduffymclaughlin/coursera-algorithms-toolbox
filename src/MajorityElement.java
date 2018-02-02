import java.util.*;
import java.io.*;

public class MajorityElement {

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

    private static int majorityElement(ArrayList<Integer> arr) {
        int valBest = arr.get(0);
        int countBest = 1;
        int val = valBest;
        int count = countBest;

        arr = quickSort(arr);


        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) == val) {
                count++;
            } else {
                val = arr.get(i);
                count = 1;
            }
            if (count > countBest) {
                countBest = count;
                valBest = val;
            }
        }

        //System.out.println(valBest + "  " + countBest + " " + count);
        if (countBest > arr.size() / 2) {
            return 1;
        } else {
            return 0;
        }
    }


    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> a = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            a.add(scanner.nextInt());
        }

        System.out.println(majorityElement(a));

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

