class Solution {
   
    static class Result {
            int node;
            int distance;

            Result(int node, int distance)
            {
                this.node = node;
                this.distance = distance;
            }
        }
        static Result bfs(ArrayList<ArrayList<Integer> > adj,
                          int start)
        {
            int n = adj.size();

            int[] dist = new int[n];
            Arrays.fill(dist, -1);

            Queue<Integer> q = new LinkedList<>();

            dist[start] = 0;
            q.add(start);

            int farthestNode = start;
            int farthestDist = 0;

            while (!q.isEmpty()) {

                int node = q.poll();

                for (int nextValue : adj.get(node)) {
                    int next = nextValue - 1;

                    if (dist[next] == -1) {

                        dist[next] = dist[node] + 1;
                        q.add(next);
                        if (dist[next] > farthestDist) {
                            farthestDist = dist[next];
                            farthestNode = next;
                        }
                    }
                }
            }

            return new Result(farthestNode, farthestDist);
        }

        static int partyHouse(ArrayList<ArrayList<Integer> > adj)
        {
            Result first = bfs(adj, 0);
            int diameterEnd = first.node;
            Result second = bfs(adj, diameterEnd);
            int diameter = second.distance;
            return (diameter + 1) / 2;
        }
}