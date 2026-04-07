/*Recursive
class Solution {
    int MOD = 1000000007;
    public int solve(int[] group, int[] profit, int minProfit, int maxPeople, int idx) {
        if (maxPeople < 0) return 0;
        if (idx == group.length) {
            if (minProfit > 0) return 0;
            else return 1; 
        }
        int pick = solve(group,profit,minProfit - profit[idx],maxPeople - group[idx],idx + 1);
        int notPick = solve(group,profit,minProfit,maxPeople,idx + 1);
        return (int)((pick + (long)notPick) % MOD);
    }
public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        return solve(group, profit, minProfit, n, 0);
    }
}*/

class Solution {
    int MOD = 1000000007;
    Integer[][][] dp;
    int mx(int a, int b) {
        return (a > b) ? a : b;
    }
    public int solve(int[] group, int[] profit, int idx, int peopleLeft, int minProfit) {
        if (peopleLeft < 0) return 0;
        if (idx == group.length) {
            return (minProfit <= 0) ? 1 : 0;
        }
        minProfit = mx(0, minProfit);
        if (dp[idx][peopleLeft][minProfit] != null) {
            return dp[idx][peopleLeft][minProfit];
        }
        int pick = solve(group,profit,idx + 1,peopleLeft - group[idx],minProfit - profit[idx]);
        int notPick = solve(group,profit,idx + 1,peopleLeft,minProfit);

        return dp[idx][peopleLeft][minProfit] =
                (int)((pick + (long)notPick) % MOD);
    }
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int m = group.length;
        dp = new Integer[m][n + 1][minProfit + 1];
        return solve(group, profit, 0, n, minProfit);
    }
}


