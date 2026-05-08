class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int l = 0, r = m * n - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int num = matrix[mid / n][mid % n];

            if (num < target) l = mid + 1;
            else if (num > target) r = mid - 1;
            else return true;
        }

        return false;
    }
}
