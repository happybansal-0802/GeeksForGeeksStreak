Given two strings, find the length of longest subsequence present in both of them. Both the strings are in uppercase latin alphabets.
  Solution:
  //{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {

		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		while(test-- > 0){
		    int p=sc.nextInt();             // Take size of both the strings as input
		    int q=sc.nextInt();
		    
		    String s1=sc.next();            // Take both the string as input
	        String s2=sc.next();
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.lcs(p, q, s1, s2));
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to find the length of longest common subsequence in two strings.
    static int lcs(int x, int y, String s1, String s2)
    {
        // your code here
        int dp[][]=new int[x][y];
        
        for (int i=0;i<x;i++){
            for (int j=0;j<y;j++){
                dp[i][j]=-1;
            }
        }
        
        return lcsUtil(x,y,s1,s2,0,0,dp);
        
        
    }
    
    static int lcsUtil(int x,int y,String s1, String s2,int i,int j,int dp[][]){
        if(i==x )
        return 0;
        
        if(j==y)
        return 0;
        
        if(dp[i][j]!=-1)
        return dp[i][j];
        
        else{
            if( s1.charAt(i)==s2.charAt(j) )
            return dp[i][j] = 1 + lcsUtil(x,y,s1,s2,i+1,j+1,dp);
            else
            return dp[i][j]= Math.max( lcsUtil( x,y,s1,s2,i,j+1,dp )  , lcsUtil( x,y,s1,s2,i+1,j, dp ) );
        }
    }
    
}
