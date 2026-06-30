class Solution {
    public int minInsAndDel(int[] a, int[] b) {
        // code here
        int n = a.length;
        int m = b.length;
        HashMap<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < m; i++) {
            mp.put(b[i], i);
        }
        ArrayList<Integer> v = new ArrayList<>();
        for (int x : a) {
            if (mp.containsKey(x)) {
                v.add(mp.get(x));
            }
        }
        ArrayList<Integer> lis = new ArrayList<>();
        for (int x : v) {
            int index = Collections.binarySearch(lis, x);
            if (index < 0) {
                index = - (index + 1);
            }
            if (index == lis.size()) {
                lis.add(x);
            }
            else {
                lis.set(index, x);
            }
        }

        int len = lis.size();
        int ans = (n - len) + (m - len);

        return ans;
    }
}