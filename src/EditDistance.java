import java.util.*;

class EditDistance {
    public static int EditDistance(String s, String t) {
        //write your code here
        int[][] matrix = new int[s.length() + 1][t.length() + 1];
        int diag;
        int up;
        int left;


        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= t.length(); j++) {

                if (i == 0)
                    matrix[i][j] = j;
                else if (j == 0)
                    matrix[i][j] = i;
                else {

                    up = matrix[i-1][j] + 1;
                    left = matrix[i][j-1] + 1;

                    if (s.charAt(i - 1) == (t.charAt(j - 1)))
                        diag = matrix[i-1][j-1];
                    else
                        diag = matrix[i-1][j-1] + 1;

                    matrix[i][j] = Math.min(Math.min(up, diag), left);

                }

            }
            //System.out.println(Arrays.toString(matrix[i]));
        }

        return matrix[s.length()][t.length()];
    }


    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        String s = scan.next();
        String t = scan.next();


        System.out.println(EditDistance(s, t));
    }

}
