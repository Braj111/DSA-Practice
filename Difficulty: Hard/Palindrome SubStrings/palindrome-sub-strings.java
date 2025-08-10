class Manacher {
    ArrayList<Integer> p;
    String ms;
    Manacher(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append("@");

        for (char c : s.toCharArray()) {
            sb.append("#");
            sb.append(c);
        }

        sb.append("#$");
        ms = sb.toString();
        runManacher();
    }
    void runManacher() {
        int n = ms.length();
        p = new ArrayList<>(Collections.nCopies(n, 0));

        int l = 0;
        int r = 0;

        for (int i = 1; i < n - 1; i++) {
            int mirror = r + l - i;
            if (i < r) {
                p.set(i, Math.min(r - i, p.get(mirror)));
            }
            while (ms.charAt(i + 1 + p.get(i)) == ms.charAt(i - 1 - p.get(i))) {
                p.set(i, p.get(i) + 1);
            }
            if (i + p.get(i) > r) {
                l = i - p.get(i);
                r = i + p.get(i);
            }
        }
    }
    int getLongest(int cen, int odd) {
        int pos = 2 * cen + 2 + (odd == 0 ? 1 : 0);
        if (pos >= p.size()) {
            return 0;
        }
        return p.get(pos);
    }
    boolean check(int l, int r) {
        int len = r - l + 1;
        int center = (r + l) / 2;
        int isOdd = len % 2;
        return len <= getLongest(center, isOdd);
    }
}
class Solution {
    public static int countPS(String s) {
        Manacher m = new Manacher(s);
        int total = 0;

        for (int i = 0; i < m.p.size(); i++) {
            total += (m.p.get(i) + 1) / 2;
        }
        return total - s.length();
    }
}