import java.util.*;


public class PrimitiveCalculator {
    private static ArrayList<Integer> optimalSequence(int n) {
        int[] table = new int[n + 1];
        table[0] = 0;
        int i = 1;

        while (i <= n) {
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

        ArrayList sequence = new ArrayList<Integer>();

        int j = n;
        while (j > 1) {
            sequence.add(j);

            if (table[j - 1] == table[j] - 1)
                j = j - 1;

            else if (j % 2 == 0 && (table[j / 2] == table[j] - 1))
                j = j / 2;

            else if (j % 3 == 0 && (table[j / 3] == table[j] - 1))
                j = j / 3;
        }

        sequence.add(1);
        Collections.reverse(sequence);

        return sequence;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> opt_seq = optimalSequence(n);

        System.out.println(opt_seq.size() - 1);
        for (Integer i : opt_seq) {
            System.out.print(i + " ");
        }

    }
}

