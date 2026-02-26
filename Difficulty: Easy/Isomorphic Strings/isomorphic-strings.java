class Solution {
    public boolean areIsomorphic(String s1, String s2) {
        // code here
        HashMap<Character, Character> m1 = new HashMap<>();
        HashSet<Character> set2 = new HashSet<>();

        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i), c2 = s2.charAt(i);
            if (m1.containsKey(c1)) {
                if (m1.get(c1) != c2) return false;
              
            } else {
                if (set2.contains(c2)) return false;
                m1.put(c1, c2);
                set2.add(c2);
            }
        }
        return true;
    }
}