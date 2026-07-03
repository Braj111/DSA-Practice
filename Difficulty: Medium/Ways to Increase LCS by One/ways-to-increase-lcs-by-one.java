class Solution {
    public int waysToIncreaseLCSBy1(String s1, String s2) {
        // code here
        int n1 = s1.length();
        int n2 = s2.length();

        int M = 26;
        List<List<Integer>> position = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            position.add(new ArrayList<>());
        }

        for (int i = 1; i <= n2; i++)
            position.get(s2.charAt(i - 1) - 'a').add(i);
        int[][] lcsl = new int[n1 + 2][n2 + 2];
        int[][] lcsr = new int[n1 + 2][n2 + 2];

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    lcsl[i][j] = 1 + lcsl[i - 1][j - 1];
                else
                    lcsl[i][j] = Math.max(lcsl[i - 1][j], lcsl[i][j - 1]);
            }
        }
        for (int i = n1; i >= 1; i--) {
            for (int j = n2; j >= 1; j--) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    lcsr[i][j] = 1 + lcsr[i + 1][j + 1];
                else
                    lcsr[i][j] = Math.max(lcsr[i + 1][j], lcsr[i][j + 1]);
            }
        }

        int ways = 0;
        int baseLCS = lcsl[n1][n2];
        for (int i = 0; i <= n1; i++) {
            for (int c = 0; c < 26; c++) {

                List<Integer> posList = position.get(c);
                for (int j = 0; j < posList.size(); j++) {
                    int p = posList.get(j);

                    
                    if (lcsl[i][p - 1] + lcsr[i + 1][p + 1] == baseLCS) {
                        ways++;
                        break;
                    }
                }
            }
        }

        return ways;
    }
}