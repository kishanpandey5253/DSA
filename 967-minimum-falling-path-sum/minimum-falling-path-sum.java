class Solution {
    int[][] dp;
    int n;

    int fun(int i, int j, int[][] a) {
        if (j < 0 || j >= n)
            return 1000000000;

        if (i == n - 1)
            return a[i][j];

        if (dp[i][j] != Integer.MAX_VALUE)
            return dp[i][j];

        int x = fun(i + 1, j, a);
        int y = fun(i + 1, j - 1, a);
        int z = fun(i + 1, j + 1, a);

        return dp[i][j] = a[i][j] + Math.min(x, Math.min(y, z));
    }

    public int minFallingPathSum(int[][] matrix) {
        n = matrix.length;
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        int ans = Integer.MAX_VALUE;

        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, fun(0, j, matrix));
        }

        return ans;
    }
}