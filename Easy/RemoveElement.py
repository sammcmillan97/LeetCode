class Solution(object):
    def removeElement(self, nums, val):
        """
        :type nums: List[int]
        :type val: int
        :rtype: int
        """
        new_nums = []
        for value in nums:
            if value != val:
                new_nums.append(value)
        nums[:] = new_nums
        return nums

solution = Solution()
nums = [0,1,2,2,3,0,4,2]
print(solution.removeElement(nums, 2))