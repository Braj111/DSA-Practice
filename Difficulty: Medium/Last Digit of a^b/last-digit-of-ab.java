class Solution {
    public int modulo(int d, String b)
    {
        int mod = 0;
        for (int i = 0; i < b.length(); i++)
            mod = (mod * 10 + b.charAt(i) - '0') % d;

        return mod;
    }
    public int getLastDigit(String a, String b) {
        // code here
        int n = a.length(), m = b.length();
        if (m == 1 && b.charAt(0) == '0')
            return 1;
        if (n == 1 && a.charAt(0) == '0')
            return 0;
        int exp = (modulo(4, b) == 0) ? 4 : modulo(4, b);
        int res = (int)Math.pow(a.charAt(n - 1) - '0', exp);
        return res % 10;
    }
};