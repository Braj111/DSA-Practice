class Solution {
    public static boolean
    isSubsequence(String word, List<List<Integer> > pos)
    {

        int prevIndex = -1;

        for (char ch : word.toCharArray()) {
            List<Integer> indices = pos.get(ch - 'a');
            int it = -1;
            for (int i = 0; i < indices.size(); i++) {
                if (indices.get(i) > prevIndex) {
                    it = indices.get(i);
                    break;
                }
            }
            if (it == -1) {
                return false;
            }
            prevIndex = it;
        }

        return true;
    }

    public static String findLongestWord(String s,List<String> d)
    {
        List<List<Integer> > pos = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            pos.add(new ArrayList<>());
        }

        for (int i = 0; i < s.length(); i++) {
            pos.get(s.charAt(i) - 'a').add(i);
        }

        String res = "";

        for (String word : d) {
            if (word.length() < res.length()) {
                continue;
            }
            if (isSubsequence(word, pos)) {
                if (word.length() > res.length()
                    || (word.length() == res.length()
                        && word.compareTo(res) < 0)) {

                    res = word;
                }
            }
        }

        return res;
    }
}