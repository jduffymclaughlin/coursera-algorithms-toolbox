import java.util.Scanner;
import java.util.*;

public class PlacingParentheses {
    private static long[] MinAndMax(int i, int j, long[][] m, long[][] M, char[] ops) {
        long[] MinAndMax = {Long.MAX_VALUE, Long.MIN_VALUE};

        for (int k = i; k < j; k++) {

            long a = eval(M[i][k], M[k+1][j], ops[k]);
            long b = eval(M[i][k], m[k+1][j], ops[k]);
            long c = eval(m[i][k], M[k+1][j], ops[k]);
            long d = eval(m[i][k], m[k+1][j], ops[k]);

            MinAndMax[0] = Collections.min(Arrays.asList(MinAndMax[0], a, b, c, d));
            MinAndMax[1] = Collections.max(Arrays.asList(MinAndMax[1], a, b, c, d));
        }
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
        }


        for (int s = 1; s < n ; s++) {
            for (int i = 0; i < n - s; i++) {

                j = i + s;
                minMax = MinAndMax(i, j, min, max, ops);

                min[i][j] = minMax[0];
                max[i][j] = minMax[1];
            }
        }

//        for (int i = 0; i< n; i++) {
//            System.out.println(Arrays.toString(min[i]));
//        }

        return max[0][n-1];
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

