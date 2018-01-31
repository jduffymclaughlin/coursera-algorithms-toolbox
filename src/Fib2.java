import java.util.Scanner;
import java.util.Arrays;

public class Fib2 {
    private static long calc_fib(int n) {
        long[] fibTable = new long[n + 1];
        fibTable[0] = 0;
        fibTable[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            fibTable[i] = (fibTable[i - 1] % 10) + (fibTable[i - 2] % 10);
        }

        return (fibTable[n] % 10);
    }

    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(calc_fib(n));
    }
}
