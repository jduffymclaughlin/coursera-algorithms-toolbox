import java.util.Scanner;
import java.lang.*;

public class Change {

    private static int getChange2(int m) {
        int count = 0;
        int result;
        int[] denoms = new int[] {10, 5, 1};


        for (int i = 0; i < denoms.length; i++) {
            if (m == 0) {
                return count;
            } else {
                result = Math.floorDiv(m, denoms[i]);
                count += result;
                m -= denoms[i] * result;
            }
        }

        return count;
    }

    private static int getChange(int m) {

        int[] denoms = new int[] {10, 5, 1};
        int coins = 0;

        while (m > 0) {
            if (denoms[0] < m) {
                m -= denoms[0];
            } else if (denoms[1] < m) {
                m -= denoms[1];
            } else {
                m -= denoms[2];
            }
            coins++;
        }
        return coins;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange2(m));

    }
}

