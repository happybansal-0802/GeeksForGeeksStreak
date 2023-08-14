Given an array A containing 2*N+2 positive numbers, out of which 2*N numbers exist in pairs whereas the other two number occur exactly once and are distinct. Find the other two numbers. Return in increasing order.
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
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine();
            String[] S = s.split(" ");
            int[] v = new int[2 * n + 2];
            for(int i = 0; i < 2 * n + 2; i++)
            {
                v[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
            int[] ans = ob.singleNumber(v);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[] singleNumber(int[] nums)
    {
        // Code here
            int xorResult=0;
        for(int num:nums)
        {
            xorResult^=num;
        }
        int rightMostSetBit=xorResult&-xorResult;
        
        int distinct1=0;
        int distinct2=0;
        
        for(int num:nums)
        {
            if((num&rightMostSetBit)!=0)
            {
                distinct1^=num;
            }
            else{
                distinct2^=num;
            }
        }
        if(distinct1<distinct2)
        {
            return new int[]{distinct1,distinct2};
            
        }
        else{
            return new int[]{distinct2,distinct1};
        }
    }
}
