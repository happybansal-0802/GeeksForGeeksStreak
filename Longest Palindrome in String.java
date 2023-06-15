Given a string S, find the longest palindromic substring in S. Substring of string S: S[ i . . . . j ] where 0 ≤ i ≤ j < len(S). Palindrome string: A string that reads the same backward. More formally, S is a palindrome if reverse(S) = S. In case of conflict, return the substring which occurs first ( with the least starting index).
  Solution:
//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestPalin(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static String solve(String S,int l,int h){
        while(l>=0 && h<S.length() && S.charAt(l)==S.charAt(h)){
            l--;
            h++;
        }
        return S.substring(l+1,h);
    }
    static String longestPalin(String S){
        // code here
        String ans="";
        if(S.length()<2)
        return S;
        for(int i=0;i<S.length()-1;i++){
            String even=solve(S,i,i);
            if(even.length()>ans.length()){
                ans=even;
            }
            String odd=solve(S,i,i+1);
            if(odd.length()>ans.length()){
                ans=odd;
            }
        }
        return ans;
    }
}
