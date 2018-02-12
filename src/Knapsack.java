import java.util.*;

public class Knapsack {

    static int optimalWeight(int W, int[] w) {

        int[][] matrix = new int[w.length + 1][W + 1];

        for (int i = 0; i <= w.length; i++) {
            for (int j = 0; j <= W; j++) {

                if (i == 0)
                    matrix[i][j] = 0;
                else if (j == 0)
                    matrix[i][j] = 0;
                else {

                    matrix[i][j] = matrix[i-1][j];

                    if (w[i-1] <= j){
                        int value = matrix[i-1][j - w[i-1]] + w[i-1];
                        if (value > matrix[i][j]) {
                            matrix[i][j] = value;
                        }
                    }
                }
            }
            //System.out.println(Arrays.toString(matrix[i]));
        }

        return matrix[w.length][W];
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}

