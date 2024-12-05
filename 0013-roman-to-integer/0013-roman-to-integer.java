class Solution {
    public int romanToInt(String s) {
        int num = 0;
        HashMap<Character, Integer> roman = new HashMap<>() {
            {
                put('I', 1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
            }
        };
        s+='B';
        if(s.length()==1) return roman.get(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if ((s.charAt(i) == 'V' || s.charAt(i) == 'X') && s.charAt(i-1) == 'I') {
                num += roman.get(s.charAt(i)) - roman.get(s.charAt(i - 1));
                i+=1;
            }else if ((s.charAt(i) == 'L' || s.charAt(i) == 'C') && s.charAt(i-1) == 'X') {
                num += roman.get(s.charAt(i)) - roman.get(s.charAt(i - 1));
                i+=1;
            } else if ((s.charAt(i) == 'D' || s.charAt(i) == 'M') && s.charAt(i-1) == 'C') {
                num += roman.get(s.charAt(i)) - roman.get(s.charAt(i - 1));
                i+=1;
            }else{
                num += roman.get(s.charAt(i-1));
            }
        }
        return num;
    }
}