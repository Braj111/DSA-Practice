//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            // First array input (arr)
            String[] str1 = br.readLine().trim().split(
                " "); // Read the first line and split by spaces
            int n = str1.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] =
                    Integer.parseInt(str1[i]); // Convert each element to an integer
            }

            // Second array input (dep)
            String[] str2 = br.readLine().trim().split(
                " "); // Read the second line and split by spaces
            int m = str2.length;
            int[] dep = new int[m];
            for (int i = 0; i < m; i++) {
                dep[i] =
                    Integer.parseInt(str2[i]); // Convert each element to an integer
            }

            Solution obj = new Solution();
            System.out.println(obj.findPlatform(arr, dep));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class pair {
    int first;
    char second;

    pair(int key1, char key2)
    {
        this.first = key1;
        this.second = key2;
    }
}
class Solution {
    // Function to find the minimum number of platforms required at the
    // railway station such that no train waits.
    int findPlatform(int arr[], int dep[]) {
        // add your code here
        int n=arr.length;
        ArrayList<pair> order = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            order.add(new pair(arr[i], 'a'));
            order.add(new pair(dep[i], 'd'));
        }
        Collections.sort(order, new Comparator<pair>() {
            public int compare(pair p1, pair p2)
            {
                if (p1.first == p2.first)
                    return new Character(p1.second)
                        .compareTo(
                            new Character(p2.second));

                return p1.first - p2.first;
            }
        });

        int result = 1;
        int occupiedPlatforms = 0;

        for (int i = 0; i < order.size(); i++) {
            pair p = order.get(i);
            if (p.second == 'a')
                occupiedPlatforms++;
            else
                occupiedPlatforms--;

            if (occupiedPlatforms > result)
                result = occupiedPlatforms;
        }
        return result;
    }
}
