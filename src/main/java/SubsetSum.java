public class SubsetSum {

    /**
     * Computes if there exits a subset S of A, such that the sum of all elements in S
     * is equal to Z
     * @param A List of integers
     * @param Z Target sum
     */
    public static boolean subsetSumPossible(int[] A, int Z) {
        // Initialize DP Table
        boolean[][] dp = new boolean[A.length + 1][Z + 1];

        // Base cases
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }

        for (int j = 1; j < dp[0].length; j++) {
            dp[0][j] = false;
        }

        // Recursive calculation
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if ((dp[i-1][j]) || (j >= A[i-1] && dp[i-1][j-A[i-1]])) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = false;
                }
            }
        }

        // Return solution
        return dp[A.length][Z];
    }
}
