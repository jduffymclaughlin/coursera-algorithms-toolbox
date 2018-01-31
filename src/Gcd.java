import java.util.*;
import java.lang.*;

public class Gcd {

    private static int gcd_euclid(int a, int b) {
        if (b == 0) {
            return a;
        }

        int a_prime = a % b;
        return gcd_euclid(b, a_prime);
    }


    private static int gcd_naive(int a, int b) {
        int current_gcd = 1;
        int min_num = Math.min(a, b);

        for (int d = 2; d <= min_num; ++d) {
            if (a % d == 0 && b % d == 0) {
                if (d > current_gcd) {
                    current_gcd = d;
                }
            }
        }

        return current_gcd;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(gcd_euclid(a, b));
    }
}

