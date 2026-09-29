class Solution {

    int [][] dp = new int[1001][1001];

    boolean check(String a, String b) {

        if (b.length() != a.length() + 1)
            return false;

        int i = 0;
        int j = 0;

        while (i < a.length() && j < b.length()) {

            if (a.charAt(i) == b.charAt(j)) {
                i++;
            }

            j++;
        }

        return i == a.length();
    }

    int fun(String[] words, int i, int pre) {

        if (i >= words.length) {
            return 0;
        }
        if (dp[i][pre + 1] != -1) {
            return dp[i][pre + 1];
        }

        int take = 0;

        if (pre == -1 || check(words[pre], words[i])) {
            take = 1 + fun(words, i + 1, i);
        }

        int skip = fun(words, i + 1,pre);

        return dp[i][pre + 1] =  Math.max(take, skip);
    }

    public int longestStrChain(String[] words) {

        Arrays.sort(words, (a, b) -> a.length() - b.length());

        for(int i = 0; i<1001; i++){
            Arrays.fill(dp[i], -1);
        }

        return fun(words, 0, -1);
    }
}