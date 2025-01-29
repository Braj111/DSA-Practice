class Solution {
    private int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[1010];
        for(int i=0; i<1010; i++){
            parent[i]=i;
        }
        for(int[] e: edges){
            int n1=e[0];
            int n2=e[1];
            if(find(n1)==find(n2)) return e;
            parent[find(n1)]= find(n2);
        }

        return null;
    }
    private int find(int x){
        if(parent[x]!=x) parent[x]=find(parent[x]);
        return parent[x];
    }
}