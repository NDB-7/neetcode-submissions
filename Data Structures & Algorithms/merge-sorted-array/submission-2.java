class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m + n - 1, j = m - 1, k = n - 1;
        while (k > -1) {
            if (j > -1 && nums1[j] > nums2[k]) nums1[i--] = nums1[j--];
            else nums1[i--] = nums2[k--];
        }
    }
}