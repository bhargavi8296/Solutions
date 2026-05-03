// class Solution {
//     public int numSubarraysWithSum(int[] nums, int goal) {
//         HashMap<Integer,Integer>map=new HashMap<>();
//         map.put(0,1);
//         int sum=0;
//         int result=0;
//         for(int i=0;i<nums.length;++i)
//         {
//             sum+=nums[i];
//             result+=map.getOrDefault(sum-goal,0);
//             map.put(sum,map.getOrDefault(sum,0)+1);
//         }
//         return result;
//     }
// }
class Solution {
    // Helper function to count the number of subarrays with sum at most the given goal
    private int slidingWindowAtMost(int[] nums, int goal) {
        int start = 0, currentSum = 0, totalCount = 0;

        // Iterate through the array using a sliding window approach
        for (int end = 0; end < nums.length; end++) {
            currentSum += nums[end];

            // Adjust the window by moving the start pointer to the right
            // until the sum becomes less than or equal to the goal
            while (start <= end && currentSum > goal) {
                currentSum -= nums[start++];
            }

            // Update the total count by adding the length of the current subarray
            totalCount += end - start + 1;
        }
        return totalCount;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        return slidingWindowAtMost(nums, goal) - slidingWindowAtMost(nums, goal - 1);
    }
}