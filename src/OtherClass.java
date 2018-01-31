import java.util.*;
import java.lang.*;

public class OtherClass {

    private static int linearSearch(ArrayList<Integer> list, int low, int high, int num) {

        if (high < low) {
            return -1;

        } else if (list.get(low) == num) {
            return list.get(low);

        } else {
            return linearSearch(list, low + 1, high, num);
        }

    }

    private static int[] polyNaive(int[] a, int[] b) {
        int[] c = new int[2 * a.length - 1];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                c[i + j] = c[i + j] + a[i] * b[j];
            }
        }

        return c;
    }

    private static int[] polyLessNaive(int[] a, int[] b) {
        int[] c = new int[2 * a.length - 1];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                c[i + j] += a[i] * b[j];
            }
        }

        return c;
    }


    public static void main(String[] args) {

        ArrayList<Integer> intList = new ArrayList<Integer>();
        for (int j = 0; j < 1000; j++) {
            intList.add(j);
        }
        int numToFind = 99;
        //System.out.println(linearSearch(intList, 0, intList.size(), numToFind));

        Scanner scanner = new Scanner(System.in);
        int len = 5;
        int[] a  = new int[len];
        int[] b = new int[len];

        for (int i = 0; i < len; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i < len; i++) {
            b[i] = scanner.nextInt();
        }

        System.out.println(polyNaive(a, b));

        System.out.println(polyLessNaive(a, b));



    }
}
