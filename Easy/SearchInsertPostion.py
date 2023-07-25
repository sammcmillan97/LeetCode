class Solution(object):
    def searchInsert(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        offset = 0
        while(len(nums) != 1):
            half_of_nums = len(nums) // 2
            if nums[half_of_nums] > target: 
                nums = nums[:half_of_nums]
            else:
                nums = nums[half_of_nums:]
                offset += half_of_nums
                
        if nums[0] < target:
            return offset + 1            
        return offset             

list_a = [1,2,3,4,5]
list_b = [1,2,3,4]

solution = Solution()

print(solution.searchInsert(list_a, 3))
print(solution.searchInsert(list_b, 3))