class Solution {

    int[][][] dp = new int[101][101][201];

    int fun(int p, int q, int r, String a, String b, String c) {

        if (p >= a.length()) {

            while (q < b.length() && r < c.length()) {

                if (b.charAt(q) == c.charAt(r)) {
                    q++;
                    r++;
                } else {
                    return 0;
                }
            }

            return 1;
        }

        if (q >= b.length()) {

            while (p < a.length() && r < c.length()) {

                if (a.charAt(p) == c.charAt(r)) {
                    p++;
                    r++;
                } else {
                    return 0;
                }
            }

            return 1;
        }
        if(dp[p][q][r] != -1)
        return dp[p][q][r];

        int ans = 0;

        if (a.charAt(p) == c.charAt(r)) {
            int x = fun(p + 1, q, r + 1, a, b, c);
            ans = ans | x;
        }

        if (b.charAt(q) == c.charAt(r)) {
            int y = fun(p, q + 1, r + 1, a, b, c);
            ans = ans | y;
        }

        if (a.charAt(p) != c.charAt(r) &&
            b.charAt(q) != c.charAt(r)) {
            return 0;
        }

        return dp[p][q][r] = ans;
    }

    public boolean isInterleave(String s1, String s2, String s3) {

        if (s1.length() + s2.length() != s3.length())
            return false;

            for(int p = 0;p<101;p++){
                for(int q=0;q<101;q++){
                    for(int r=0;r<201;r++){
                        dp[p][q][r] = -1;
                    }
                }
            }



        return fun(0, 0, 0, s1, s2, s3) == 1;
    }
}