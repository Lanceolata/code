#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def findRelativeRanks(self, nums):
        """
        :type nums: List[int]
        :rtype: List[str]
        """
        index = range(len(nums))
        sort = sorted(index, cmp = lambda x, y: nums[x] - nums[y], reverse=True)
        top = ["Gold Medal", "Silver Medal", "Bronze Medal"]
        res = [""] * len(nums)
        for i, n in enumerate(sort):
            if i < 3:
                res[n] = top[i]
            else:
                res[n] = str(i + 1)

        return res

    def findRelativeRanks_fast(self, nums):
        score = sorted(nums, reverse=True)
        rank = ["Gold Medal", "Silver Medal", "Bronze Medal"] + map(str, range(4, len(nums) + 1))
        return map(dict(zip(score, rank)).get, nums)


sol = Solution()
print sol.findRelativeRanks([10,3,8,9,4])
