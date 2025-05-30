class Solution {
    private int nodeCount; 
    private List<Integer>[] graph; 
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        nodeCount = edges.length;
        graph = new List[nodeCount];
        Arrays.setAll(graph, x -> new ArrayList<>());
        for (int i = 0; i < nodeCount; ++i) {
            if (edges[i] != -1) {
                graph[i].add(edges[i]);
            }
        }
        int[] distancesFromNode1 = dijkstra(node1);
        int[] distancesFromNode2 = dijkstra(node2);
        int minDistance = Integer.MAX_VALUE;
        int closestNode = -1;
        for (int i = 0; i < nodeCount; ++i) {
            int maxOfBothDistances = Math.max(distancesFromNode1[i], distancesFromNode2[i]);
            if (maxOfBothDistances < minDistance) {
                minDistance = maxOfBothDistances;
                closestNode = i;
            }
        }
        return closestNode;
    }
    private int[] dijkstra(int startNode) {
        int[] distances = new int[nodeCount];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[startNode] = 0; 
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        priorityQueue.offer(new int[]{0, startNode});
      
        while (!priorityQueue.isEmpty()) {
            int[] current = priorityQueue.poll();
            int currentNode = current[1];
            for (int neighbor : graph[currentNode]) {
                if (distances[neighbor] > distances[currentNode] + 1) {
                    distances[neighbor] = distances[currentNode] + 1;
                    priorityQueue.offer(new int[]{distances[neighbor], neighbor});
                }
            }
        }
      
        return distances; 
    }
}
