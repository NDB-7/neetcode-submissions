class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        A, B = nums1, nums2
        total = len(A) + len(B)
        half = total // 2

        if len(B) < len(A):
            A, B = B, A

        l, r = 0, len(A) - 1
        while True:
            i = (l + r) // 2
            j = half - i - 2

            al = A[i] if i >= 0 else float("-inf")
            ar = A[i + 1] if i + 1 < len(A) else float("inf")
            bl = B[j] if j >= 0 else float("-inf")
            br = B[j + 1] if j + 1 < len(B) else float("inf")

            if al <= br and bl <= ar:
                if total % 2:
                    return min(ar, br)
                return (max(al, bl) + min(ar, br)) / 2
            elif al > br:
                r = i - 1
            else:
                l = i + 1