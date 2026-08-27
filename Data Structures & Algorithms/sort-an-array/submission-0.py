class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        def partition(start, end):
            pivot = nums[(start + end) // 2]
            l, r = start - 1, end + 1
            while l < r:
                while True:
                    l += 1
                    if nums[l] >= pivot:
                        break
                while True:
                    r -= 1
                    if nums[r] <= pivot:
                        break
                if l >= r:
                    return r

                nums[l], nums[r] = nums[r], nums[l]
            return r

        def quickSort(start, end):
            if start >= end:
                return
            i = partition(start, end)
            quickSort(start, i)
            quickSort(i + 1, end)

        quickSort(0, len(nums) - 1)

        return nums