You are given a number N. Find the total number of setbits in the numbers from 1 to N. 
Your Task:
You do not need to read input or print anything. Your task is to complete the function countBits() which takes N as input parameter and returns the total number of setbits upto N.
  Solution:
//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            long N;
            N = Long.parseLong(br.readLine().trim());
            
            Solution obj = new Solution();
            long res = obj.countBits(N);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static long countBits(long N) {
        long count = 0, idx = 0;

		for (int i = 31; i >= 0; i--)
			count += ((N & (1 << i)) > 0) ? ((i * (1 << i) / 2 + (1 << i) * idx++) + 1) : 0;

		return count;
    }
}
        
