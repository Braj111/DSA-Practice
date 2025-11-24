import java.util.*;

class Solution {

    static class DSU {
        int[] parent, rank;
        DSU(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i=0;i<n;i++) parent[i]=i;
        }
        int find(int x){
            if(parent[x]!=x) parent[x]=find(parent[x]);
            return parent[x];
        }
        boolean union(int a,int b){
            a=find(a); b=find(b);
            if(a==b) return false;
            if(rank[a]<rank[b]) parent[a]=b;
            else if(rank[b]<rank[a]) parent[b]=a;
            else{
                parent[b]=a;
                rank[a]++;
            }
            return true;
        }
    }

    public int secondMST(int V, int[][] edges) {
        Arrays.sort(edges, (a,b)->a[2]-b[2]);
        DSU dsu = new DSU(V);
        List<int[]> mstEdges = new ArrayList<>();
        int mstWeight = 0;

        for(int[] e : edges){
            if(dsu.union(e[0], e[1])){
                mstWeight += e[2];
                mstEdges.add(e);
            }
        }
        if(mstEdges.size() != V-1) return -1;

        int ans = Integer.MAX_VALUE;

        for(int[] removed : mstEdges){
            DSU dsu2 = new DSU(V);
            int w = 0, count = 0;

            for(int[] e : edges){
                if(e == removed) continue;
                if(dsu2.union(e[0], e[1])){
                    w += e[2];
                    count++;
                    if(count == V-1) break;
                }
            }
            if(count == V-1 && w > mstWeight) ans = Math.min(ans, w);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
