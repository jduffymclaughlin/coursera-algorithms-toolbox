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

            quickSort(less).addAll(same);
            less.addAll(quickSort(more));
            return less;
        }
    }


    private static int getMajorityElement(ArrayList<Integer> a, int left, int right) {
        if (left == right) {
            return -1;
        }
        if (left + 1 == right) {
            return a.get(left);
        }

        for (int i = 0; i < a.size(); i++) {
            int count = 0;

            for (int j = 0; j < a.size(); j++) {
                if (a.get(i) == a.get(j)) {
                    count++;
                }
            }
            
            if (count > a.size() / 2) {
                return 1;
            }
        }

        return -1;
    }



    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> a = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            a.add(scanner.nextInt());
        }
        a = quickSort(a);
        //System.out.println(a);

        if (getMajorityElement(a, 0, a.size()) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
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

