class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> res = new ArrayList<>();

        int i = 0;

        while (i < n && newInterval[0] > intervals[i][1]) {
            res.add(intervals[i++]);
        }

        while (i < n && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(newInterval);

        while (i < n) {
            res.add(intervals[i++]);
        }

        return res.toArray(new int[res.size()][2]);
    }
}

/*

Six cases:
- A before B, no overlap
- B before A, no overlap
- B starts before A ends, overlap
- A starts before B ends, overlap
- A starts after B and ends before B, overlap
- B starts after A and ends before A, overlap

Idea:
- Loop while 

*/