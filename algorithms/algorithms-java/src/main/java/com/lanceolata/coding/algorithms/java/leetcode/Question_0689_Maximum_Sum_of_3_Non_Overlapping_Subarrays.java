package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0689_Maximum_Sum_of_3_Non_Overlapping_Subarrays {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        if (nums.length < k * 3) {
            return new int[]{};
        }
        int numOfSubArrays = nums.length - k + 1;

        int[] subArraySum = new int[numOfSubArrays];
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        subArraySum[0] = sum;
        int index = 1;
        int left = 0;
        for (int right = k; right < nums.length; right++) {
            sum += nums[right];
            sum -= nums[left];
            left++;
            subArraySum[index] = sum;
            index++;
        }

        int[] leftMaxSum = new int[numOfSubArrays];
        int[] rightMaxSum = new int[numOfSubArrays];
        for (int i = 1; i < numOfSubArrays; i++) {
            leftMaxSum[i] = leftMaxSum[i - 1];
            if (subArraySum[i] > subArraySum[leftMaxSum[i]]) {
                leftMaxSum[i] = i;
            }
        }

        rightMaxSum[numOfSubArrays - 1] = numOfSubArrays - 1;

        for (int i = numOfSubArrays - 2; i >= 0; i--) {
            rightMaxSum[i] = rightMaxSum[i + 1];
            if (subArraySum[i] >= subArraySum[rightMaxSum[i]]) {
                rightMaxSum[i] = i;
            }
        }

        int maxSum = 0;
        int[] ans = new int[3];

        for (int i = k; i + k < numOfSubArrays; i++) {
            int currSum = subArraySum[i] + subArraySum[leftMaxSum[i - k]] + subArraySum[rightMaxSum[i + k]];
            if (currSum > maxSum) {
                maxSum = currSum;
                ans = new int[]{leftMaxSum[i - k], i, rightMaxSum[i + k]};
            }
        }

        return ans;
    }
}
