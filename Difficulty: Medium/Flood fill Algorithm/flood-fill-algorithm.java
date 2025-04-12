//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int m = Integer.parseInt(br.readLine().trim());
            int[][] image = new int[n][m];
            for (int i = 0; i < n; i++) {
                String[] S2 = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) image[i][j] = Integer.parseInt(S2[j]);
            }
            int sr = Integer.parseInt(br.readLine().trim());
            int sc = Integer.parseInt(br.readLine().trim());
            int newColor = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            int[][] ans = obj.floodFill(image, sr, sc, newColor);
            for (int i = 0; i < ans.length; i++) {
                for (int j = 0; j < ans[i].length; j++)
                    System.out.print(ans[i][j] + " ");
                System.out.println();
            }

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    private static final int[][] directions = {
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return image;
        }

        int oldColor = image[sr][sc];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc});
        image[sr][sc] = newColor;

        while (!q.isEmpty()) {
            int[] front = q.poll();
            int x = front[0], y = front[1];

            for (int[] direction : directions) {
                int nx = x + direction[0];
                int ny = y + direction[1];

                if (nx >= 0 && nx < image.length && 
                    ny >= 0 && ny < image[0].length && 
                    image[nx][ny] == oldColor) {

                    image[nx][ny] = newColor;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        return image;
    }

    public static void main(String[] args) {
        int[][] image = {
            {1, 1, 1, 0},
            {0, 1, 1, 1},
            {1, 0, 1, 1}
        };
        int sr = 1, sc = 2;
        int newColor = 2;
        int[][] result = floodFill(image, sr, sc, newColor);

        for (int[] row : result) {         
            for (int pixel : row) {       
                System.out.print(pixel + " ");  
            }
            System.out.println();        
        }
    }
}
