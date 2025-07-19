class Solution {
     public static int fact(int n) {
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
        }
        return res;
    }
    public static int vowelCount(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        String vowels = "aeiou";
        for (char c : s.toCharArray()) {
            if (vowels.indexOf(c) != -1) {
                freq.put(c, freq.getOrDefault(c, 0) + 1);
            }
        }
        if (freq.isEmpty()) return 0;
        int choices = 1;
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            choices *= entry.getValue();
        }
        int dist = freq.size();
        int res = choices * fact(dist);
        return res;
    }

}