//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG implements Runnable {
    public void run() {
        try {
            BufferedReader in;
            PrintWriter out;
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            int t = Integer.parseInt(in.readLine());

            while (t-- > 0) {
                int n = Integer.parseInt(in.readLine().trim());

                Solution g = new Solution();
                out.println(g.countWays(n));
            }
            out.close();
        } catch (Exception e) {
            ;
        }
    }

    public static void main(String args[]) throws IOException {
        new Thread(null, new GFG(), "whatever", 1 << 26).start();
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to count the number of ways in which frog can reach the top.
    public static int mod = 1000000007;
    public static long fun(int n, long [] dp){
        if(n ==0) return 1;
        if(n<0) return 0;
        
        if(dp[n] != -1) return dp[n];
        long first = fun(n-1, dp);
        long second = fun(n-2, dp);
        long third = fun(n-3, dp);
        
        return dp[n] = (first + second + third)%mod;
    }
    static long countWays(int n)
    {
        // add your code here
        long [] dp = new long[n+1];
        for(int i=0; i<dp.length; i++) dp[i] = -1;
        return fun(n, dp);
    }
    
}

