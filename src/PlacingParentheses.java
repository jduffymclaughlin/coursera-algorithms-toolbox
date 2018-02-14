import java.util.Scanner;
import java.util.*;

public class PlacingParentheses {
    private static long[] MinAndMax(int i, int j) {
        long[] MinAndMax = {Long.MIN_VALUE, Long.MAX_VALUE};

        MinAndMax[0] = 42;
        MinAndMax[1] = 99;
        return MinAndMax;
    }


    private static long getMaximValue(String exp) {

        int numStart = 0;
        int opStart = 0;

        long[] nums = new long[(int) Math.ceil(exp.length() / 2) + 1];
        char[] ops = new char[(int) Math.floor(exp.length() / 2)];

        for (int i = 0; i < exp.length(); i++) {
           char c = exp.charAt(i);
           if (i % 2 == 0) {
               nums[numStart] = (long) Character.getNumericValue(c);
               numStart++;
           } else {
               ops[opStart] = c;
               opStart++;
           }
        }

        int j;
        long[] minMax;
        int n = nums.length;
        long[][] min = new long[n][n];
        long[][] max = new long[n][n];


        for (int i = 0; i < n; i++) {
            min[i][i] = nums[i];
            max[i][i] = nums[i];
            System.out.println(Arrays.toString(max[i]));
        }


        for (int s = 1; s < n - 1; s++) {
            for (int i = 1; i < n - s; i++) {
                j = i + s;

                minMax = MinAndMax(i, j);

                min[i][j] = minMax[0];
                max[i][j] = minMax[1];

            }
            System.out.println(Arrays.toString(min[s]));
        }

        System.out.println(Arrays.toString(min));
        System.out.println(Arrays.toString(max));

        return 100;
    }



    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
    }
}

