Given three integers n, k, target, and an array of coins of size n. Find if it is possible to make a change of target cents by using an infinite supply of each coin but the total number of coins used must be exactly equal to k.
  Solution:
//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int N;
            N = Integer.parseInt(br.readLine());

            int K;
            K = Integer.parseInt(br.readLine());

            int target;
            target = Integer.parseInt(br.readLine());

            int[] coins = IntArray.input(br, N);

            Solution obj = new Solution();
            boolean res = obj.makeChanges(N, K, target, coins);

            int _result_val = (res) ? 1 : 0;
            System.out.println(_result_val);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static boolean makeChanges(int N, int K, int target, int[] coins) {
        // code here
         Boolean[][] dp= new Boolean[target+1][K+1];
        
        for(int i=0;i<target+1;i++) Arrays.fill(dp[i],null);

        dp[0][0]=true;
        
        return makeChangesReal(N,K,target,coins,dp);
        
    }
    
    public static boolean makeChangesReal(int N, int K, int target, int[] coins,Boolean[][] dp) {
        
        if(K==0 && target==0) return true;
        
        if(K<=0 || target <=0) return false;
        
        boolean ans=false;
        for(int i=0;i<N;i++){
            if(target>=coins[i] && (K-1) >=0){
                if(dp[target-coins[i]][K-1]!=null) ans= ans || dp[target-coins[i]][K-1];
                else ans = ans || makeChangesReal(N,K-1,target-coins[i],coins,dp); 
            }
            
        }
        dp[target][K]= ans;
        
        return ans;
    }
}
