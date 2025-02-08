class NumberContainers {
    private final Map<Integer, Integer> indexToNumberMap = new HashMap<>();
    private final Map<Integer, TreeSet<Integer>> numberToIndicesMap = new HashMap<>();
    
    public NumberContainers() {

    }
    public void change(int index, int number) {
        if (indexToNumberMap.containsKey(index)) {
            int currentNumber = indexToNumberMap.get(index);
            TreeSet<Integer> indicesSet = numberToIndicesMap.get(currentNumber);
            indicesSet.remove(index);
            if (indicesSet.isEmpty()) {
                numberToIndicesMap.remove(currentNumber);
            }
        }
        indexToNumberMap.put(index, number);
        numberToIndicesMap.computeIfAbsent(number, k -> new TreeSet<>()).add(index);
    }
    public int find(int number) {
        return numberToIndicesMap.containsKey(number) ? numberToIndicesMap.get(number).first() : -1;
    }
}
/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */