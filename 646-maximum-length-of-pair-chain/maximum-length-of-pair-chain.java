class Solution {

    int[][]dp = new int[1001][1001];

    int fun(int[][] pairs, int i, int pre) {

        if (i >= pairs.length) {
            return 0;
        }
         if (dp[i][pre + 1] != -1) {
            return dp[i][pre + 1];
        }

        int m = 0;

        if (pre == -1 || pairs[i][0] > pairs[pre][1]) {
            int a = 1 + fun(pairs, i + 1, i);
            m = Math.max(m, a);
        }

        int b = fun(pairs, i + 1, pre);
        m = Math.max(m, b);

        dp[i][pre + 1] = m;

        return m;
    }

    public int findLongestChain(int[][] pairs) {

        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);

        for (int i = 0; i < 1001; i++) {
            Arrays.fill(dp[i], -1);
        }

        return fun(pairs, 0, -1);
    }
}