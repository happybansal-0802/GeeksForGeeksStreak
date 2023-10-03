//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*; 
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
    		System.out.println (new Solution().colName (n));
        }
        
    }
}

// Contributed By: Pranay Bansal 

// } Driver Code Ends


//User function Template for Java

class Solution
{
    String colName (long n)
    {
        // your code here
          StringBuilder colnames=new StringBuilder();
       while(n>0){
           long rem=n%26;
           //remender is 0 
           if(rem==0){
               colnames.append("Z");
               n=(n/26)-1;
           }
           else{
               colnames.append((char)((rem-1)+'A'));
               n=n/26;
           }
       }
       
       //reverse the string builder and convert it to string format 
       String ans=colnames.reverse().toString();
       return ans;
    }
}
