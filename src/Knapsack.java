import java.util.*;

public class Knapsack {

    static int optimalWeight(int W, int[] w) {
        //write you code here

        int[][] matrix = new int[w.length + 1][W + 1];

        for (int i = 0; i <= w.length; i++) {
            for (int j = 0; j <= W; j++) {

                if (i == 0)
                    matrix[i][j] = 0;
                else if (j == 0)
                    matrix[i][j] = 0;
                else {

                    matrix[i][j] = j;
                    for (int n : w){
                        //System.out.println(n);
                        if (matrix[i][j] >= n)
                            matrix[i][j] += n;





                    }
//                    if (w[i + 1] >= j)
//                        matrix[i][j] += j;

                    matrix[i][j] = i * j;





                }
            }
            System.out.println(Arrays.toString(matrix[i]));
        }



        int result = 0;
        for (int i = 0; i < w.length; i++) {
            if (result + w[i] <= W) {
                result += w[i];
            }
        }
        return result;
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

