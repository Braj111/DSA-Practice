class Solution {
    public static ArrayList<Integer> subsetXOR(int n) {
        int total = 0;
        for (int i = 1; i <= n; i++) total ^= i;
        int t = total ^ n;

        ArrayList<Integer> remove = new ArrayList<>();

        if (t != 0) {
            if (t <= n) {
                remove.add(t);
            } else {
                for (int b = n; b >= 1; b--) {
                    int a = (b ^ t);
                    if (a < b && a >= 1 && a <= n) {
                        remove.add(a);
                        remove.add(b);
                        break;
                    }
                }
            }
        }

        boolean[] bad = new boolean[n + 1];
        for (int x : remove) bad[x] = true;

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (!bad[i]) ans.add(i);
        }
        return ans;
    }
}
