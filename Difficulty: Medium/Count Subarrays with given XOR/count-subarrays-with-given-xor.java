class Solution {
    public long subarrayXor(int arr[], int k) {
        // code here
        int res = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();

        int prefXOR = 0;

        for (int val : arr) {
            prefXOR ^= val;
            res += mp.getOrDefault(prefXOR ^ k, 0);
            if (prefXOR == k)
                res++;
            mp.put(prefXOR, mp.getOrDefault(prefXOR, 0) + 1);
        }
        return res;
    }
}