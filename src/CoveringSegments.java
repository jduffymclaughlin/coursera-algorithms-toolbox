import java.util.*;
import java.util.function.Predicate;

public class CoveringSegments {

    private static int maxOverlap(ArrayList<Segment> arr, int minStart, int maxEnd) {
        int maxOverlap = 0;
        int numOverlap = 0;
        int count;

        for (int j = minStart; j < maxEnd; j++) {
            count = 0;
            for (Segment s : arr) {
                if (j >= s.start && j <= s.end) {
                    count++;
                }
            }

            if (count > numOverlap) {
                numOverlap = count;
                maxOverlap = j;

            }
        }
        return maxOverlap;
    }

    private static ArrayList<Integer> optimalPoints2(ArrayList<Segment> segments) {
        ArrayList<Integer> points = new ArrayList<Integer>();
        int point;

        int minStart = segments.get(0).start;
        int maxEnd = segments.get(0).end;

        for (int i = 0; i < segments.size(); i++) {
            if (segments.get(i).start < minStart){
                minStart = segments.get(i).start;
            }
            if (segments.get(i).end > maxEnd) {
                maxEnd = segments.get(i).end;
            }
        }


        while (segments.size() > 0) {
            point = maxOverlap(segments, minStart, maxEnd);
            points.add(point);

            Iterator<Segment> iter = segments.iterator();
            while (iter.hasNext()) {
                Segment s = iter.next();
                if (point >= s.start && point <= s.end) {
                    iter.remove();
                }
            }

        }

        return points;
    }

    private static int[] optimalPoints(Segment[] segments) {
        //write your code here
        int[] points = new int[2 * segments.length];
        for (int i = 0; i < segments.length; i++) {
            points[2 * i] = segments[i].start;
            points[2 * i + 1] = segments[i].end;
        }
        return points;
    }

    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Segment> segments = new ArrayList<Segment>();

        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments.add(new Segment(start, end));
        }

        ArrayList<Integer> points = optimalPoints2(segments);

        System.out.println(points.size());
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}

