import java.util.*;

public class Lcm {

    private static long lcm_slightly_better(long a, long b) {
        long minNum = Math.min(a, b);

        for (long i = minNum; i <= (long) (a * b); i += minNum) {
            if (i % a == 0 && i % b == 0) {
                return i;
            }
        }
        return (long)(a * b);
    }

    private static long gcd_euclid(long a, long b) {
        if (b == 0) {
            return a;
        }

        long a_prime = a % b;
        return gcd_euclid(b, a_prime);
    }

    private static long lcm_naive(int a, int b) {
        for (long l = 1; l <= (long) a * b; ++l) {
            if (l % a == 0 && l % b == 0) {
                return l;
            }
        }
        return (long) a * b;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        long b = scanner.nextLong();

        long gcd = gcd_euclid(a, b);
        System.out.println((a * b) / gcd);

    }
}
