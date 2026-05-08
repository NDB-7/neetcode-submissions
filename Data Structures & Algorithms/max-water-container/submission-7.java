class Solution {
    public int maxArea(int[] heights) {
        int l = 0, r = heights.length - 1;
        int maxArea = (r - l) * Math.min(heights[l], heights[r]);

        while (l < r) {
            if (heights[l] < heights[r]) l++;
            else r--;
            maxArea = Math.max(maxArea, (r - l) * Math.min(heights[l], heights[r]));
        }

        return maxArea;
    }
}
