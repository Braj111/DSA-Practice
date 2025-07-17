class Solution {
     public static ArrayList<int[]> primeFactors(int num) {
        ArrayList<int[]> factors = new ArrayList<>();
        int count = 0;
        while (num % 2 == 0) {
            num /= 2;
            count++;
        }
        if (count > 0)
            factors.add(new int[]{2, count});
        for (int i = 3; i * i <= num; i += 2) {
            count = 0;
            while (num % i == 0) {
                num /= i;
                count++;
            }
            if (count > 0)
                factors.add(new int[]{i, count});
        }
        if (num > 1)
            factors.add(new int[]{num, 1});
        return factors;
    }
    public static int legendre(int n, int p) {
        int count = 0;
        for (long power = p; power <= n; power *= p) {
            count += n / power;
        }
        return count;
    }
    public static int maxKPower(int n, int k) {
        ArrayList<int[]> factors = primeFactors(k);
        int result = Integer.MAX_VALUE;
        for (int[] factor : factors) {
            int prime = factor[0];
            int expInK = factor[1];
            int countInFact = legendre(n, prime);
            result = Math.min(result, countInFact / expInK);
        }
        return result;
    }
}