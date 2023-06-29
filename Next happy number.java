For a given non-negative integer N, find the next smallest Happy Number. A number is called Happy if it leads to 1 after a sequence of steps. Wherein at each step the number is replaced by the sum of squares of its digits that is, if we start with Happy Number and keep replacing it with sum of squares of its digits, we reach 1 at some point.
  solution:
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
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.nextHappy(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{

    static int nextHappy(int N){
        // code here
         while(true){
            if(isHappy(++N)) return N;
        }
    }
    
    static boolean isHappy(int n){
        if(n>9){
            int res = 0;
            while(n>0){
                res+= (n%10)*(n%10);
                n/=10;
            }
            return isHappy(res);
        }
        
        if(n == 7 || n == 1) return true;
        else return false;
    }
}
