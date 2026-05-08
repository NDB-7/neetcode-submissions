class Solution {
    public int maxArea(int[] heights) {
        int maxL = 0, maxR = 0, l = 0, r = heights.length - 1, res = 0;
        while (l < r) {
            int h = Math.min(heights[l], heights[r]);
            int water = h * (r - l);
            res = Math.max(water, res);
            if (heights[l] < heights[r]) l++;
            else r--;
        }

        return res;
    }
}
