class Solution {
    int[][] dp = new int[102][2];
    int fun(int i, int[] nums, int f){
        if(i == nums.length - 1){
            if (f == 1)
                return 0;

            return nums[i];
        }

        if (dp[i][f] != -1)
            return dp[i][f];

        if(i >= nums.length)
            return 0;

        int nf = f;

        if(i == 0){
            nf = 1;
        }

        int rob = nums[i]+fun(i+2,nums,nf);
        int not_rob = fun(i+1,nums,f);

        return dp[i][f] = Math.max(rob,not_rob);
    }
    public int rob(int[] nums) {

        for (int i = 0; i< 102; i++){
            Arrays.fill(dp[i], -1);
        }

        return fun(0,nums,0);
        
    }
}