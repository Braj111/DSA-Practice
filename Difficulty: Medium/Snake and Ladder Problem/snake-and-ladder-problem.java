class Solution {
    public int minThrows(int n, int[] lad, int[] sn) {
        // code here
        int[] moves = new int[n * n + 1];
        Arrays.fill(moves, -1);
        boolean[] vis = new boolean[n * n + 1];
        for (int i = 0; i < lad.length; i += 2) {
            moves[lad[i]] = lad[i + 1];
        }

        for (int i = 0; i < sn.length; i += 2) {
            moves[sn[i]] = sn[i + 1];
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{1, 0});
        vis[1] = true;

        int[] cur;

        while (!q.isEmpty()) {

            cur = q.poll();

            int pos = cur[0];
            int dist = cur[1];

            if (pos == n * n) {
                return dist;
            }
            for (int nxt = pos + 1;
                 nxt <= pos + 6 && nxt <= n * n;
                 nxt++) {

                if (!vis[nxt]) {

                    vis[nxt] = true;

                    int dest =
                        (moves[nxt] == -1) ? nxt : moves[nxt];

                    q.offer(new int[]{dest, dist + 1});
                }
            }
        }

        return -1;
    }
}