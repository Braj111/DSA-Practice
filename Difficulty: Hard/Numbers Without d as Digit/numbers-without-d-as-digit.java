class Solution {
    public int countWithout(int n, int d) {
        // code here
        if (n <= 0)
            return 0;
        String s = String.valueOf(n);
        int length = s.length();
        int[][] dp = new int[2][2];
        for (int tight = 0; tight < 2; tight++)
            for (int started = 0; started < 2; started++)
                dp[tight][started] = started;
        for (int pos = length - 1; pos >= 0; pos--) {
            int[][] newDp = new int[2][2];

            for (int tight = 0; tight < 2; tight++) {
                for (int started = 0; started < 2; started++) {
                    int limit = (tight == 1) ? (s.charAt(pos) - '0') : 9;
                    int total = 0;
                    for (int digit = 0; digit <= limit; digit++) {
                        int willStart = (started == 1 || digit != 0) ? 1 : 0;

                        if (willStart == 1 && digit == d)
                            continue;

                        int newTight = (tight == 1 && digit == limit) ? 1 : 0;
                        total += dp[newTight][willStart];
                    }

                    newDp[tight][started] = total;
                }
            }

            dp = newDp;
        }

        return dp[1][0];
    }
}