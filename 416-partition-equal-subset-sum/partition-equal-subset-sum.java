
class Solution {

    int[][] dp;

    boolean fun(int i, int target, int[] nums) {

        if (target == 0)
            return true;

        if (i == nums.length)
            return false;

        if (dp[i][target] != 0) {
            if (dp[i][target] == 1)
                return true;
            else
                return false;
        }

        boolean take = false;

        if (nums[i] <= target) {
            take = fun(i + 1, target - nums[i], nums);
        }

        boolean notTake = fun(i + 1, target, nums);

        boolean ans = take || notTake;

        if (ans == true) {
            dp[i][target] = 1;
        } else {
            dp[i][target] = -1;
        }

        return ans;
    }

    public boolean canPartition(int[] nums) {

        int sum = 0;

        for (int x : nums) {
            sum += x;
        }

        if (sum % 2 != 0)
            return false;

        int target = sum / 2;

        dp = new int[nums.length][target + 1];

        return fun(0, target, nums);
    }
}
