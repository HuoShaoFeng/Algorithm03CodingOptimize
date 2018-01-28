package Chapter09.Other.Problem100;

public class MailAddress {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,15,100};
        int n = 2 ;
        int ret = getNearest(arr,n);
        System.out.println(ret);
    }

    private static int getNearest(int[] arr, int n) {
        if(arr==null || n<1 || arr.length<n)
            return 0;

        int[][] w = new int[arr.length+1][arr.length+1];

        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1;  j < arr.length; j++) {
                w[i][j] = w[i][j-1]+arr[j] - arr[(i+j)/2];
            }
        }

        int[][] dp = new int[n][arr.length];
        for (int j = 0; j < arr.length; j++) {
            dp[0][j] = w[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = i+1; j < arr.length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k <= j ; k++) {
                    dp[i][j] = Math.min(dp[i][j] , dp[i-1][k] + w[k+1][j]);
                }
            }
        }
        return dp[n-1][arr.length-1];

    }
}
