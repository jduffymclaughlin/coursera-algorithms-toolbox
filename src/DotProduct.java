import java.util.*;

public class DotProduct {

    private static int maxIndex(ArrayList<Integer> arr) {
        int maxVal = arr.get(0);
        int maxIndex = 0;

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) > maxVal) {
                maxVal = arr.get(i);
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    private static long maxDotProduct(ArrayList<Integer> aList, ArrayList<Integer> bList) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<Integer> b = new ArrayList<Integer>();
        int adex;
        int bdex;
        int size = aList.size();

        for (int i = 0; i < size; i++) {
            adex = maxIndex(aList);
            bdex = maxIndex(bList);

            a.add(aList.get(adex));
            b.add(bList.get(bdex));

            aList.remove(adex);
            bList.remove(bdex);
        }

        long result = 0;
        for (int i = 0; i < a.size(); i++) {
            result += (long) a.get(i) * (long) b.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> a = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            a.add(scanner.nextInt());
        }
        ArrayList<Integer> b = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            b.add(scanner.nextInt());
        }

        System.out.println(maxDotProduct(a, b));
    }
}

