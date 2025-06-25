class Solution {
    boolean sameFreq(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        Map<Integer, Integer> freqCount = new HashMap<>();

        for (int f : freq) {
            if (f > 0) {
                freqCount.put(f, freqCount.getOrDefault(f, 0) + 1);
            }
        }
        if (freqCount.size() == 1) {
            return true;
        }

        if (freqCount.size() == 2) {
            Iterator<Map.Entry<Integer, Integer>> it = 
            freqCount.entrySet().iterator();
            
            Map.Entry<Integer, Integer> entry1 = it.next();
            Map.Entry<Integer, Integer> entry2 = it.next();

            int freq1 = entry1.getKey(), count1 = entry1.getValue();
            int freq2 = entry2.getKey(), count2 = entry2.getValue();
            if ((freq1 == 1 && count1 == 1) ||
            (freq2 == 1 && count2 == 1)) {
                return true;
            }
            if (Math.abs(freq1 - freq2) == 1 &&
               ((count1 == 1 && freq1 > freq2) || 
               (count2 == 1 && freq2 > freq1))) {
                return true;
            }
        }
        return false;
    }
}