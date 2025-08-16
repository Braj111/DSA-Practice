class Solution {
     static boolean myCompare(String s1, String s2) {
        return (s1 + s2).compareTo(s2 + s1) > 0;
    }
    static String findLargest(int[] arr) {
        ArrayList<String> numbers = new ArrayList<>();
        for (int ele : arr) {
            numbers.add(Integer.toString(ele));
        }
        Collections.sort(numbers, (s1, s2) -> myCompare(s1, s2) ? -1 : 1);
        if (numbers.get(0).equals("0")) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        for (String num : numbers) {
            res.append(num);
        }

        return res.toString();
    }
}