class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        int diff = target - numbers[r];

        while (diff != numbers[l]) {
            if (diff < numbers[l]) r--;
            else l++;
            diff = target - numbers[r];
        }

        int[] res = new int[2];
        res[0] = l + 1;
        res[1] = r + 1;
        return res;
    }
}
