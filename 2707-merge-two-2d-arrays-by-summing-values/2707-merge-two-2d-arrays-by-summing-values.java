class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int m = nums1.length, n = nums2.length;
        int k = m + n; 
        int x = 0, y = 0;
        int[][] res = new int[k][2];
        int idx = 0; 
        
        while (x < m && y < n) {
            if (nums1[x][0] == nums2[y][0]) {
                int sum = nums1[x][1] + nums2[y][1];
                res[idx][0] = nums1[x][0]; 
                res[idx][1] = sum; 
                x++; y++; 
            } else if (nums1[x][0] < nums2[y][0]) {
                res[idx][0] = nums1[x][0]; 
                res[idx][1] = nums1[x][1];
                x++; 
            } else {
                res[idx][0] = nums2[y][0]; 
                res[idx][1] = nums2[y][1];
                y++; 
            }
            idx++; 
        }
        
        
        while (x < m) {
            res[idx][0] = nums1[x][0];
            res[idx][1] = nums1[x][1];
            x++;
            idx++;
        }
    
        while (y < n) {
            res[idx][0] = nums2[y][0];
            res[idx][1] = nums2[y][1];
            y++;
            idx++;
        }
        return Arrays.copyOf(res, idx);
    }
}
