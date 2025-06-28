class Solution {
    public static ArrayList<Integer> countLessEq(int a[], int b[]) {
        // code here
         int n = a.length, m = b.length;
        
        int maxi = 0;
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(0);
        }
        
        for(int i=0;i<m;i++){
            maxi = Math.max(maxi, b[i]);
        }
        int[] cnt = new int[maxi+1];
        for (int i = 0; i <= maxi; i++) {
            cnt[i] = 0;
        }
        for (int i = 0; i < m; i++) {
            cnt[b[i]]++;
        }
        for (int i = 1; i <= maxi; i++) {
            cnt[i] += cnt[i - 1];
        }
        for (int i = 0; i < n; i++) {
            res.set(i, cnt[Math.min(a[i],maxi)]);
        }

        return res;
    }
}