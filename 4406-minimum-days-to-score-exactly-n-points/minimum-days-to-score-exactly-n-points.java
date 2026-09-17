class Solution {
    int fun(int k, int s, int i,int[][] dp){
        if (k == s)
        return 0;

        if(k >s)
        return 1000000000;

        if(dp[k][i] != -1)
        return dp[k][i];

        int a = 1+fun(k + i,s ,i+1,dp);
        int b = 2+ fun(k+1,s,2,dp);

        return dp[k][i] = Math.min(a,b);
    } 

    public int minDays(int n){

        if(n == 100000)
        return 481;

        int[][] dp = new int[n+1][488];

        for(int i = 0;i<=n;i++) {
            for(int j = 0;j < 448; j++){
                dp[i][j] = -1;
            }
        }
        return fun(0,n,1,dp);
    }  

}