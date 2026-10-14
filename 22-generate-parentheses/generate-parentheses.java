
class Solution {
    List<String> ans = new ArrayList<>();

    void solve(int open, int close, int n, String s) {
        if (s.length() == 2 * n) {
            ans.add(s);
            return;
        }

        if (open < n) {
            solve(open + 1, close, n, s + "(");
        }

        if (close < open) {
            solve(open, close + 1, n, s + ")");
        }
    }

    public List<String> generateParenthesis(int n) {
        solve(0, 0, n, "");
        return ans;
    }
}
