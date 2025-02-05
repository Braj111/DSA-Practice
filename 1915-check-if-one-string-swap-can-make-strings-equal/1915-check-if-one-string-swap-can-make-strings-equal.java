class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int res = 0; 
        char firstCharFromS1 = 0, firstCharFromS2 = 0; 
        for (int i = 0; i < s1.length(); ++i) {
            char charFromS1 = s1.charAt(i), charFromS2 = s2.charAt(i); 
            if (charFromS1 != charFromS2) {
                if (++res > 2 || 
                    (res == 2 && !(charFromS1 == firstCharFromS2 && charFromS2 == firstCharFromS1))) {
                    return false;
                }
                firstCharFromS1 = charFromS1;
                firstCharFromS2 = charFromS2;
            }
        }
        return res != 1;
    }
}