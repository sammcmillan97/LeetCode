class Solution(object):
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
        for i in range(0, len(haystack) - len(needle) + 1):
                if needle[0] == haystack[i]:
                    if all(needle[j - i] == haystack[j] for j in range(i, len(needle) + i)):
                         return i
        return -1
                           
    

haystack = "hello"
needle = "ll"

print(Solution.strStr(Solution, haystack, needle))

