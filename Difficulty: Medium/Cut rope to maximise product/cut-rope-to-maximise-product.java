class Solution {
    public int power(int base, int exp) {
        int result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1)
                result *= base;
            base *= base;
            exp >>= 1;
        }

        return result;
    }
    public int maxProduct(int n) {
        // code here
        if (n == 2 || n == 3)
            return n - 1;
        int count3 = n / 3;
        int rem = n % 3;
        if (rem == 1) {
            count3 -= 1;
            rem = 4; 
        }
        int product = power(3, count3);
        if (rem == 2 || rem == 4)
            product *= rem;

        return product;
    }
}