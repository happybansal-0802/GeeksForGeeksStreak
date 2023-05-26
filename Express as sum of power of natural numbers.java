Given two numbers n and x, find out the total number of ways n can be expressed as the sum of the Xth power of unique natural numbers. As the total number of ways can be very large, so return the number of ways modulo 109 + 7.
  Solution:
//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] input = new String[2]; 
            input = br.readLine().split(" "); 
            int n = Integer.parseInt(input[0]); 
            int x = Integer.parseInt(input[1]); 
            Solution ob = new Solution();
            System.out.println(ob.numOfWays(n, x));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{
    static int numOfWays(int n, int x)
    {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (long) Math.pow(i + 1, x);
        }
        int sum = n;
        int  mod =1000000007;
        long[][] dp = new long[n + 1][sum + 1];
        for (int i = 0; i <= n; i++)dp[i][0] = 1;
        for (int j = 1; j <= sum; j++)dp[0][j] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j] % mod;
                if (j >= arr[i - 1])
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - (int) arr[i - 1]]) %mod;
            }
        }
        return (int) (dp[n][sum] % mod);
    }
}
