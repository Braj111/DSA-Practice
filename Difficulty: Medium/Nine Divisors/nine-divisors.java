class Solution {
    public static int countNumbers(int n) {
        // code here
        int c = 0;
        int limit = (int)Math.sqrt(n);

        int[] prime = new int[limit + 1];
        for (int i = 1; i <= limit; i++)
            prime[i] = i;
        for (int i = 2; i * i <= limit; i++) {
            if (prime[i] == i) {
                for (int j = i * i; j <= limit; j += i)
                    if (prime[j] == j)
                        prime[j] = i;
            }
        }
        for (int i = 2; i <= limit; i++) {
            int p = prime[i];
            int q = prime[i / prime[i]];
            if (p * q == i && q != 1 && p != q) {
                c += 1;
            }
            else if (prime[i] == i && Math.pow(i, 8) <= n) {
                c += 1;
            }
        }
        return c;
    }
}