class Solution {
   public static int gcd(int a, int b)
       {
           if (b == 0)
               return a;
           return gcd(b, a % b);
       }

       public static int pairCount(int x, int y)
       {
           int n = 0, res = 0;
           if (y % x == 0)
               n = y / x;
           if (n == 1)
               res = 1;
           for (int i = 1; i <= Math.sqrt(n); i++) {
               if (n % i == 0) {
                   int j = n / i;
                   if (i != j && gcd(x * i, x * j) == x)
                       res += 2;
               }
           }

           return res;
       }
}