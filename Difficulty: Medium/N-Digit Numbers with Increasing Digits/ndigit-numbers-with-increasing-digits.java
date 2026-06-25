class Solution {
    public void generateNumbers(int remainingDigits,int currentDigit,
                                int currentNumber, ArrayList<Integer> result)
    {
        if (remainingDigits == 0) {
            result.add(currentNumber);
            return;
        }
        for (int nextDigit = currentDigit + 1; nextDigit <= 9; nextDigit++) {
            generateNumbers(remainingDigits - 1, nextDigit, 
            currentNumber * 10 + nextDigit, result);
        }
    }

    public ArrayList<Integer> increasingNumbers(int n)
    {
        ArrayList<Integer> result = new ArrayList<>();
        if (n == 1) {
            for (int digit = 0; digit <= 9; digit++)
                result.add(digit);

            return result;
        }
        if (n > 9)
            return result;
        for (int firstDigit = 1; firstDigit <= 9;
             firstDigit++) {
            generateNumbers(n - 1, firstDigit, firstDigit,
                            result);
        }

        return result;
    }

}
