class Solution {
    class Pair{
        int first;
        int second;
        Pair(int first, int second ){
            this.first=first;
            this.second=second;
        }
    }
    class Tripple{
        int first;
        Pair second;
        Tripple(int first, Pair second ){
            this.first=first;
            this.second=second;
        }
    }
    public boolean isValid(int x, int y, int m, int n){
        return x>=0 && x<m && y>=0 && y<n;
    }
    public int[] maxPoints(int[][] grid, int[] queries) {
        Set<Integer> sortedQueries = new TreeSet<>();
        for(int q: queries) sortedQueries.add(q);

        Map<Integer, Integer> queryCount = new HashMap<>();
        PriorityQueue<Tripple> minheap = new PriorityQueue<>((a,b)->a.first-b.first);

        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int[] dir= {-1,0,1,0,-1};

        //Process 1st grid element
        minheap.add(new Tripple(grid[0][0],new Pair(0,0)));
        visited[0][0]=true;

        int count=0;
        for(int q:sortedQueries){
            while(!minheap.isEmpty()){
                Tripple e = minheap.poll();
                int val= e.first;
                int x=e.second.first;
                int y=e.second.second;

                if(val>=q){
                    minheap.add(e);
                    break;
                }
                count++;

                for(int i=0; i<4; i++){
                    int newX = x+dir[i];
                    int newY= y+dir[i+1];
                    if(isValid(newX,newY,m,n) && !visited[newX][newY]){
                        visited[newX][newY]=true;
                        minheap.add(new Tripple(grid[newX][newY], new Pair(newX,newY)));
                    }
                }
            }
            queryCount.put(q, count);
        }
        int[] res= new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = queryCount.get(queries[i]);
        }
        return res;
    }
}