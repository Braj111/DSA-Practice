class Solution {
    private List<Integer>[] graph;
    private int[] profitAtNode;
    private int[] timeStamps;
    private int maximumProfit = Integer.MIN_VALUE;

    public int mostProfitablePath(int[][] edges, int bobStartNode, int[] profit) {
        int n = edges.length + 1;
        graph = new List[n];
        timeStamps = new int[n];
        profitAtNode = profit;
        Arrays.setAll(graph, k -> new ArrayList<>());
        Arrays.fill(timeStamps, n);
        for (var edge : edges) {
            int nodeA = edge[0], nodeB = edge[1];
            graph[nodeA].add(nodeB);
            graph[nodeB].add(nodeA);
        }
        dfsAssignTimestamps(bobStartNode, -1, 0);
        timeStamps[bobStartNode] = 0;  
        dfsCalculateProfit(0, -1, 0, 0);
        return maximumProfit;
    }
    private boolean dfsAssignTimestamps(int currentNode, int parent, int timestamp) {
        if (currentNode == 0) {
            timeStamps[currentNode] = Math.min(timeStamps[currentNode], timestamp);
            return true;
        }
        for (int nextNode : graph[currentNode]) {
            if (nextNode != parent && dfsAssignTimestamps(nextNode, currentNode, timestamp + 1)) {
                timeStamps[nextNode] = Math.min(timeStamps[nextNode], timestamp + 1);
                return true;
            }
        }
        return false;
    }
    private void dfsCalculateProfit(int currentNode, int parent, int timestamp, int currentProfit) {
        if (timestamp == timeStamps[currentNode]) {
            currentProfit += profitAtNode[currentNode] >> 1;
        } else if (timestamp < timeStamps[currentNode]) {
            currentProfit += profitAtNode[currentNode];
        }
        if (graph[currentNode].size() == 1 && graph[currentNode].get(0) == parent) {
            maximumProfit = Math.max(maximumProfit, currentProfit);
            return;
        }
        for (int nextNode : graph[currentNode]) {
            if (nextNode != parent) {
                dfsCalculateProfit(nextNode, currentNode, timestamp + 1, currentProfit);
            }
        }
    }
}
