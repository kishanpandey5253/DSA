
class Solution {
    public int findColoredRoot(int[][] edges, String colors) {
        int n = colors.length();
        int[] degree = new int[n];
        int[] balance = new int[n];

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            degree[u]++;
            degree[v]++;

            char a = colors.charAt(u);
            char b = colors.charAt(v);

            if (next(a) == b) {
                balance[u]++;
                balance[v]--;
            } else if (next(b) == a) {
                balance[v]++;
                balance[u]--;
            } else {
                return -1;
            }
        }

        int root = -1;

        for (int i = 0; i < n; i++) {
            if (balance[i] == degree[i]) {
                if (degree[i] > 2)
                    return -1;

                if (root != -1)
                    return -1;

                root = i;
            } else if (balance[i] != degree[i] - 2) {
                return -1;
            }
        }

        return root;
    }

    private char next(char c) {
        if (c == 'R') return 'B';
        if (c == 'B') return 'W';
        return 'R';
    }
}
