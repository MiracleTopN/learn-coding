/**
 * @author hason
 * @since 2023/10/31 16:50
 */
class Solution {
    private int[][] matrix;
    private int[][] memo;
    private final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int longestPath(int[][] matrix, int x, int y) {
        this.matrix = matrix;
        memo = new int[matrix.length][matrix[0].length];
        return dfs(x, y);
    }

    private int dfs(int x, int y) {
        if (memo[x][y] != 0) {
            return memo[x][y];
        }
        int maxLen = 1;
        for (int[] dir : directions) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (matrix[nx][ny] < matrix[x][y]) {
                maxLen = Math.max(maxLen, 1 + dfs(nx, ny));
            }
        }
        memo[x][y] = maxLen;
        return maxLen;
    }
}
