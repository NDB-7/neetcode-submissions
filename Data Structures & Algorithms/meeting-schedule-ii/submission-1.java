/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int[] start = new int[intervals.size()];
        int[] end = new int[intervals.size()];

        for (int i = 0; i < intervals.size(); i++) {
            Interval itv = intervals.get(i);
            start[i] = itv.start;
            end[i] = itv.end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int max = 0, active = 0;
        int l = 0, r = 0;

        while (l < intervals.size()) {
            int s = start[l];
            int e = end[r];

            if (s < e) {
                l++;
                active++;
                max = Math.max(max, active);
            } else {
                r++;
                active--;
            }
        }

        return max;
    }
}
