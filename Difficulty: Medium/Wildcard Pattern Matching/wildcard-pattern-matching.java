class Solution {
    public boolean wildCard(String txt, String pat) {
        // code here
        int n = txt.length();
        int m = pat.length();
        int i = 0, j = 0, startIndex = -1, match = 0;

        while (i < n) {
            if (j < m && (pat.charAt(j) == '?' 
                          	|| pat.charAt(j) == txt.charAt(i))) {
                i++;
                j++;
            }

            else if (j < m && pat.charAt(j) == '*') {
                startIndex = j;
                match = i;
                j++;
            }

            else if (startIndex != -1) {
                j = startIndex + 1;
                match++;
                i = match;
            }

            else {
                return false;
            }
        }
        while (j < m && pat.charAt(j) == '*') {
            j++;
        }
        return j == m;
    }
}