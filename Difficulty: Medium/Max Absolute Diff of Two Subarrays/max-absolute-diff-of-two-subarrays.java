class Solution {
    static int[] buildLeftMax(int[] arr)
    {
        int n = arr.length;
        int[] leftMax = new int[n];
        int curr = arr[0];
        int best = arr[0];
        leftMax[0] = best;
        for (int i = 1; i < n; i++) {
            curr = Math.max(arr[i], curr + arr[i]);
            best = Math.max(best, curr);
            leftMax[i] = best;
        }

        return leftMax;
    }
    static int[] buildRightMax(int[] arr)
    {
        int n = arr.length;

        int[] rightMax = new int[n];

        int curr = arr[n - 1];
        int best = arr[n - 1];

        rightMax[n - 1] = best;

        for (int i = n - 2; i >= 0; i--) {
            curr = Math.max(arr[i], curr + arr[i]);
            best = Math.max(best, curr);

            rightMax[i] = best;
        }

        return rightMax;
    }

    static int maxDiffSubArrays(int[] arr)
    {
        int n = arr.length;
        int[] leftMax = buildLeftMax(arr);
        int[] rightMax = buildRightMax(arr);
        int[] inverted = arr.clone();

        for (int i = 0; i < n; i++)
            inverted[i] = -inverted[i];
        int[] leftMin = buildLeftMax(inverted);
        int[] rightMin = buildRightMax(inverted);
        for (int i = 0; i < n; i++)
            leftMin[i] = -leftMin[i];

        for (int i = 0; i < n; i++)
            rightMin[i] = -rightMin[i];

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n - 1; i++) {
            int option1
                = Math.abs(leftMax[i] - rightMin[i + 1]);
            int option2= Math.abs(leftMin[i] - rightMax[i + 1]);
            res = Math.max(res, Math.max(option1, option2));
        }

        return res;
    }
}