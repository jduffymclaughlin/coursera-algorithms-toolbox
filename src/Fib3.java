import java.util.*;

public class Fib3 {
    private static long getLargeFibbonacciMod(long n, long m) {
        if (n <= 1) {
            return n;
        }

        long previous = 0;
        long current = 1;

        ArrayList<Long> pisano = new ArrayList<Long>();
        pisano.add(previous);
        pisano.add(current);

        boolean pisanoComplete = false;


        for (long i = 0; i < n - 1; i++) {
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

        if (pisanoComplete) {
            long period = pisano.size() - 1;
            long pisanoIndex = (n % period);
            return pisano.get((int)pisanoIndex);

        } else {
            return pisano.get(pisano.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getLargeFibbonacciMod(n, m));
    }
}

