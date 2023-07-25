def removeDuplicates(self,nums):
    """
    :type nums: List[int]
    :rtype: int
    """
    if len(nums) == 0:
        return 0, nums
    if len(nums) == 1:
        return 1, nums
    
    num_unique_elements = 1
    new_nums = []
    new_nums.append(nums[0])
    
    for i in range(1, len(nums)):
        if nums[i - 1] != nums[i]:
            new_nums.append(nums[i])
            num_unique_elements += 1

    return num_unique_elements, new_nums


nums = [1, 2]
print(removeDuplicates(nums))