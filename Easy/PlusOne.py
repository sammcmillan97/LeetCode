class Solution(object):
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
        number = int("".join(str(digit) for digit in digits)) + 1
        return [int(x) for x in str(number)]
    

digits = [1,2,3]
solution = Solution()
print(solution.plusOne(digits))