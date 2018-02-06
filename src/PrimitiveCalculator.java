import java.util.*;

public class PrimitiveCalculator {
    private static List<Integer> optimalSequence(int n) {
        ArrayList<Integer> table = new ArrayList<Integer>();
        List<Integer> seq = new ArrayList<Integer>();

        for (int i = 0; i <= n ; i++) {
            seq = optimal_sequence(i);

            System.out.println(i + " " + seq);
            table.add(seq.size());
        }
        System.out.println(table);

        return seq;
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

        optimalSequence(n);
    }
}

