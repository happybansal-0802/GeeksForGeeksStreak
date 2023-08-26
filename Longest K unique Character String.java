Given a string you need to print the size of the longest possible substring that has exactly K unique characters. If there is no possible substring then print -1.
  Solution:
//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
         int st=0,n=s.length(),max=-1;
        Map<Character,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
            if(map.size()>k)
            {
                ch=s.charAt(st++);
                map.put(ch,map.get(ch)-1);
                if(map.get(ch)==0)map.remove(ch);
            }
            if(map.size()==k)max=i-st+1;
        }
        return max;
    }
}
