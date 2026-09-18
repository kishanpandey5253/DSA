class Solution {
    int[][] dp;

    int fun(String s, int i, int j) {
        if(i > j) return 0;
        if(i == j) return 1;

        if(dp[i][j] != -1) 
        return dp[i][j];

        int m = 0;

        if(s.charAt(i) == s.charAt(j)) {
            int a = 2 + fun(s, i + 1, j - 1);
            m = Math.max(m, a);
        } else {
            int a = fun(s, i + 1, j);
            int b = fun(s, i, j - 1);

            m = Math.max(m, a);
            m = Math.max(m, b);
        }

        return dp[i][j] = m;
    }

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        dp = new int[n][n];

        for(int i =0; i<n;i++){
            for(int j = 0;j<n;j++){
                dp[i][j] = -1;
            }
        }

        return fun(s, 0, n - 1);
    }
}