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
        return functools.reduce(operator.or_, nums)
    
print(bin(12))
print(bin(18))
print()
print(bin(9))
print(bin(24))
solution = Solution()
nums = [12,9]
