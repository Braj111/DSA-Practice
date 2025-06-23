class Solution {

    static String addString(String s1, String s2) {
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        int carry = 0;
        StringBuilder res = new StringBuilder();

        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            if (i >= 0) sum += (s1.charAt(i--) - '0');
            if (j >= 0) sum += (s2.charAt(j--) - '0');
            res.append(sum % 10);
            carry = sum / 10;
        }

        while (res.length() > 0 && res.charAt(res.length() - 1) == '0')
            res.deleteCharAt(res.length() - 1);

        res.reverse();
        return res.length() == 0 ? "0" : res.toString();
    }

    static String minSum(int[] arr) {
        int[] count = new int[10];
        for (int num : arr) {
            count[num]++;
        }

        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        boolean firstNum = true;

        for (int digit = 0; digit < 10; digit++) {
            while (count[digit]-- > 0) {
                if (firstNum) {
                    if (!(s1.length() == 0 && digit == 0))
                        s1.append(digit);
                    firstNum = false;
                } else {
                    if (!(s2.length() == 0 && digit == 0))
                        s2.append(digit);
                    firstNum = true;
                }
            }
        }

        if (s1.length() == 0) s1.append("0");
        if (s2.length() == 0) s2.append("0");

        return addString(s1.toString(), s2.toString());
    }
}
