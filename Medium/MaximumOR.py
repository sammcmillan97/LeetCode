"""You are given a 0-indexed integer array nums of length n and an integer k. In an operation, you can choose an element and multiply it by 2.

Return the maximum possible value of nums[0] | nums[1] | ... | nums[n - 1] that can be obtained after applying the operation on nums at most k times.

Note that a | b denotes the bitwise or between two integers a and b."""

import functools
import operator

class Solution(object):
    def maximumOr(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        # check binary length double if one is larger
        # if the same then brute force all permuations
        
        longest_binary = self.findIndexOfLongestBinary(nums)
        if longest_binary == -1:
            return self.maximumOrSearchAll(nums, k)

        for _ in range(0, k):
            nums[longest_binary] = nums[longest_binary] * 2    
        return functools.reduce(operator.or_, nums)
    

    def findIndexOfLongestBinary(self, nums):
        index = 0
        has_changed = False
        for i in range(1, len(nums)):
            if len(bin(nums[i])) >= len(bin(nums[index])):
                if has_changed:
                    return -1
                has_changed = True
                index = i
        return index

    def maximumOrSearchAll(nums, k):
        return 0        


solution = Solution()
print(bin(12))
print(bin(9))
nums = [18, 12]
print(bin(functools.reduce(operator.or_, nums)))

nums = [12,9]
print (solution.maximumOr(nums, 2))
