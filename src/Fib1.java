import java.util.Scanner;

public class Fib1 {
    private static long calc_fib(int n) {
        int[] fibTable = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            if (i == 0) {
                fibTable[i] = 0;
            } else if (i == 1) {
                fibTable[i] = 1;
            } else {
                fibTable[i] = fibTable[i - 1] + fibTable[i - 2];
            }
        }


        return fibTable[n];
    }

    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(calc_fib(n));
    }
}
