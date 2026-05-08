class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int l = 0, r = numbers.length - 1;

        while (l < r) {
            int ln = numbers[l];
            int rn = numbers[r];
            if (ln + rn == target) {
                res[0] = l + 1;
                res[1] = r + 1;
                break;
            } else if (ln + rn > target) r--;
            else l++;
        }

        return res;
    }
}
