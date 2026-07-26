class Solution {
    public ArrayList<ArrayList<Integer>> levelSort(int[] arr) {
        // code here
        ArrayList<ArrayList<Integer>> sortedLevels = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int value : arr) {
            list.add(value);
        }
        int currentIndex = 0;
        int levelNumber = 1;
        while (currentIndex < list.size()) {
            int levelEnd = (1 << levelNumber) - 1;
            levelEnd = Math.min(levelEnd, list.size());
            Collections.sort(list.subList(currentIndex, levelEnd));
            ArrayList<Integer> currentLevel = new ArrayList<>();
            for (int i = currentIndex; i < levelEnd; i++) {
                currentLevel.add(list.get(i));
            }
            sortedLevels.add(currentLevel);
            currentIndex = levelEnd;
            levelNumber++;
        }
        
        return sortedLevels;
    }
}