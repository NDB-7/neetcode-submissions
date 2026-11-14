class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        # Given int array nums and int k
        # Return:
            # True if there's two distinct indices i and j in array such that nums[i] == nums[j] and abs(i - j) <= k
        m = {}
        for i in range(len(nums)):
            if nums[i] in m and abs(i - m[nums[i]]) <= k:
                return True
            m[nums[i]] = i
        
        return False