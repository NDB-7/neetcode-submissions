class Solution:
    def search(self, nums: List[int], target: int) -> bool:
        l, r = 0, len(nums) - 1

        while l <= r:
            m = (l + r) // 2
            if nums[m] == target:
                return True
            if nums[l] == nums[m] == nums[r]:
                l += 1
                r -= 1
            elif nums[l] <= nums[m]: # left half sorted
                if nums[m] > target and nums[l] <= target:
                    r = m - 1
                else:
                    l = m + 1
            elif nums[m] <= nums[r]: # right half sorted
                if nums[m] < target and nums[r] >= target:
                    l = m + 1
                else:
                    r = m - 1


        return False