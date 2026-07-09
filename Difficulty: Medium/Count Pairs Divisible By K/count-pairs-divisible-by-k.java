class Solution {
    public int countKdivPairs(int[] arr, int k) {
        // code here
        int[] freq = new int[k];
        Arrays.fill(freq, 0);
        for (int i = 0; i < arr.length; i++)
            ++freq[arr[i] % k];
        int res = freq[0] * (freq[0] - 1) / 2;
        for (int i = 1; i <= k / 2 && i!= (k - i); i++)
            res += freq[i] * freq[k - i];
        if (k % 2 == 0)
            res += (freq[k / 2] * (freq[k / 2] - 1) / 2);

        return res;
    }
}