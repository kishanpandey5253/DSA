class Solution {

    int[][] dp = new int[501][501];

    int fun(int i, int j, int[] nums1, int[] nums2) {

        if(i >= nums1.length || j >= nums2.length)
            return 0;

        if(dp[i][j] != -1)
            return dp[i][j];

        int m = 0;

        if(nums1[i] == nums2[j]) {

            int a = 1 + fun(i + 1, j + 1, nums1, nums2);
            m = Math.max(m, a);

        } else {

            int a = fun(i + 1, j, nums1, nums2);
            int b = fun(i, j + 1, nums1, nums2);

            m = Math.max(m, a);
            m = Math.max(m, b);
        }

        return dp[i][j] = m;
    }

    public int maxUncrossedLines(int[] nums1, int[] nums2) {

        for(int i = 0; i < 501; i++) {
            Arrays.fill(dp[i], -1);
        }

        return fun(0, 0, nums1, nums2);
    }
}