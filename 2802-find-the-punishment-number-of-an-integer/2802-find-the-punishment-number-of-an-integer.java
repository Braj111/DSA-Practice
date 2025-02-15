class Solution {
    public int punishmentNumber(int n) {
        int sum = 0; 
        for (int i = 1; i <= n; ++i) {
            int square = i * i; 
            if (isSpecial(Integer.toString(square), 0, i)) {
                sum += square; 
            }
        }
        return sum; 
    }
    private boolean isSpecial(String numStr, int startIndex, int remaining) {
        int length = numStr.length();
        if (startIndex >= length) {
            return remaining == 0;
        }
        int currentNumber = 0;
        for (int j = startIndex; j < length; ++j) {
            currentNumber = currentNumber * 10 + (numStr.charAt(j) - '0');
            if (currentNumber > remaining) {
                break;
            }
            if (isSpecial(numStr, j + 1, remaining - currentNumber)) {
                return true;
            }
        }
        return false; 
    }
}