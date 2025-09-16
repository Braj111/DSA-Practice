class Solution {
    public int floorDiv(int a, int b) {
        if (a * b < 0 && a % b != 0)
            return (a / b) - 1;
        return a / b;
    }
    
    public int evaluatePostfix(String[] arr) {
        Stack<Integer> st = new Stack<>();

        for (String token : arr) {
            if (Character.isDigit(token.charAt(0)) || 
                (token.length() > 1 && token.charAt(0) == '-')) {
                st.push(Integer.parseInt(token));
            } 
            else {
                int val1 = st.pop();
                int val2 = st.pop();

                if (token.equals("+")) st.push(val2 + val1);
                else if (token.equals("-")) st.push(val2 - val1);
                else if (token.equals("*")) st.push(val2 * val1);
                else if (token.equals("/")) st.push(floorDiv(val2, val1));
                else if (token.equals("^")) st.push((int)Math.pow(val2, val1));
            }
        }
        return st.pop();
    }
}