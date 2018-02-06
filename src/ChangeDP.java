import java.util.*;


public class ChangeDP {

    private static int getChange(int money) {
        int[] table = new int[money + 1];
        int[] coins = {1, 3, 4};
        table[0] = 0;

        for (int i = 1; i <= money; i++) {
            table[i] = Integer.MAX_VALUE;

            for (int c : coins) {
                if (i >= c) {
                    int numCoins = table[i - c] + 1;

                    if (numCoins < table[i]) {
                        table[i] = numCoins;
                    }
                }
            }
        }

        return table[money];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

