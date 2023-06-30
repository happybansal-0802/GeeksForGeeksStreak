Given a number in its binary form find if the given binary number is a multiple of 3. It is recommended to finish the task using one traversal of input binary number.

Solution:
//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
        {
            BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out=new PrintWriter(System.out);
            int t = Integer.parseInt(in.readLine().trim());
            while(t-->0)
                {
                    String s = in.readLine().trim();
                    Solution ob = new Solution();
                    out.println(ob.isDivisible(s));
                }
                out.close();
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution {
    int isDivisible(String s) {
        // code here
        int n=s.length();
     char st='0';
     int i=0;
     while(i<n){
         if(s.charAt(i)=='0'){
             if(st=='0'){
                 i++;
                 continue;
             }
             else if(st=='1'){
                 st='2';
             }
             else{
                 st='1';
             }
         }
         else{
             if(st=='0'){
                 st='1';
             }
             else if(st=='1'){
                 st='0';
             }
             else{
                 i++;
                 continue;
             }
         }
        i++; 
     }
     if(st=='0'){
         return 1;
     }
     else{
         return 0;
     }
    }
}
