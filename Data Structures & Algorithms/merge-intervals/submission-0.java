class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);

        for (int[] itv : intervals) {
            if (itv[0] <= res.get(res.size() - 1)[1])
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], itv[1]);
            else res.add(itv);
        }

        return res.toArray(new int[res.size()][2]);
    }
}
