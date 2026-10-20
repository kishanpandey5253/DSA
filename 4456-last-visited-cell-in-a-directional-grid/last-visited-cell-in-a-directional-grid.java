
class Solution {
    public int[] lastVisitedCell(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        int i = 0;
        int j = 0;

        while (true) {
            visited[i][j] = true;

            int ni = i;
            int nj = j;

            if (grid[i][j] == 'L') {
                nj--;
            } 
            else if (grid[i][j] == 'R') {
                nj++;
            } 
            else if (grid[i][j] == 'U') {
                ni--;
            } 
            else {
                ni++;
            }

            if (ni < 0 || ni >= m || nj < 0 || nj >= n) {
                break;
            }

            if (visited[ni][nj]) {
                break;
            }

            i = ni;
            j = nj;
        }

        return new int[]{i, j};
    }
}
