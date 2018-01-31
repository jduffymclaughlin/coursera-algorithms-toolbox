import java.util.*;


public class FractionalKnapsack {

    private static int getMaxRatioIndex(ArrayList<Integer> v, ArrayList<Integer> w){
        double maxRatio = 0.0;
        int maxRatioIdx = 0;

        for (int i = 0; i < w.size(); i++) {
            if (((v.get(i) * 1.0) / (1.0 * w.get(i))) > maxRatio) {
                maxRatio = (v.get(i) * 1.0) / (1.0 * w.get(i));
                maxRatioIdx = i;
            }
        }

        return maxRatioIdx;
    }


    private static double getOptimalValue(int capacity, ArrayList<Integer> values, ArrayList<Integer> weights) {
        double value = 0;

        for (int i = 0; i < values.size(); i++) {
            if (capacity == 0) {
                return value;
            }

            if (capacity > weights.get(i)) {
                value += values.get(i);
                capacity -= weights.get(i);
            } else {
                value += capacity * ((1.0 * values.get(i)) / (1.0 * weights.get(i)) );
                capacity  = 0;
            }

        }

        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();

        ArrayList<Integer> values = new ArrayList<Integer>();
        ArrayList<Integer> weights = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {
            values.add(scanner.nextInt());
            weights.add(scanner.nextInt());
        }

        ArrayList<Integer> valuesList = new ArrayList<Integer>();
        ArrayList<Integer> weightsList = new ArrayList<Integer>();

        // sort by ratio
        for (int i = 0; i < n; i++) {
            int idx = getMaxRatioIndex(values, weights);

            valuesList.add(values.get(idx));
            weightsList.add(weights.get(idx));

            values.remove(idx);
            weights.remove(idx);
        }

        System.out.println(getOptimalValue(capacity, valuesList, weightsList));
    }
}
