Given a string, S.The string can contain small case English letters or '?'. You can replace '?' with any small English letter. Now if it is possible to make the string S a palindrome after replacing all '?' then find the palindromic string with a minimum ascii sum of the absolute difference of adjacent characters. Otherwise, return -1.
  Solution:
//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String s;
            s = br.readLine();

            Solution obj = new Solution();
            int res = obj.minimumSum(s);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int minimumSum(String s) {
        StringBuilder sb  = new StringBuilder(s);
        
        int ans = 0 , n = sb.length();
        
        for(int i =0; i < n/2 ; i++)
        {
            char ch = sb.charAt(i);
            char ch1 = sb.charAt(n-1-i);
            
            
            if(ch != '?' && ch1 != '?' && ch != ch1)
            return -1;
            
            else if(ch == '?' && ch1 != '?')
            sb.setCharAt(i,ch1); 
            
            else if(ch1 == '?' && ch != '?')
            sb.setCharAt(n-1-i,ch); 
        }
        
        
        char prevChar='.';
        
        for(int i=0 ;i < n/2 ; i++){
            
            char ch = sb.charAt(i);
            
            if(ch !='?')
            {
                
                if(prevChar=='.')
                {
                    prevChar=ch;
                }
                else if(ch != prevChar)
                {
                    ans+=Math.abs(ch-prevChar);
                }
                prevChar=ch;
            }
        }
        
        return ans*2;
        
        
    }
}
