/*class Solution {
    int n;
    int[][] grid;
    public int cherryPickup(int[][] grid) {
        this.grid = grid;
        this.n = grid.length;

        int result = solve(0, 0, 0);
        return Math.max(0, result);
    }

    private int solve(int r1, int c1, int r2) {
        int c2 = r1 + c1 - r2;
        if (r1 >= n || c1 >= n || r2 >= n || c2 >= n ||
            grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return Integer.MIN_VALUE;
        }

        if (r1 == n - 1 && c1 == n - 1) {
            return grid[r1][c1];
        }
        int cherries = grid[r1][c1];
        if (r1 != r2) {
            cherries += grid[r2][c2];
        }
        int downDown = solve(r1 + 1, c1, r2 + 1);
        int rightRight = solve(r1, c1 + 1, r2);
        int downRight = solve(r1 + 1, c1, r2);
        int rightDown = solve(r1, c1 + 1, r2 + 1);

        int maxNext = Math.max(Math.max(downDown, rightRight),Math.max(downRight,rightDown)
);
return cherries + maxNext;
    }
}*/
class Solution {
    int n;
    int[][] grid;
    Integer[][][] dp;

    public int cherryPickup(int[][] grid) {
        this.grid = grid;
        this.n = grid.length;
        this.dp = new Integer[n][n][n];

        int result = solve(0, 0, 0);
        return Math.max(0, result);
    }
    private int solve(int r1, int c1, int r2) {
        int c2 = r1 + c1 - r2;
        if (r1 >= n || c1 >= n || r2 >= n || c2 >= n ||
            grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return Integer.MIN_VALUE;
        }
        if (r1 == n - 1 && c1 == n - 1) {
            return grid[r1][c1];
        }

        if (dp[r1][c1][r2] != null) {
            return dp[r1][c1][r2];
        }
        int cherries = grid[r1][c1];
        if (r1 != r2) {
            cherries += grid[r2][c2];
        }
        int downDown = solve(r1 + 1, c1, r2 + 1);
        int rightRight = solve(r1, c1 + 1, r2);
        int downRight = solve(r1 + 1, c1, r2);
        int rightDown = solve(r1, c1 + 1, r2 + 1);
        int maxNext = Math.max(
            Math.max(downDown, rightRight),
            Math.max(downRight, rightDown)
        );
        cherries += maxNext;
        dp[r1][c1][r2] = cherries;

        return cherries;
    }
}