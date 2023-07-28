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
        
        list_of_candidates = self.findCandidates(nums)
        print(list_of_candidates)
        if len(list_of_candidates) == 1:
            for _ in range(0, k):
                nums[list_of_candidates[0]] = nums[list_of_candidates[0]] * 2
            return functools.reduce(operator.or_, nums)    
        else:
            return self.maximumOrSearchAll(nums, list_of_candidates, k)
    

    def findCandidates(self, nums):
        """Returns a list of indexes corresponding to ints in nums that have the maximum binary sequence length"""
        candidates = []
        max_binary_length = max(len(bin(i)) for i in nums)
        for i in range(0, len(nums)):
            if len(bin(nums[i])) == max_binary_length:
                candidates.append(i)
        return candidates

    def maximumOrSearchAll(self, nums, list_of_candidates, k):

    def generateDoubleNums(self, nums, list_of_candidates, k, doubles=[]):     

        if k == 0:
            return nums
        
        for i in range(0, len(list_of_candidates)):
            #Double i 
            doubles.append(nums)
            #Dont double i
            dobules.append()

        return doubles
              


solution = Solution()
print(bin(12))
print(bin(9))
nums = [18, 12]
print((functools.reduce(operator.or_, nums)))

nums = [12,9]
print (solution.maximumOr(nums, 2))
