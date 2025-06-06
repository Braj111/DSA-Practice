class Solution {
    ArrayList<Integer> search(String pat, String txt) {
        int d = 256;
        int q = 101;
        int M = pat.length();
        int N = txt.length();
        int p = 0;
        int t = 0;
        int h = 1;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < M - 1; i++)
            h = (h * d) % q;
        for (int i = 0; i < M; i++) {
            p = (d * p + pat.charAt(i)) % q;
            t = (d * t + txt.charAt(i)) % q;
        }
        for (int i = 0; i <= N - M; i++) {
            if (p == t) {
                boolean match = true;
                for (int j = 0; j < M; j++) {
                    if (txt.charAt(i + j) != pat.charAt(j)) {
                        match = false;
                        break;
                    }
                }
                if (match)
                    ans.add(i + 1); 
            }
            if (i < N - M) {
                t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + M)) % q;
                if (t < 0)
                    t += q;
            }
        }
        return ans;
    }
}