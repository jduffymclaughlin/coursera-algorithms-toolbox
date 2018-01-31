import java.util.*;
import java.lang.*;
import java.io.*;

public class BinarySearch {



    private static int BinarySearch(int[] arr, int low, int high, int searchNum) {
        if (high < low) {
            return - 1;
        }

        int mid  = (int) Math.floor(low + (high - low) / 2);

        if (arr[mid] == searchNum) {
            return mid;
        } else if (searchNum < arr[mid]) {
            return BinarySearch(arr, low, mid - 1, searchNum);
        } else {
            return BinarySearch(arr, mid + 1, high, searchNum);
        }
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            //replace with the call to binarySearch when implemented
            System.out.print(BinarySearch(a, 0, n - 1, b[i]) + " ");
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


//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        Random rand = new Random();
//        int[] arr = new int[100];
//
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = i * 2;
//        }
//        System.out.println(BinarySearch(arr, 0, arr.length, 78));
//
//    }
}
