class Solution {
    public static String caseSort(String s) {
        // code here
         int n = s.length();
        
        char[] lower = new char[n];
        char[] upper = new char[n];

        int lowerIndex = 0, upperIndex = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                lower[lowerIndex++] = ch;
            } else {
                upper[upperIndex++] = ch;
            }
        }
        Arrays.sort(lower, 0, lowerIndex);
        Arrays.sort(upper, 0, upperIndex);

        StringBuilder result = new StringBuilder(s);
        lowerIndex = 0;
        upperIndex = 0;
        for (int i = 0; i < n; i++) {
            if (Character.isLowerCase(s.charAt(i))) {
                result.setCharAt(i, lower[lowerIndex++]);
            } else {
                result.setCharAt(i, upper[upperIndex++]);
            }
        }

        return result.toString();
    }
}