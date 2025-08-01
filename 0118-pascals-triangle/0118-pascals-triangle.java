class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle= new ArrayList<>();
        triangle.add(List.of(1));
        for(int rowIndex=1;rowIndex<numRows; rowIndex++){
            List<Integer> row =  new ArrayList<>();
            row.add(1);
             for (int j=0; j<triangle.get(rowIndex-1).size()-1; j++) {
                row.add(triangle.get(rowIndex-1).get(j)+triangle.get(rowIndex-1).get(j+1));
            }
            row.add(1);
            triangle.add(row);
        }
        return triangle;
    }
}