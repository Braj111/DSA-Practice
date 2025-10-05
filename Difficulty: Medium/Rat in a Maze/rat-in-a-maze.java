import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public ArrayList<String> ratInMaze(int[][] maze) {
        ArrayList<String> result = new ArrayList<>();
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        if (maze[0][0] == 1) {
            findPaths(maze, 0, 0, visited, "", result);
        }
        Collections.sort(result);
        return result;
    }

    private void findPaths(int[][] maze, int x, int y, boolean[][] visited, String path, ArrayList<String> result) {
        int n = maze.length;
        if (x == n - 1 && y == n - 1) {
            result.add(path);
            return;
        }
        visited[x][y] = true;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        char[] moves = {'U', 'D', 'L', 'R'};
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (isSafe(maze, newX, newY, visited)) {
                findPaths(maze, newX, newY, visited, path + moves[i], result);
            }
        }
        visited[x][y] = false;
    }

    private boolean isSafe(int[][] maze, int x, int y, boolean[][] visited) {
        int n = maze.length;
        return (x >= 0 && y >= 0 && x < n && y < n && maze[x][y] == 1 && !visited[x][y]);
    }
}
