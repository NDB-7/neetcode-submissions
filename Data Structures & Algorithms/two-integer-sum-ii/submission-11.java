class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int p1 = 0, p2 = numbers.length - 1;

        while (p1 < p2 && numbers[p1] + numbers[p2] != target) {
            if (numbers[p1] + numbers[p2] > target) p2--;
            else p1++;
        }

        int[] res = new int[2];
        res[0] = p1 + 1;
        res[1] = p2 + 1;
        return res;
    }
}
