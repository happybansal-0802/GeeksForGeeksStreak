Given a string s containing 0's and 1's. You have to return the smallest positive integer C, such that the binary string can be cut into C pieces and each piece should be of the power of 5  with no leading zeros.
Note: The string s is a binary string. And if no such cuts are possible, then return -1.
  Solution:
//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String s = read.readLine();
            Solution ob = new Solution();
            
            System.out.println(ob.cuts(s));
        }
    } 
} 

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int cuts(String s)
    {
        for (int i = 22; i >= 0; i--)
			s = s.replaceAll(Long.toBinaryString((long) Math.pow(5, i)), "#");

		return s.contains("0") ? -1 : s.length();
    }
}
