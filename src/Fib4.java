import java.util.*;

public class Fib4 {
    private static long getFibonacciSumNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current = 1;
        long sum = 1;

        for (long i = 0; i < n + 1; i++) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum = current - 1;
        }

        return sum % 10;
    }


    private static long getLargeFibbonacciMod(long n) {
        if (n <= 1) {
            return n;
        }

        long m = 10;
        long previous = 0;
        long current = 1;

        ArrayList<Long> pisano = new ArrayList<Long>();
        pisano.add(previous);
        pisano.add(current);

        boolean pisanoComplete = false;

        for (long i = 0; i < n + 1; i++) {
            long tmp_previous = previous;
            previous = current;
            current = ((tmp_previous % m) + (current % m)) % m;

            pisano.add(current);
            if (pisano.get(pisano.size() - 2) == 0 && pisano.get(pisano.size() - 1) == 1) {
                pisano.remove(pisano.size() - 1);
                pisanoComplete = true;
                break;
            }
        }
        System.out.println(pisano.size());

        if (pisanoComplete) {
            long period = pisano.size() - 3;
            long pisanoIndex = (n % period);
            return pisano.get((int)(pisanoIndex + 2)) - 1;

        } else {
            return pisano.get(pisano.size() - 1) - 1;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumNaive(n);
        long s2 = getLargeFibbonacciMod(n);
        System.out.println(s + " " + s2);
    }
}

