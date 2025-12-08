class Solution {
    public class Pair {
        String first;
        Integer second;

        Pair(String first, Integer second) {
            this.first = first;
            this.second = second;
        }
    }

    public String matrixChainOrder(int arr[]) {
        int n = arr.length;
        Pair[][] dp = new Pair[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = new Pair("", 0);
            }
        }

        for (int i = 0; i < n - 1; i++) {
            dp[i][i] = new Pair("" + (char) ('A' + i), 0);
        }

        for (int len = 2; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = i + len - 1;
                int cost = Integer.MAX_VALUE;
                String str = "";

                for (int k = i; k < j; k++) {
                    int currCost = dp[i][k].second + dp[k + 1][j].second
                            + arr[i] * arr[k + 1] * arr[j + 1];

                    if (currCost < cost) {
                        cost = currCost;
                        str = "(" + dp[i][k].first + dp[k + 1][j].first + ")";
                    }
                }

                dp[i][j] = new Pair(str, cost);
            }
        }

        return dp[0][n - 2].first;
    }
}
