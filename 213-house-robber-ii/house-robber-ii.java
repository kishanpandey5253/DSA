class Solution {
    int dp[] = new int[102];
    int fun(int i, int end, int[] nums){
        if (i > end)
            return 0;

        if (dp[i] != -1)
            return dp[i];

        int c1 = nums[i] +fun(i+2,end,nums);
        int c2 = fun(i+1,end,nums);

        dp[i] = Math.max(c1,c2);
            return dp[i];

    }   

    int solve(int start,int end,int[] nums) {

        for( int i = 0; i<101; i++){
            dp[i] = -1;
        }
        return fun(start,end,nums);
    }

    public int rob(int[] nums) {
        
        if(nums.length == 1)
            return nums[0];

        int c1 = solve(0,nums.length - 2,nums);
        int c2 = solve(1,nums.length - 1,nums);

        return Math.max(c1 , c2);
    }
}