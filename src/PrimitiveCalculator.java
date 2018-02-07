import java.util.*;

public class PrimitiveCalculator {
    private static int optimalSequence(int n) {
        int[] table = new int[n + 1];
        table[0] = 0;
        int i = 1;

        while (i <= n) {
            List<Integer> seq = new ArrayList<Integer>();

            table[i] = table[i - 1] + 1;

            if (i % 2 == 0) {
                int j = i / 2;

                table[i] = Math.min(table[j] + 1, table[i]);
            }

            if (i % 3 == 0) {
                int j = i / 3;
                table[i] = Math.min(table[j] + 1, table[i]);
            }
            i++;
        }

        System.out.println(seq);

        return table[n];

    }

    private static List<Integer> optimal_sequence(int n) {
        List<Integer> sequence = new ArrayList<Integer>();
        while (n >= 1) {
            sequence.add(n);
            if (n % 3 == 0) {
                n /= 3;
            } else if (n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
            }
        }
        Collections.reverse(sequence);
        return sequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }

        System.out.println("----" + optimalSequence(n));
    }
}

